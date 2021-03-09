package com.example.FinalProject.controller;

import java.util.List;

import com.example.FinalProject.domain.EmployeeDO;
import com.example.FinalProject.dto.EmployeeDTO;
import com.example.FinalProject.service.EmployeeService;

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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value="Creates new employee")
    @PostMapping(path = "/employee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EmployeeDO> createEmployee(@RequestBody EmployeeDO employeeDO){
        EmployeeDO createdEmployee = employeeService.createEmployee(employeeDO);
        return new ResponseEntity<>(createdEmployee,HttpStatus.CREATED);
    }

    @ApiOperation(value = "Updates an existing employee")
    @PutMapping(path = "/employee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDO employeeDO){
        EmployeeDTO updatedEmployee=employeeService.updatEmployee(employeeDO);
        return new ResponseEntity<>(updatedEmployee,HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deletes employee by id")
    @DeleteMapping(path = "/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee with id: " + employeeId + " is deleted.", HttpStatus.OK);
    }

    @ApiOperation(value = "Gets employee by id")
    @GetMapping(path = "/employees-by-id/{employeeId}")
    public ResponseEntity<EmployeeDO> getEmployee(@PathVariable(value="employeeId") Long employeeId){
        EmployeeDO employee=employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @ApiOperation(value = "Gets employee by firstname")
    @GetMapping(path="/employees-by-first-name/{employeeFirstName}")
    public ResponseEntity<EmployeeDO> getEmployeeByName(@PathVariable(value = "employeeFirstName")String employeeName){
        EmployeeDO employee=employeeService.getEmployeeByFirstName(employeeName);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @ApiOperation(value = "Gets employee by lastname")
    @GetMapping(path="/employees-by-last-name/{employeeLastName}")
    public ResponseEntity<EmployeeDO> getEmployeeByLastName(@PathVariable(value = "employeeLastName")String employeeLastName){
        EmployeeDO employee=employeeService.getEmployeeByLastName(employeeLastName);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @ApiOperation(value = "Gets employee by title")
    @GetMapping(path = "/employees-by-title/{employeeTitle}")
    public ResponseEntity<List<EmployeeDO>> getEmployeeByTitle(@PathVariable(value = "employeeTitle")String employeeTitle){
        List<EmployeeDO> employee=employeeService.getEmployeeByTitle(employeeTitle);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @ApiOperation(value = "Gets employee by title of courtesy")
    @GetMapping(path = "/employees-by-title-of-courtesy/{employeeTitleCourtesy}")
    public ResponseEntity<List<EmployeeDO>> getEmployeeByTitleOfCourtesy(@PathVariable(value = "employeeTitleCourtesy")String employeeTitleCourtesy){
        List<EmployeeDO> employee=employeeService.getEmployeeByTitleOfCourtesy(employeeTitleCourtesy);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }


    @ApiOperation(value="Gets all employees")
    @GetMapping(path="/employees")
    public ResponseEntity<List<EmployeeDO>> getAllEmployees(){
        List<EmployeeDO> allOrders=employeeService.getAllEmployees();
        return new ResponseEntity<>(allOrders,HttpStatus.OK);
    }
}
