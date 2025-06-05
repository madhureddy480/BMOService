package com.madhukarnati.emp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhukarnati.emp.BMOServiceApplication;
import com.madhukarnati.emp.model.Employee;
import com.madhukarnati.emp.service.EmployeeService;

import reactor.core.publisher.Mono;

/**
 * ReST Controller
 */

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private static final Logger log = LoggerFactory.getLogger(BMOServiceApplication.class);
	@Autowired
	private EmployeeService employeeService;
	
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Employee>> getUserById(@PathVariable("id") String id) {
    	log.info("Request Received:{}",id);
        return employeeService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
