package com.work.spring_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private Long id;

    private String name, description;

    private int min_price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMin_price() {
        return min_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }
}

