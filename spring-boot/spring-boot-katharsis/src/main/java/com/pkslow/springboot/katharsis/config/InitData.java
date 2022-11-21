package com.pkslow.springboot.katharsis.config;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.pkslow.springboot.katharsis.dao.ClassroomRepository;
import com.pkslow.springboot.katharsis.dao.StudentRepository;
import com.pkslow.springboot.katharsis.model.Classroom;
import com.pkslow.springboot.katharsis.model.Student;
import org.springframework.stereotype.Component;

@Component
public class InitData {

    private final ClassroomRepository classroomRepository;

    private final StudentRepository studentRepository;

    public InitData(ClassroomRepository classroomRepository, StudentRepository studentRepository) {
        this.classroomRepository = classroomRepository;
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    private void setupData() {
        Set<Student> students = new HashSet<>();
        Student student = Student.builder().name("Larry Deng").build();
        students.add(student);
        studentRepository.save(student);
        student = Student.builder().name("Eason").build();
        students.add(student);
        studentRepository.save(student);
        student = Student.builder().name("JJ Lin").build();
        students.add(student);
        studentRepository.save(student);

        Classroom classroom = Classroom.builder().name("Classroom No.1").students(students)
                .build();
        classroomRepository.save(classroom);
    }

}