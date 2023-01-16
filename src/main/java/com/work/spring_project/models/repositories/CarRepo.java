package com.work.spring_project.models.repositories;

import com.work.spring_project.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepo extends JpaRepository<Car, Long> {
    @Override
    Optional<Car> findById(Long aLong);
}
