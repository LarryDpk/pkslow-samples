package com.pkslow.springboot.jpa.db2;

import com.pkslow.springboot.jpa.db2.entity.Employee;
import com.pkslow.springboot.jpa.db2.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Configuration
@Slf4j
public class TestConfig {
    @Autowired
    private EmployeeRepository repository;

    @PostConstruct
    public void init() {
        Employee employee1 = new Employee(1L, "Larry Deng");
        Employee employee2 = new Employee(2L, "LarryDpk");
        Employee employee3 = new Employee(3L, "Pkslow");

        repository.deleteAll();
        repository.save(employee1);
        repository.save(employee2);
        repository.save(employee3);

        List<Employee> employees = StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        employees.forEach(e -> log.info(e.toString()));

    }
}
