package com.nimbusdesk.partnerbridge.infraestructure.configuration;

import com.nimbusdesk.partnerbridge.domain.api.PartnerAvailabilityServicePort;
import com.nimbusdesk.partnerbridge.domain.spi.PartnerAvailabilityPersistencePort;
import com.nimbusdesk.partnerbridge.domain.useCase.PartnerAvailabilityUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

    @Bean
    public PartnerAvailabilityServicePort partnerAvailabilityServicePort(
            PartnerAvailabilityPersistencePort persistencePort) {
        return new PartnerAvailabilityUseCase(persistencePort);
    }
}
