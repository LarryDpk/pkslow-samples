package com.pkslow.springboot.katharsis.resource;

import com.pkslow.springboot.katharsis.dao.StudentRepository;
import com.pkslow.springboot.katharsis.model.Student;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.list.ResourceList;


import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class StudentResourceRepository implements ResourceRepositoryV2<Student, Long> {

    private final StudentRepository studentRepository;

    public StudentResourceRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findOne(Long id, QuerySpec querySpec) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Override
    public ResourceList<Student> findAll(QuerySpec querySpec) {
        return querySpec.apply(studentRepository.findAll());
    }

    @Override
    public ResourceList<Student> findAll(Iterable<Long> ids, QuerySpec querySpec) {
        return querySpec.apply(studentRepository.findAllById(ids));
    }

    @Override
    public <S extends Student> S save(S entity) {
        return studentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Class<Student> getResourceClass() {
        return Student.class;
    }

    @Override
    public <S extends Student> S create(S entity) {
        return save(entity);
    }

}
