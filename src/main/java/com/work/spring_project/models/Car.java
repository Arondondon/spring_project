package com.work.spring_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, description;

    private int min_price, max_length;

    public Car() {}

    public Car(String name, String description, int max_length, int min_price) {
        this.name = name;
        this.description = description;
        this.min_price = min_price;
        this.max_length = max_length;
    }

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

    public int getMax_length() {
        return max_length;
    }

    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }
}
