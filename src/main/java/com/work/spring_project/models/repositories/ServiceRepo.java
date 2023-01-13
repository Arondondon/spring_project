package com.work.spring_project.models.repositories;

import com.work.spring_project.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service, Long> {
}
