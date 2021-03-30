package com.pkslow.basic.pojo;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private Integer age;
    private Long classId;
    private List<String> subjects;

    public Student(String name, Integer age, Long classId, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.classId = classId;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", age=" + age +
                ", classId=" + classId +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                Objects.equals(age, student.age) &&
                Objects.equals(classId, student.classId) &&
                Objects.equals(subjects, student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, classId, subjects);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
