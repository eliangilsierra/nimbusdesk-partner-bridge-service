package com.nimbusdesk.partnerbridge.domain.useCase;

import com.nimbusdesk.partnerbridge.domain.api.PartnerAvailabilityServicePort;
import com.nimbusdesk.partnerbridge.domain.spi.PartnerAvailabilityPersistencePort;
import java.time.LocalDateTime;

public class PartnerAvailabilityUseCase implements PartnerAvailabilityServicePort {

    private final PartnerAvailabilityPersistencePort persistencePort;

    public PartnerAvailabilityUseCase(PartnerAvailabilityPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public boolean checkAvailability(Long roomId, LocalDateTime start, LocalDateTime end) {
        return !persistencePort.existsOverlappingBlock(roomId, start, end);
    }
}
