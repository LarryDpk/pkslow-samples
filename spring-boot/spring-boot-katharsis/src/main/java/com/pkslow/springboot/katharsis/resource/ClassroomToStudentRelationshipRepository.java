package com.pkslow.springboot.katharsis.resource;

import com.pkslow.springboot.katharsis.dao.ClassroomRepository;
import com.pkslow.springboot.katharsis.dao.StudentRepository;
import com.pkslow.springboot.katharsis.model.Classroom;
import com.pkslow.springboot.katharsis.model.Student;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.RelationshipRepositoryV2;
import io.katharsis.resource.list.ResourceList;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ClassroomToStudentRelationshipRepository implements RelationshipRepositoryV2<Classroom, Long, Student, Long> {

    private final ClassroomRepository classroomRepository;

    private final StudentRepository studentRepository;

    public ClassroomToStudentRelationshipRepository(ClassroomRepository classroomRepository, StudentRepository studentRepository) {
        this.classroomRepository = classroomRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void setRelation(Classroom Classroom, Long studentId, String fieldName) {
        // not for many-to-many
    }

    @Override
    public void setRelations(Classroom classroom, Iterable<Long> studentIds, String fieldName) {
        final Set<Student> students = new HashSet<Student>();
        students.addAll(studentRepository.findAllById(studentIds));
        classroom.setStudents(students);
        classroomRepository.save(classroom);
    }

    @Override
    public void addRelations(Classroom classroom, Iterable<Long> studentIds, String fieldName) {
        final Set<Student> students = classroom.getStudents();
        students.addAll(studentRepository.findAllById(studentIds));
        classroom.setStudents(students);
        classroomRepository.save(classroom);
    }

    @Override
    public void removeRelations(Classroom classroom, Iterable<Long> studentIds, String fieldName) {
        final Set<Student> students = classroom.getStudents();
        students.removeAll(studentRepository.findAllById(studentIds));
        classroom.setStudents(students);
        classroomRepository.save(classroom);
    }

    @Override
    public Student findOneTarget(Long sourceId, String fieldName, QuerySpec querySpec) {
        // not for many-to-many
        return null;
    }

    @Override
    public ResourceList<Student> findManyTargets(Long sourceId, String fieldName, QuerySpec querySpec) {
        final Optional<Classroom> classroomOptional = classroomRepository.findById(sourceId);
        Classroom classroom = classroomOptional.orElseGet(Classroom::new);
        return querySpec.apply(classroom.getStudents());
    }

    @Override
    public Class<Classroom> getSourceResourceClass() {
        return Classroom.class;
    }

    @Override
    public Class<Student> getTargetResourceClass() {
        return Student.class;
    }

}