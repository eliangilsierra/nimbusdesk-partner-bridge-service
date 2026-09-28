package com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * "Our" side of the integration: a NimbusDesk-owned MySQL schema, snake_case as
 * everywhere else in this system.
 */
@Entity
@Table(name = "partner_blocks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerBlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_id", nullable = false)
    private Long roomId;

    @Column(name = "blocked_from", nullable = false)
    private LocalDateTime blockedFrom;

    @Column(name = "blocked_to", nullable = false)
    private LocalDateTime blockedTo;
}
