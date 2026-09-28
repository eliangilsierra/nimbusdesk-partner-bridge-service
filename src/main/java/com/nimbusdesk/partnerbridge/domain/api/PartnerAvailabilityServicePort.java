package com.nimbusdesk.partnerbridge.domain.api;

import java.time.LocalDateTime;

public interface PartnerAvailabilityServicePort {

    boolean checkAvailability(Long roomId, LocalDateTime start, LocalDateTime end);
}
