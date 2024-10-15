package com.maharjanworks.employee_managment_app.repository;

import com.maharjanworks.employee_managment_app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
