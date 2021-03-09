package com.example.FinalProject.service;

import java.util.List;

import com.example.FinalProject.domain.EmployeeDO;
import com.example.FinalProject.dto.EmployeeDTO;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeDO createEmployee(EmployeeDO employee);
    EmployeeDTO updatEmployee(EmployeeDO employee);
    void deleteEmployee(Long employeeId);
    EmployeeDO getEmployee(Long employeeId);
    EmployeeDO getEmployeeByFirstName(String employeeName);
    EmployeeDO getEmployeeByLastName(String employeeSurname);
    List<EmployeeDO> getEmployeeByTitle(String employeeTitle);
    List<EmployeeDO> getEmployeeByTitleOfCourtesy(String employeeCourtesy);
    List<EmployeeDO> getAllEmployees();
}
