package com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mssql.entity;

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
 * The partner's side of the integration: a pre-existing SQL Server schema with its
 * own PascalCase convention, which this adapter absorbs — the domain never sees it.
 */
@Entity
@Table(name = "PartnerBlocks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerBlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "RoomId", nullable = false)
    private Long roomId;

    @Column(name = "BlockedFrom", nullable = false)
    private LocalDateTime blockedFrom;

    @Column(name = "BlockedTo", nullable = false)
    private LocalDateTime blockedTo;
}
