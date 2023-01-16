package com.work.spring_project.models.repositories;

import com.work.spring_project.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepo extends JpaRepository<Service, Long> {
    @Override
    Optional<Service> findById(Long aLong);
}
