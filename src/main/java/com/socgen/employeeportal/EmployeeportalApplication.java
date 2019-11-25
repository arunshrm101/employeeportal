package com.socgen.employeeportal;

import com.socgen.employeeportal.domain.Employee;
import com.socgen.employeeportal.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeportalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeportalApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepository) {
        return args -> {
            Employee employee =
                    new Employee("abc", "def", "Male", "IT", "03/09/1994");

            employeeRepository.save(employee);

            employeeRepository.findAll().forEach(System.out::println);
        };
    }

}
