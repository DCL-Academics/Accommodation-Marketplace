package com.dcl.accommodate.config;

import io.jsonwebtoken.Jwt;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Setter
@Getter
@Component
public class AppEnv {
    private Jwt jwt;

    @Getter
    @Setter
    public static class Jwt{
        private String secret;
    }
}
