package com.nimbusdesk.partnerbridge.infraestructure.input.rest;

import com.nimbusdesk.partnerbridge.application.dto.response.AvailabilityResponse;
import com.nimbusdesk.partnerbridge.application.handler.PartnerAvailabilityHandler;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerAvailabilityController {

    private final PartnerAvailabilityHandler partnerAvailabilityHandler;

    public PartnerAvailabilityController(PartnerAvailabilityHandler partnerAvailabilityHandler) {
        this.partnerAvailabilityHandler = partnerAvailabilityHandler;
    }

    @GetMapping("/availability")
    public ResponseEntity<AvailabilityResponse> checkAvailability(
            @RequestParam Long roomId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(partnerAvailabilityHandler.checkAvailability(roomId, start, end));
    }
}
