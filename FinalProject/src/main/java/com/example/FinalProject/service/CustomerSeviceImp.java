package com.example.FinalProject.service;

import java.util.List;
import java.util.Optional;

import com.example.FinalProject.domain.CustomerDO;
import com.example.FinalProject.dto.CustomerDTO;
import com.example.FinalProject.repository.CustomerRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSeviceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDO createCustomer(CustomerDO customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDO customer) {
        String customerId=customer.getId();
        Optional<CustomerDO> currentCustomer = customerRepository.findById(customerId);
        if (currentCustomer.isPresent()) {
            currentCustomer.get().setCompanyName(customer.getCompanyName());
            currentCustomer.get().setContactName(customer.getContactName());
            currentCustomer.get().setContactTitle(customer.getContactTitle());
            currentCustomer.get().setAddress(customer.getAddress());
        

            customerRepository.save(currentCustomer.get());

            CustomerDTO customerDTO = new ModelMapper().map(currentCustomer.get(), CustomerDTO.class);
            return customerDTO;
        }
        return null;
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerDO> currentCustomer = customerRepository.findById(customerId);
        if (currentCustomer.isPresent()) {
            customerRepository.deleteById(customerId);
    }
}

    @Override
    public CustomerDO getCustomer(String customerId) {
        Optional<CustomerDO> currentCustomer = customerRepository.findById(customerId);
        if (currentCustomer.isPresent()) {
            return currentCustomer.get();
        }
        return null;
    }

    @Override
    public CustomerDO getCustomerCompany(String companyName) {
        Optional<CustomerDO> currentCustomer = customerRepository.findByCompanyName(companyName);
        if (currentCustomer.isPresent()) {
            return currentCustomer.get();
        }
        return null;
    }

    @Override
    public List<CustomerDO> getAllCustomers() {
        return customerRepository.findAll();
    }
    
}
