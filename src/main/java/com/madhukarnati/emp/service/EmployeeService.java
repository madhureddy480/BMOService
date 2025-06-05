package com.madhukarnati.emp.service;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhukarnati.emp.model.Employee;
import com.madhukarnati.emp.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service class to apply logic for business transformations on the database result.
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public Mono<Employee> findById(String id) {
		
		// Non-blocking delay - to mimic network or IO delay. This is only for interview prospective.
		 
		/*
			int delayMillis = ThreadLocalRandom.current().nextInt(100, 1000);
		    Duration delay = Duration.ofMillis(delayMillis);
		    
		    return repository.findById(id)
		            .delayElement(delay); 
	            
	      */
		return repository.findById(id);
	}
	
	public Flux<Employee> findAll(){
		return repository.findAll();
	}
}
