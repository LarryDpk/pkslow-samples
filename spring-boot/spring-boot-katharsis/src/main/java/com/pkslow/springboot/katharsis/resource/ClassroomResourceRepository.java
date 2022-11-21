package com.pkslow.springboot.katharsis.resource;


import com.pkslow.springboot.katharsis.dao.ClassroomRepository;
import com.pkslow.springboot.katharsis.model.Classroom;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.list.ResourceList;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ClassroomResourceRepository implements ResourceRepositoryV2<Classroom, Long> {

    private final ClassroomRepository userRepository;

    public ClassroomResourceRepository(ClassroomRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Classroom findOne(Long id, QuerySpec querySpec) {
        Optional<Classroom> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public ResourceList<Classroom> findAll(QuerySpec querySpec) {
        return querySpec.apply(userRepository.findAll());
    }

    @Override
    public ResourceList<Classroom> findAll(Iterable<Long> ids, QuerySpec querySpec) {
        return querySpec.apply(userRepository.findAllById(ids));
    }

    @Override
    public <S extends Classroom> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Class<Classroom> getResourceClass() {
        return Classroom.class;
    }

    @Override
    public <S extends Classroom> S create(S entity) {
        return save(entity);
    }

}