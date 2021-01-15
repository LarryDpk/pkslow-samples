package com.pkslow.springboot.audit.dao;

import com.pkslow.springboot.audit.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
