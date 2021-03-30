package com.pkslow.basic.pojo;

import java.util.List;
import java.util.Objects;

public class Teacher {
    private String name;
    private Integer age;
    private List<Long> classIds;

    @Override
    public String toString() {
        return "Teacher{" +
                "name=" + name +
                ", age=" + age +
                ", classIds=" + classIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return name.equals(teacher.name) &&
                Objects.equals(age, teacher.age) &&
                Objects.equals(classIds, teacher.classIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, classIds);
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

    public List<Long> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<Long> classIds) {
        this.classIds = classIds;
    }

    public Teacher(String name, Integer age, List<Long> classIds) {
        this.name = name;
        this.age = age;
        this.classIds = classIds;
    }
}
