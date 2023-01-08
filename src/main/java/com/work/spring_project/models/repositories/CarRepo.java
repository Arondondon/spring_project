package com.work.spring_project.models.repositories;

import com.work.spring_project.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<Car, Long> {
}
