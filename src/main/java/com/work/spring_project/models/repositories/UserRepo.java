package com.work.spring_project.models.repositories;

import com.work.spring_project.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
