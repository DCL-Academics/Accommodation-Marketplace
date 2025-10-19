package com.dcl.accommodate.security.filters;

import com.dcl.accommodate.security.jwt.JwtService;
import com.dcl.accommodate.security.jwt.JwtType;
import com.dcl.accommodate.security.util.CurrentUser;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final JwtType jwtType;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(CurrentUser.getAuthentication().isPresent())
        {
            log.info("user already authenticated");
            doFilter(request,response,filterChain);
        }

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(token==null) logAndForward("Invalid JWT Token",request, response, filterChain);

        var subToken = token.substring(7);

        if(subToken.isBlank()) logAndForward("Token is blank",request,response,filterChain);

        var jws = jwtService.getClaims(subToken);

        var typeInJwtObject = jws.getHeader().get("type");
        String typeInJwt = null;
        if(typeInJwtObject!=null && typeInJwtObject instanceof String type)
            typeInJwt=type;
        else logAndForward("Invalid JWT type",request,response,filterChain);

        if (typeInJwt == null || !typeInJwt.equalsIgnoreCase(jwtType.name()))
            logAndForward("Invalid JWT type",request,response,filterChain);

        Claims claims = jws.getBody();
        String userId = claims.getSubject();

        if(userId == null) logAndForward("Invalid userId",request,response,filterChain);

        var roleInJwt = claims.get("roleInJwt");

        String role = null;

        if (roleInJwt != null && roleInJwt instanceof String r)
            role = r;

        List<GrantedAuthority> authorities = null;

        if(role == null) authorities = List.of();
        else authorities = List.of(new SimpleGrantedAuthority(role));

        var unPwdToken = new UsernamePasswordAuthenticationToken(userId,null,authorities);

        CurrentUser.setAuthentication(unPwdToken);
    }

    private void logAndForward(String message,HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.warn(message);
        doFilter(request, response, filterChain);
    }
}