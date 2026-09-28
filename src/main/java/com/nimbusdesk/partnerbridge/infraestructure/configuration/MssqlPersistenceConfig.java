package com.nimbusdesk.partnerbridge.infraestructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Active only under the "mssql" profile: scans exclusively the mssql adapter
 * package, so the mysql entity/repository never enter this persistence unit.
 */
@Configuration
@Profile("mssql")
@EntityScan("com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mssql.entity")
@EnableJpaRepositories("com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mssql.repository")
public class MssqlPersistenceConfig {
}
