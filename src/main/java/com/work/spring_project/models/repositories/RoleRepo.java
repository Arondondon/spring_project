package com.work.spring_project.models.repositories;

import com.work.spring_project.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
