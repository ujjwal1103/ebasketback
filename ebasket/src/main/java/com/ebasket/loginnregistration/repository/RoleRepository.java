package com.ebasket.loginnregistration.repository;

import java.util.Optional;

import com.ebasket.loginnregistration.models.ERole;
import com.ebasket.loginnregistration.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
