package com.nimbusdesk.partnerbridge.application.handler.impl;

import com.nimbusdesk.partnerbridge.application.dto.response.AvailabilityResponse;
import com.nimbusdesk.partnerbridge.application.handler.PartnerAvailabilityHandler;
import com.nimbusdesk.partnerbridge.domain.api.PartnerAvailabilityServicePort;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class PartnerAvailabilityHandlerImpl implements PartnerAvailabilityHandler {

    private final PartnerAvailabilityServicePort partnerAvailabilityServicePort;

    public PartnerAvailabilityHandlerImpl(PartnerAvailabilityServicePort partnerAvailabilityServicePort) {
        this.partnerAvailabilityServicePort = partnerAvailabilityServicePort;
    }

    @Override
    public AvailabilityResponse checkAvailability(Long roomId, LocalDateTime start, LocalDateTime end) {
        boolean available = partnerAvailabilityServicePort.checkAvailability(roomId, start, end);
        return new AvailabilityResponse(roomId, available);
    }
}
