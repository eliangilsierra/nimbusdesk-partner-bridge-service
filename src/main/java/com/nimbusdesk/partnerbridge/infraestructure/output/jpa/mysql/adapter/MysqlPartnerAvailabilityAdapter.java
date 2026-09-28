package com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mysql.adapter;

import com.nimbusdesk.partnerbridge.domain.spi.PartnerAvailabilityPersistencePort;
import com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mysql.repository.PartnerBlockJpaRepository;
import java.time.LocalDateTime;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mysql")
public class MysqlPartnerAvailabilityAdapter implements PartnerAvailabilityPersistencePort {

    private final PartnerBlockJpaRepository repository;

    public MysqlPartnerAvailabilityAdapter(PartnerBlockJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsOverlappingBlock(Long roomId, LocalDateTime start, LocalDateTime end) {
        return repository.existsOverlapping(roomId, start, end);
    }
}
