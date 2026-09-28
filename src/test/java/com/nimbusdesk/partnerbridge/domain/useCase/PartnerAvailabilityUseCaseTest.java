package com.nimbusdesk.partnerbridge.domain.useCase;

import static org.assertj.core.api.Assertions.assertThat;

import com.nimbusdesk.partnerbridge.domain.spi.PartnerAvailabilityPersistencePort;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

/**
 * No Spring context, no database, no profile: a fake persistence port is enough to
 * exercise the use case, which is exactly the point of putting it behind a port.
 */
class PartnerAvailabilityUseCaseTest {

    @Test
    void availableWhenNoOverlappingBlockExists() {
        PartnerAvailabilityUseCase useCase = new PartnerAvailabilityUseCase(
                (roomId, start, end) -> false);

        boolean available = useCase.checkAvailability(1L, LocalDateTime.now(), LocalDateTime.now().plusHours(1));

        assertThat(available).isTrue();
    }

    @Test
    void notAvailableWhenOverlappingBlockExists() {
        PartnerAvailabilityPersistencePort alwaysBlocked = (roomId, start, end) -> true;
        PartnerAvailabilityUseCase useCase = new PartnerAvailabilityUseCase(alwaysBlocked);

        boolean available = useCase.checkAvailability(1L, LocalDateTime.now(), LocalDateTime.now().plusHours(1));

        assertThat(available).isFalse();
    }
}
