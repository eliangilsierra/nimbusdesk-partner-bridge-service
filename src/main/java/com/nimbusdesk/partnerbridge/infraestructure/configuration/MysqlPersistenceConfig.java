package com.nimbusdesk.partnerbridge.infraestructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Active only under the "mysql" profile: scans exclusively the mysql adapter
 * package, so the mssql entity/repository never enter this persistence unit.
 */
@Configuration
@Profile("mysql")
@EntityScan("com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mysql.entity")
@EnableJpaRepositories("com.nimbusdesk.partnerbridge.infraestructure.output.jpa.mysql.repository")
public class MysqlPersistenceConfig {
}
