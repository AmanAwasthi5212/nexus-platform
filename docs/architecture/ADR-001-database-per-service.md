# ADR-001: Database per Service

## Status

Accepted

## Context

NEXUS is designed as a distributed microservices platform.
Each business capability should be independently deployable and scalable.

A shared database would create tight coupling between services and
make independent evolution difficult.

## Decision

Each microservice will own its own database/schema.

Services must not directly access another service's database.

Communication between services will happen through:

- REST APIs for synchronous operations
- Kafka events for asynchronous operations

## Consequences

### Positive

- Independent service ownership
- Independent deployment
- Reduced database coupling
- Independent scaling
- Clear domain boundaries

### Negative

- Distributed transactions become more difficult
- Data duplication may occur
- Eventual consistency must be handled
- Cross-service queries become more complex

## Alternatives Considered

### Shared Database

Rejected because it creates strong coupling between services.

### Single Database with Separate Schemas

Rejected as the primary architecture because service ownership
would still be tightly coupled to the same database infrastructure.