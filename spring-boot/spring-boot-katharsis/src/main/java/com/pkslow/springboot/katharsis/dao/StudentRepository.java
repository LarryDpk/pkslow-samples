package com.pkslow.springboot.katharsis.dao;

import com.pkslow.springboot.katharsis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
