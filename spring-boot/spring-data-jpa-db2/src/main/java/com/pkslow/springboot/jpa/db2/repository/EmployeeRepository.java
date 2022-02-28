package com.pkslow.springboot.jpa.db2.repository;

import com.pkslow.springboot.jpa.db2.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
