package com.work.spring_project.models.repositories;

import com.work.spring_project.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Override
    Optional<Order> findById(Long along);
}
