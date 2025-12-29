# 🧮 Math Lab: Spring Boot Reference App

A minimal, deterministic, database-less REST API built specifically to serve as a test target for automated secure CI/CD pipelines.
This project is intentionally simple and predictable, and is used as a reference application in the first iteration of a CI/CD engine focused on build, test, and security automation.
---

### 🎯 Core Objectives
* **Demonstration:** Showcase Spring Boot controllers, services, and configuration.
* **Testing Ground:** Provide a stable target for smoke tests and CI/CD pipelines.
* **Simplicity:** No DB, no security, and no orchestration—purely functional logic.

---

### 🔌 API Reference

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/calculate` | Executes a math operation (see payload below). |
| `GET` | `/api/operations` | Lists all supported mathematical operators. |
| `GET` | `/actuator/health` | Standard health check for pipeline verification. |

#### **POST `/api/calculate`**
**Example Payload & Response:**
```json
// Request                          // Response (200 OK)
{                                   {
  "a": 10,                            "result": 2.0,
  "b": 5,                             "operation": "DIVIDE"
  "operation": "DIVIDE"             }
}
```
> Error Handling (400 Bad Request):

Division by zero | Unsupported operations | Invalid JSON payloads

### 🏗️ Architecture & Logic
| Component  | Responsibility                                      |
| ---------- | --------------------------------------------------- |
| Controller | Manages HTTP routing and request validation         |
| Service    | Houses pure business logic and math calculations    |
| Model      | Contains immutable request/response POJOs and enums |
| Exception  | Centralized handling for domain-specific errors     |

Supported Operations: ADD | SUBTRACT | MULTIPLY | DIVIDE | POWER | MODULO


### 🧪 Testing Strategy

| Suite      | Focus                  | Characteristics                                       |
| ---------- | ---------------------- | ----------------------------------------------------- |
| Unit Tests | `CalculatorService`    | Fast; no Spring context; tests pure business logic    |
| Web Tests  | `CalculatorController` | Validates API contracts, JSON mapping, and HTTP codes |
