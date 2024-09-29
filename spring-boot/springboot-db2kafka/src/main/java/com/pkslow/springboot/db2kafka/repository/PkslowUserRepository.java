package com.pkslow.springboot.db2kafka.repository;

import com.pkslow.springboot.db2kafka.domain.PkslowUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PkslowUserRepository extends JpaRepository<PkslowUser, Long> {
}
