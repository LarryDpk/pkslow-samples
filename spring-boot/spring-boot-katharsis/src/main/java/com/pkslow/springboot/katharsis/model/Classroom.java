package com.pkslow.springboot.katharsis.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.SerializeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@JsonApiResource(type = "classrooms")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @JsonApiId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "classrooms_students", joinColumns = @JoinColumn(name = "classroom_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    @JsonApiRelation(serialize= SerializeType.EAGER)
    private Set<Student> students;
}
