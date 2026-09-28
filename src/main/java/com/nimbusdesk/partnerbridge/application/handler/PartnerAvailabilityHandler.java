package com.nimbusdesk.partnerbridge.application.handler;

import com.nimbusdesk.partnerbridge.application.dto.response.AvailabilityResponse;
import java.time.LocalDateTime;

public interface PartnerAvailabilityHandler {

    AvailabilityResponse checkAvailability(Long roomId, LocalDateTime start, LocalDateTime end);
}
