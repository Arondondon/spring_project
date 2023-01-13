package com.work.spring_project.models.repositories;

import com.work.spring_project.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {
}
