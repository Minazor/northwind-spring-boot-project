package com.example.FinalProject.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.example.FinalProject.domain.OrderDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDO, Long> {
    Optional <List<OrderDO>> findByOrderDate(Date orderDate);
    Optional <List<OrderDO>> findByRequiredDate(Date orderRequiredDate);
    Optional <List<OrderDO>> findByShippedDate(Date orderShipDate);
	Optional <List<OrderDO>> findByCustomerId(String customerId);
    Optional <List<OrderDO>> findByEmployeeId(Long employeeId);
}
