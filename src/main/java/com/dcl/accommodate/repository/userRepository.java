package com.dcl.accommodate.repository;

import com.dcl.accommodate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface userRepository extends JpaRepository<User, UUID> {
}
