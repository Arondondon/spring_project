package com.work.spring_project.models.repositories;

import com.work.spring_project.models.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepo extends CrudRepository<Service, Long> {
}
