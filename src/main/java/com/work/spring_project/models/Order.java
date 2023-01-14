package com.work.spring_project.models;

import javax.persistence.*;

@Entity
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    private String delivery_to, delivery_from, commentary;

    private boolean delivery_out_of_town, oversized_delivery;

    private int total_price;

    public Order() {}

    public int calculatePrice(){
        int calcPrice;

        if(service.getMin_price() > car.getMin_price()){
            calcPrice = service.getMin_price();
        } else {
            calcPrice = car.getMin_price();
        }

        if(delivery_out_of_town){
            calcPrice += 300;
        }

        if(oversized_delivery){
            calcPrice += 300;
        }

        return calcPrice;
    }

    public Order(User user, Service service, Car car, String delivery_to,
                 String delivery_from, String commentary, boolean delivery_out_of_town,
                 boolean oversized_delivery) {
        this.user = user;
        this.service = service;
        this.car = car;
        this.delivery_to = delivery_to;
        this.delivery_from = delivery_from;
        this.commentary = commentary;
        this.delivery_out_of_town = delivery_out_of_town;
        this.oversized_delivery = oversized_delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDelivery_to() {
        return delivery_to;
    }

    public void setDelivery_to(String deliveryTo) {
        this.delivery_to = deliveryTo;
    }

    public String getDelivery_from() {
        return delivery_from;
    }

    public void setDelivery_from(String deliveryFrom) {
        this.delivery_from = deliveryFrom;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public boolean isDelivery_out_of_town() {
        return delivery_out_of_town;
    }

    public void setDelivery_out_of_town(boolean deliveryOutOfTown) {
        this.delivery_out_of_town = deliveryOutOfTown;
    }

    public boolean isOversized_delivery() {
        return oversized_delivery;
    }

    public void setOversized_delivery(boolean oversizedDelivery) {
        this.oversized_delivery = oversizedDelivery;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
}
