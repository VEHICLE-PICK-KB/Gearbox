Gearbox REST API (Spring Boot)


# Gearbox REST API

A simple Spring Boot REST API for managing car gearboxes.  

## 🔧 Technologies Used
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 in-memory database
- Maven or Gradle
- Git & GitHub

## 📦 Features
- Create new gearboxes
- List all gearboxes
- Get a single gearbox by ID
- Example fields:
  - `model` (e.g. ZF 8HP70)
  - `type` (automatic, manual, dual-clutch)
  - `gears` (number of gears)
  - `manufacturer`
  - `year`

## 🚗 Example Gearbox JSON

```json
{
  "model": "8HP70",
  "type": "automatic",
  "gears": 8,
  "manufacturer": "ZF",
  "year": 2017
}
```
## 🛠 API Endpoints
GET /api/gearboxes

Returns all gearboxes.

GET /api/gearboxes/{id}

Returns a single gearbox by ID.

POST /api/gearboxes

Creates a new gearbox.

PUT /api/gearboxes/{id}

Edits existing entry

Example request body:

```json
{
  "model": "DCT450",
  "type": "dual-clutch",
  "gears": 6,
  "manufacturer": "Getrag",
  "year": 2015
}
```

## 🗄 Database (H2)

H2 console is enabled at:

http://localhost:8080/h2-console


Default JDBC URL:
jdbc:h2:mem:testdb


## 🧪 Test Data

Test data uploaded into H2 in each startup:

INSERT INTO GEARBOX (id, model, type, gears, manufacturer, year)
VALUES
(1, '8HP70', 'automatic', 8, 'ZF', 2017),
(2, 'DCT450', 'dual-clutch', 6, 'Getrag', 2015);

## 🧩 Project Structure
src/
 ├─ main/
 │   ├─ java/.../controller/GearboxController.java
 │   ├─ java/.../model/GearboxService.java
 │   ├─ java/.../model/GearboxInterface.java
 │   └─ java/.../model/Gearbox.java
 └─ resources/
     ├─ application.properties
