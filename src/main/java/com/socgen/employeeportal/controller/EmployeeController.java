package com.socgen.employeeportal.controller;

import com.socgen.employeeportal.domain.Employee;
import com.socgen.employeeportal.domain.Response;
import com.socgen.employeeportal.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private final EmployeeRepository employeeRepository;


    @GetMapping("/employee")
    public  List<Employee> getUsers() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @PostMapping("/employee")
    public Response addUser(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return new Response(employee.getId()+" inserted",Boolean.TRUE);
    }
}
