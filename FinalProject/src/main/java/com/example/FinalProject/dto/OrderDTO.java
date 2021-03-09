package com.example.FinalProject.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


//@Entity
//@Table(name = "orders")
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="order_id")
	private int orderId;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonProperty("customer")
    private CustomerDTO customerDTO;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @JsonProperty("employee")
    private EmployeeDTO employeeDTO;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public CustomerDTO getCustomer() {
        return customerDTO;
    }

    public void setCustomer(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public EmployeeDTO getEmployee() {
        return employeeDTO;
    }

    public void setEmployee(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

}
