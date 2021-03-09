package com.example.FinalProject.repository;

import java.util.*;

import com.example.FinalProject.domain.EmployeeDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDO, Long> {
    Optional<EmployeeDO> findByFirstName(String name);
    Optional<EmployeeDO> findByLastName(String surname);
    Optional<List<EmployeeDO>> findByTitle(String title);
    Optional<List<EmployeeDO>> findByTitleOfCourtesy(String titleOfCourtesy);
}