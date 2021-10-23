package com.simplilearn.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.webservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
