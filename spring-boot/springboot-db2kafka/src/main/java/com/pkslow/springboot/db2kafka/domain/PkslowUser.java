package com.pkslow.springboot.db2kafka.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PKSLOW_USER")
@Data
public class PkslowUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
}
