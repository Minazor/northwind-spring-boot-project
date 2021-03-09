package com.example.FinalProject.repository;

import java.util.Optional;

import com.example.FinalProject.domain.CustomerDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDO,String>{
    Optional<CustomerDO> findByCompanyName(String companyName);
}
