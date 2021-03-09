package com.example.FinalProject.domain;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="orders")
public class OrderDO {
    @Id
    @Column(name = "order_id",unique=true, nullable = false)
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne //(fetch = FetchType.LAZY, targetEntity = CustomerDO.class)
    @JoinColumn(name = "customer_id")
    private CustomerDO customer;

    @ManyToOne  //(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeDO employee;

    //@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false, name = "order_date", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    //@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
   
    private Date requiredDate;

    //@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date shippedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDO customer) {
        this.customer = customer;
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

    public void setRequireDate(Date requireDate) {
        this.requiredDate = requireDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public EmployeeDO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDO employee) {
        this.employee = employee;
    }

}
