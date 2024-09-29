package com.pkslow.springboot.db2kafka.service;

import com.pkslow.springboot.db2kafka.domain.PkslowUser;
import com.pkslow.springboot.db2kafka.repository.PkslowUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PkslowUserService {
    private final PkslowUserRepository pkslowUserRepository;

    public PkslowUserService(PkslowUserRepository pkslowUserRepository) {
        this.pkslowUserRepository = pkslowUserRepository;
    }

    public void save(PkslowUser pkslowUser) {
        pkslowUserRepository.save(pkslowUser);
    }

//    @Scheduled(fixedRate = 5000)
    public void insertSample() {
        log.info("Insert sample data");
        PkslowUser pkslowUser = new PkslowUser();
        pkslowUser.setName("pkslow");
        pkslowUser.setAge(18);
        pkslowUserRepository.save(pkslowUser);
    }

    @Scheduled(fixedRate = 5000)
    public void publishToKafka() {
        List<PkslowUser> pkslowUsers = pkslowUserRepository.findAll();
        pkslowUsers.forEach(pkslowUser -> {
            log.info("Publish to Kafka: {}", pkslowUser);
        });
    }
}
