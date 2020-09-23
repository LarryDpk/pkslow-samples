package com.pkslow.batch.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    private String webSite;

    public Person(Integer age, String name, String webSite) {
        this.age = age;
        this.name = name;
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", webSite='" + webSite + '\'' +
                '}';
    }
}
