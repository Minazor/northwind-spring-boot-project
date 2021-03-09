package com.example.FinalProject.service;

import java.util.List;
import java.util.Optional;

import com.example.FinalProject.domain.EmployeeDO;
import com.example.FinalProject.dto.EmployeeDTO;
import com.example.FinalProject.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDO createEmployee(EmployeeDO employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO updatEmployee(EmployeeDO employee) {
        long employeeId = employee.getId();
        Optional<EmployeeDO> currentEmployee = employeeRepository.findById(employeeId);
        if (currentEmployee.isPresent()) {
            currentEmployee.get().setFirstName(employee.getFirstName());
            currentEmployee.get().setLastName(employee.getLastName());
            currentEmployee.get().setTitle(employee.getTitle());
            currentEmployee.get().setTitleOfCourtesy(employee.getTitleOfCourtesy());
            currentEmployee.get().setHireDate(employee.getHireDate());

            employeeRepository.save(currentEmployee.get());

            EmployeeDTO employeeDTO = new ModelMapper().map(currentEmployee.get(), EmployeeDTO.class);
            return employeeDTO;
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Optional<EmployeeDO> currentEmployee = employeeRepository.findById(employeeId);
        if (currentEmployee.isPresent()) {
            employeeRepository.deleteById(employeeId);
        }
    }

    @Override
    public EmployeeDO getEmployee(Long employeeId) {
        Optional<EmployeeDO> currentEmployee = employeeRepository.findById(employeeId);
        if (currentEmployee.isPresent()) {
            return currentEmployee.get();
        }
        return null;
    }

    @Override
    public EmployeeDO getEmployeeByFirstName(String employeeName) {
        Optional<EmployeeDO> currentEmployee = employeeRepository.findByFirstName(employeeName);
        if (currentEmployee.isPresent()) {
            return currentEmployee.get();
        }
        return null;
    }

    @Override
    public EmployeeDO getEmployeeByLastName(String employeeSurname) {
        Optional<EmployeeDO> currentEmployee = employeeRepository.findByLastName(employeeSurname);
        if (currentEmployee.isPresent()) {
            return currentEmployee.get();
        }
        return null;
    }

    @Override
    public List<EmployeeDO> getEmployeeByTitle(String employeeTitle) {
        Optional<List<EmployeeDO>> currentEmployee = employeeRepository.findByTitle(employeeTitle);
        if (currentEmployee.isPresent()) {
            return currentEmployee.get();
        }
        return null;
    }

    @Override
    public List<EmployeeDO> getEmployeeByTitleOfCourtesy(String employeeCourtesy) {
        Optional<List<EmployeeDO>> currentEmployee = employeeRepository.findByTitleOfCourtesy(employeeCourtesy);
        if (currentEmployee.isPresent()) {
            return currentEmployee.get();
        }
        return null;
    }

    @Override
    public List<EmployeeDO> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
}
