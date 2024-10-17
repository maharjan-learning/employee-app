package com.maharjanworks.employee_managment_app.controller;

import com.maharjanworks.employee_managment_app.model.Employee;
import com.maharjanworks.employee_managment_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(value = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<Employee> register(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.register(employee), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.of(Optional.ofNullable(employeeService.getEmployees()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
