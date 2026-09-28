package com.nimbusdesk.partnerbridge.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A period during which a room is blocked on the partner's side. Plain domain
 * model: it has no idea whether it is backed by MySQL or SQL Server.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerBlock {

    private Long id;
    private Long roomId;
    private LocalDateTime blockedFrom;
    private LocalDateTime blockedTo;
}
