package com.dcl.accommodate.model;

import com.dcl.accommodate.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable=false)
    private UUID userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name ="last_name" , nullable = false)
    private String lastName;

    @Column(name = "date_of_birth" ,nullable = false,updatable = false)
    private LocalDate dateOfBirth;

    @Column(name = "user_role" ,nullable = false)
    @Enumerated(EnumType.STRING )
    private UserRole UserRole;

    @Column(name = "email", nullable = false , unique = true)
    private String email ;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "created_at", nullable = false,updatable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "last_updated_at")
    @UpdateTimestamp
    private Instant lastUpdatedAt;
}
