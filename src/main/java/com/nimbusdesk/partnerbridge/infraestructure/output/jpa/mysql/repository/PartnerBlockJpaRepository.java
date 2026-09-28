package com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mysql.repository;

import com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mysql.entity.PartnerBlockEntity;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PartnerBlockJpaRepository extends JpaRepository<PartnerBlockEntity, Long> {

    @Query("""
            SELECT COUNT(b) > 0 FROM PartnerBlockEntity b
            WHERE b.roomId = :roomId
              AND b.blockedFrom < :end
              AND :start < b.blockedTo
            """)
    boolean existsOverlapping(
            @Param("roomId") Long roomId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end);
}
