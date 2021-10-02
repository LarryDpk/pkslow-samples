package com.pkslow.springboot.cassandra.repository;

import com.pkslow.springboot.cassandra.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User, String> {
}
