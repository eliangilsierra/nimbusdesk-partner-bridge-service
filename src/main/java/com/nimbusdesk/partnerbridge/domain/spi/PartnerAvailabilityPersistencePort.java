package com.nimbusdesk.partnerbridge.domain.spi;

import java.time.LocalDateTime;

/**
 * The single output port for this service. Two concrete adapters implement it —
 * one against MySQL, one against SQL Server — selected by the active Spring
 * profile (see nimbusdesk-infra ADR-0004). The domain and use case never know
 * which one is wired at runtime.
 */
public interface PartnerAvailabilityPersistencePort {

    boolean existsOverlappingBlock(Long roomId, LocalDateTime start, LocalDateTime end);
}
