package com.maharjanworks.employee_managment_app.service;

import com.maharjanworks.employee_managment_app.exception.EmployeeNotFoundException;
import com.maharjanworks.employee_managment_app.model.Employee;
import com.maharjanworks.employee_managment_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee register(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getById(Long id){
        return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee id: "+ id + " not found."));
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }


    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }






}
