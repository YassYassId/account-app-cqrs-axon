# Account App CQRS Axon

A Java-based microservice for banking account management using Spring Boot, Axon Framework, and the CQRS (Command Query Responsibility Segregation) pattern. The project demonstrates a robust, scalable, and event-sourced design for handling financial account operations such as creating accounts, crediting, debiting, and retrieving statements.

---

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Event Flow](#event-flow)
- [Main Technologies](#main-technologies)
- [Setup & Running](#setup--running)
- [API Endpoints](#api-endpoints)

---

## Features

- Account creation with initial balance.
- Crediting and debiting accounts in a secure, consistent manner.
- Retrieval of account statements and event streams.
- Reactive endpoints for real-time updates.
- Replayable event store for recovery/debugging.
- Clean separation of `Command` and `Query` sides via Axon.
- Usage of DTOs and repositories for persistence and query projections.

---

## Architecture

The solution implements the CQRS and Event Sourcing patterns using the [Axon Framework](https://axoniq.io/). The key architectural components are:

- **Command Side**: Handles state changes (create, credit, debit accounts) using Aggregates and Commands.
- **Query Side**: Handles read operations and projections for queries like account statements.
- **Event Handlers**: React to events and update the read model; also emit live updates via subscriptions.
- **Repositories**: Abstract access to the data store for queries (`AccountRepository`, `OperationRepository`).
- **DTOs**: Used for transferring data between layers and endpoints.

### High-Level Diagram

```
                +---------------------------+
                |     Command Side          |
                |--------------------------|
                | - AccountAggregate       |
                | - Command Handlers       |
                +--------------------------+
                             |
                             | emits
                             v
                +--------------------------+
                |       Events             |
                +--------------------------+
                             |
                             v
                +--------------------------+
                |     Query Side           |
                |--------------------------|
                | - Query Handlers         |
                | - Event Handlers         |
                | - Repositories           |
                +--------------------------+
```

---

## Event Flow

1. **Command API** receives command (e.g., create, debit, credit).
2. Command handled by an **Aggregate**, which validates, updates state, and emits an event.
3. **Event Handler** listens for events; updates the read database and emits changes to subscribers.
4. **Query API** serves up-to-date account information and allows event watching.

---

## Main Technologies

- **Java 17+**
- **Spring Boot**
- **Axon Framework**
- **Spring Data JPA**
- **Lombok**
- **Reactive Streams** (for event watching)
- **Maven** (build tool)

---

## Setup & Running

### Prerequisites

- JDK 17+ installed.
- Maven or Gradle installed.
- A relational database (H2 is default but can be replaced).

### Quick Start

1. Clone the repo:
   ```bash
   git clone https://github.com/YassYassId/account-app-cqrs-axon.git
   cd account-app-cqrs-axon
   ```

2. Build and run:
   ```bash
   ./mvnw spring-boot:run
   ```

3. The service will start on `http://localhost:8066`.

---

## API Endpoints

### Commands

- `POST /command/accounts`: Create a new account.
- `POST /command/accounts/debit`: Debit an account.
- `POST /command/accounts/credit`: Credit an account.

### Queries

- `GET /query/accounts`: List all accounts.
- `GET /query/accounts/{accountId}`: Get account statement/details.
- `GET /query/accounts/watch/{accountId}`: Subscribe (SSE) to real-time account events.

---

## About

Created and maintained by [YassYassId](https://github.com/YassYassId).
