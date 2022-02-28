package com.pkslow.springboot.jpa.db2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE", schema = "DB2INST1")
public class Employee {
    @Id
    private Long id;
    private String name;
}
