package com.madhukarnati.emp.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.madhukarnati.emp.model.Employee;

/**
 * Repository for Employee Entity
 */
@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
}
