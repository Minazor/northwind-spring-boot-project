package com.example.FinalProject.controller;

import com.example.FinalProject.domain.OrderDO;
import com.example.FinalProject.dto.OrderDTO;
import com.example.FinalProject.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "Creates new order")
    @PostMapping(path = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderDO> createOrder(@RequestBody OrderDO orderDO) {
        OrderDO createdOrder = orderService.createOrder(orderDO);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
    
    @ApiOperation(value = "Updates an existing order")
    @PutMapping(path="/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDO orderDO){
    OrderDTO updatedOrder = orderService.updateOrder(orderDO);
    return new ResponseEntity<>(updatedOrder, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deletes order by id")
    @DeleteMapping(path = "/order/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable(value = "orderId") Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>("Order with id: " + orderId + " is deleted.", HttpStatus.OK);
    }

    @ApiOperation(value="Gets order by id")
    @GetMapping(path="/orders-by-id/{orderId}")
    public ResponseEntity<OrderDO> getOrder(@PathVariable(value="orderId") Long orderId){
        OrderDO order=orderService.getOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }
    @ApiOperation(value="Gets order by date")
    @GetMapping(path = "/orders-by-date/{orderDate}")
    public ResponseEntity<List<OrderDO>> getOrderByDate(@PathVariable(value = "orderDate") Date orderDate){
        List<OrderDO> orderDates=orderService.getOrderByDate(orderDate);
        return new ResponseEntity<>(orderDates,HttpStatus.OK);
    }

    @ApiOperation(value="Gets order by required date")
    @GetMapping(path="/orders-by-required-date/{requiredDate}")
    public ResponseEntity<List<OrderDO>> getOrderByRequiredDate(@PathVariable(value = "requiredDate")Date requiredDate){
        List<OrderDO> orderRequiredDates=orderService.getOrderByRequiredDate(requiredDate);
        return new ResponseEntity<>(orderRequiredDates,HttpStatus.OK);
    }

    @ApiOperation(value="Gets order by shipped date")
    @GetMapping(path="/orders-by-shipped-date/{shippedDate}")
    public ResponseEntity<List<OrderDO>> getOrderByShippedDate(@PathVariable(value = "shippedDate") Date shippedDate){
        List<OrderDO> orderShippedDates=orderService.getOrderByShippedDate(shippedDate);
        return new ResponseEntity<>(orderShippedDates,HttpStatus.OK);
    }

    @ApiOperation(value = "Gets order by customer")
    @GetMapping(path="/orders-by-customer-id/{customerId}")
    public ResponseEntity<List<OrderDO>> getOrderByCustomer(@PathVariable(value = "customerId") String customerId){
        List<OrderDO> orderCustomer=orderService.getCustomer(customerId);
        return new ResponseEntity<>(orderCustomer,HttpStatus.OK);
    }
    
    @ApiOperation(value = "Gets order by employee")
    @GetMapping(path="/orders-by-employee-id/{employeeId}")
    public ResponseEntity<List<OrderDO>> getOrderByEmployee(@PathVariable(value = "employeeId") Long employeeId){
        List<OrderDO> orderEmployee=orderService.getEmployee(employeeId);
        return new ResponseEntity<>(orderEmployee,HttpStatus.OK);
    }

    @ApiOperation(value="Gets all orders")
    @GetMapping(path="/orders")
    public ResponseEntity<List<OrderDO>> getAllOrders(){
        List<OrderDO> allOrders=orderService.getAllOrders();
        return new ResponseEntity<>(allOrders,HttpStatus.OK);
    }
    
}




