package com.pkslow.springboot.katharsis.dao;

import com.pkslow.springboot.katharsis.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
