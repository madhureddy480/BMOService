package com.madhukarnati.emp.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.madhukarnati.emp.controller.EmployeeController;
import com.madhukarnati.emp.model.Employee;
import com.madhukarnati.emp.repository.EmployeeRepository;

import reactor.core.publisher.Mono;

@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeControllerTest.TestConfig.class)
class EmployeeControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public EmployeeService employeeService() {
            return Mockito.mock(EmployeeService.class);
        }
    }

    /**
     * Test by calling the ReST API - Positive case
     */
    @Test
    void testGetEmployeeById_returnsEmployee() {
        Employee employee = new Employee();
        employee.setId("emp123");
        employee.setName("John Doe");
        employee.setEmail("john@example.com");
        when(employeeService.findById("emp123")).thenReturn(Mono.just(employee));

        webTestClient.get()
            .uri("/api/employees/emp123")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.name").isEqualTo("John Doe")
            .jsonPath("$.email").isEqualTo("john@example.com");
    }

    /**
     * Test by calling the ReST API - Negative case
     */
    @Test
    void testGetEmployeeById_notFound() {
        when(employeeService.findById("emp999")).thenReturn(Mono.empty());

        webTestClient.get()
            .uri("/api/employees/emp999")
            .exchange()
            .expectStatus().isNotFound();
    }
}
