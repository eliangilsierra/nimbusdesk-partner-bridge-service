package com.nimbusdesk.partnerbridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entity and repository scanning are NOT left to Spring Boot's default base-package
 * scan: {@link com.nimbusdesk.partnerbridge.infraestructure.configuration.MysqlPersistenceConfig}
 * and {@code MssqlPersistenceConfig} each register only their own profile's
 * package via explicit {@code @EntityScan}/{@code @EnableJpaRepositories}, so only
 * one of the two adapters is ever wired at a time.
 */
@SpringBootApplication
public class NimbusdeskPartnerBridgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NimbusdeskPartnerBridgeServiceApplication.class, args);
    }

}
