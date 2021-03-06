package com.example.FinalProject.controller;

import java.util.List;

import com.example.FinalProject.domain.CustomerDO;
import com.example.FinalProject.dto.CustomerDTO;
import com.example.FinalProject.service.CustomerService;

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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/hello")
    String hello() {
        return "Hello World!";
    }
    @ApiOperation(value = "Creates new customer")
    @PostMapping(path = "/customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerDO> createCustomer(@RequestBody CustomerDO customerDO) {
        CustomerDO createdCustomer = customerService.createCustomer(customerDO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Updates an existing customer")
    @PutMapping(path = "/customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDO customerDO) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(customerDO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Gets customer by id")
    @GetMapping(path = "/customers-by-id/{customerId}")
    public ResponseEntity<CustomerDO> getCustomer(@PathVariable(value = "customerId") String customerId) {
        CustomerDO customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets customer by company name")
    @GetMapping(path = "/customers-by-company-name/{companyName}")
    public ResponseEntity<CustomerDO> getCustomerCompany(@PathVariable(value = "companyName") String companyName) {
        CustomerDO customer = customerService.getCustomerCompany(companyName);
       
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets all customers")
    @GetMapping(path = "/customers")
    public ResponseEntity<List<CustomerDO>> getAllCustomers() {
        List<CustomerDO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes customer by id")
    @DeleteMapping(path = "/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "customerId") String customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer with id: " + customerId + " is deleted.", HttpStatus.OK);
    }
}
