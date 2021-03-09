package com.example.FinalProject.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.FinalProject.domain.CustomerDO;
import com.example.FinalProject.dto.CustomerDTO;

import org.springframework.stereotype.Service;

@Service
@Transactional
public interface CustomerService {
    CustomerDO createCustomer(CustomerDO customer);
    CustomerDTO updateCustomer(CustomerDO customer);
    void deleteCustomer(String customerId);
    CustomerDO getCustomer(String customerId);
    CustomerDO getCustomerCompany(String companyName);
    List<CustomerDO> getAllCustomers();
}
