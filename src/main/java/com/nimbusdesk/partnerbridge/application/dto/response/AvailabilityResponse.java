package com.nimbusdesk.partnerbridge.application.dto.response;

public record AvailabilityResponse(
        Long roomId,
        boolean available
) {
}
