package com.dcl.accommodate.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "User")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "User_id")
    private UUID userId;
    @Column(name="first_name" , nullable = false)
    private  String firstname;
    @Column(name="last_name" , nullable = false)
    private  String lastname;
    @Column(name="date_of_birth")
    private Data dateOfBirth;
    @Column(name="User_Role")
    @Enumerated(EnumType.STRING )
    private UserRole  userRole;
    @Column(name="email")
    private String email;
    @Column(name="password", nullable = false)
    private  String password;
    @Column(name="avatar")
    private String avatar;
    @Column(name="create_date", nullable = false, updatable = false)
    @CreatedDate
    private Instant createDate;
    @Column(name="LastModified_Date")
    @LastModifiedDate
    private Instant lastModifiedDate;



}
