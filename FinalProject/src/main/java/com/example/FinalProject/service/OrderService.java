package com.example.FinalProject.service;

import java.sql.Date;
import java.util.List;


import com.example.FinalProject.domain.OrderDO;
import com.example.FinalProject.dto.OrderDTO;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderDO createOrder(OrderDO order);
    OrderDTO updateOrder(OrderDO order);
    void deleteOrder(Long orderId);
    OrderDO getOrder(Long orderId);
    List<OrderDO> getOrderByDate(Date orderDate);
    List<OrderDO> getOrderByRequiredDate(Date orderRequiredDate);
    List<OrderDO> getOrderByShippedDate(Date orderShipDate);
    List<OrderDO> getCustomer(String customerId);
    List<OrderDO> getEmployee(Long employeeId);
    List<OrderDO> getAllOrders();
}
