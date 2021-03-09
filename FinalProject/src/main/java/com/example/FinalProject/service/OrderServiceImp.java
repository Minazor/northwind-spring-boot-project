package com.example.FinalProject.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.example.FinalProject.domain.OrderDO;
import com.example.FinalProject.dto.OrderDTO;
import com.example.FinalProject.repository.OrderRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDO createOrder(OrderDO order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderDTO updateOrder(OrderDO order) {
        long orderId = order.getId();
        Optional<OrderDO> currentOrder = orderRepository.findById(orderId);
        if (currentOrder.isPresent()) {
            currentOrder.get().setOrderDate(order.getOrderDate());
            currentOrder.get().setRequireDate(order.getRequiredDate());
            currentOrder.get().setShippedDate(order.getShippedDate());

            orderRepository.save(currentOrder.get());

            OrderDTO orderDTO = new ModelMapper().map(currentOrder.get(), OrderDTO.class);
            return orderDTO;
        }
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) {
        Optional<OrderDO> currentOrder = orderRepository.findById(orderId);
        if (currentOrder.isPresent()) {
            orderRepository.deleteById(orderId);
        }

    }

    @Override
    public OrderDO getOrder(Long orderId) {
        Optional<OrderDO> currentOrder = orderRepository.findById(orderId);
        if (currentOrder.isPresent()) {
            return currentOrder.get();
        }
        return null;
    }

    @Override
    public List<OrderDO> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderDO> getOrderByDate(Date orderDate) {
        Optional<List<OrderDO>> currentOrder = orderRepository.findByOrderDate(orderDate);
        if (currentOrder.isPresent()) {
            return currentOrder.get();
        }
        return null;
    }

    @Override
    public List<OrderDO> getOrderByRequiredDate(Date orderRequiredDate) {
        Optional<List<OrderDO>> currentOrderR = orderRepository.findByRequiredDate(orderRequiredDate);
        if (currentOrderR.isPresent()) {
            return currentOrderR.get();
        }
        return null;
    }

    @Override
    public List<OrderDO> getOrderByShippedDate(Date orderShippedDate) {
        Optional<List<OrderDO>> currentOrderR = orderRepository.findByShippedDate(orderShippedDate);
        if (currentOrderR.isPresent()) {
            return currentOrderR.get();
        }
        return null;
    }

    @Override
    public List<OrderDO> getCustomer(String customerId) {
        Optional<List<OrderDO>> currentOrderC=orderRepository.findByCustomerId(customerId);
        if (currentOrderC.isPresent()) {
            return currentOrderC.get();
        }
        return null;
    }

    @Override
    public List<OrderDO> getEmployee(Long employeeId) {
        Optional<List<OrderDO>> currentOrderE=orderRepository.findByEmployeeId(employeeId);
        if (currentOrderE.isPresent()) {
            return currentOrderE.get();
        }
        return null;
    }
}