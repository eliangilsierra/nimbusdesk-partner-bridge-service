# nimbusdesk-partner-bridge-service

Anti-corruption layer toward an external partner system, for the [NimbusDesk](https://github.com/eliangilsierra/nimbusdesk-infra) system. This is the service [`nimbusdesk-booking-service`](https://github.com/eliangilsierra/nimbusdesk-booking-service) calls (synchronously, via Feign) before confirming a booking.

## The point of this repo

One domain output port, **two interchangeable adapters** — MySQL and SQL Server — selected by Spring profile, not by branching in code. See [ADR-0004](https://github.com/eliangilsierra/nimbusdesk-infra/blob/develop/adr/0004-doble-adaptador-de-persistencia-en-partner-bridge.md).

To make the example honest rather than cosmetic, each adapter targets a schema with a different naming convention — as if the MySQL side were NimbusDesk's own and the SQL Server side belonged to a pre-existing partner system:

| | MySQL (`mysql` profile) | SQL Server (`mssql` profile) |
|---|---|---|
| Table | `partner_blocks` | `PartnerBlocks` |
| Columns | `room_id`, `blocked_from`, `blocked_to` | `RoomId`, `BlockedFrom`, `BlockedTo` |

`domain/useCase/PartnerAvailabilityUseCase.java` depends only on `domain/spi/PartnerAvailabilityPersistencePort.java` — it has no idea which adapter is active. Only one of `MysqlPersistenceConfig` / `MssqlPersistenceConfig` (`infraestructure/configuration`) is loaded at a time, via `@Profile`, so only one adapter, one entity and one repository ever get registered in the same run.

## Stack

- Java 17 · Spring Boot 3.2.4 · Spring Cloud 2023.0.1 (Eureka client)
- Spring Data JPA + MySQL / SQL Server (`mssql-jdbc`)
- springdoc-openapi

## Endpoint

| Method | Path | Description |
|---|---|---|
| `GET` | `/availability?roomId=&start=&end=` | `false` if the room has an overlapping block on the partner's side |

## Configuration

| Env var | Default | Purpose |
|---|---|---|
| `PARTNER_BRIDGE_PROFILE` | `mysql` | `mysql` or `mssql` — picks the active adapter |
| `DB_URL` / `DB_USERNAME` / `DB_PASSWORD` | profile-specific, see `application-mysql.yml` / `application-mssql.yml` | Database connection |
| `EUREKA_URI` | `http://localhost:8761/eureka/` | Discovery server |

Demo data seeds a block on room `2` (`Borealis`, as seeded by `nimbusdesk-booking-service`) for `2026-01-10T09:00`–`12:00`.

> SQL Server does not auto-create a database the way the MySQL container does. If you run against `mssql` locally, create the `nimbusdesk` database on the SQL Server instance once before starting this service.

## Run locally

```bash
# against MySQL (default)
mvn spring-boot:run

# against SQL Server
PARTNER_BRIDGE_PROFILE=mssql mvn spring-boot:run
```

Or with Docker:

```bash
docker build -t nimbusdesk-partner-bridge-service .
docker run -p 8083:8083 \
  -e PARTNER_BRIDGE_PROFILE=mysql \
  -e DB_URL=jdbc:mysql://host.docker.internal:3306/nimbusdesk \
  -e EUREKA_URI=http://host.docker.internal:8761/eureka/ \
  nimbusdesk-partner-bridge-service
```

## How it fits in

Part of the NimbusDesk v1 system. See [`nimbusdesk-infra`](https://github.com/eliangilsierra/nimbusdesk-infra) for the full architecture, ADRs and roadmap.
