# Gearbox Application (WIP)
Fullstack project with **Spring Boot Backend** and **Angular Frontend** to practice Angular syntax. This project can later simulate gearbox ratios and vehicle speed which can be useful for certain driving games.

# TODO: 
Functionality:
Implement, search, data filtering by criteria, paging and sorting.

Features:
Gear ratio creation/calculator, gear ratio viewer/editor, simulated driving speeds with engine rpm, animated gearbox?

Authentication:
Users, Authentication (Spring security or JWT token), saving configurations and lists.

## 📦 Overview
This repository contains:
- 🚀 **Gearbox REST API** built with Spring Boot  
- 🎨 **Gearbox Frontend** built with Angular  
Both combine to form a complete CRUD application for managing car gearboxes.

---

# 🟥 Backend — Gearbox REST API (Spring Boot)

## 🔧 Technologies Used
- Java 17+
- Spring Boot (Web, Data JPA)
- H2 in-memory database
- Maven / Gradle
- Git & GitHub

## 📦 Features
- Create new gearboxes
- List all gearboxes
- Get a gearbox by ID
- Update an existing gearbox
- Delete a gearbox
- Validation on both POST and PUT requests

### Example Gearbox JSON
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

### GET /api/gearboxes  
Returns all gearboxes.

### GET /api/gearboxes/{id}  
Returns gearbox by ID.

### POST /api/gearboxes  
Creates a new gearbox.

### PUT /api/gearboxes/{id}  
Updates an existing gearbox.

Example:
```json
{
  "model": "DCT450",
  "type": "dual-clutch",
  "gears": 6,
  "manufacturer": "Getrag",
  "year": 2015
}
```

### DELETE /api/gearboxes/{id}  
Deletes a gearbox.

---

## 🗄 Database (H2)

H2 console is available at:
```
http://localhost:8080/h2-console
```

Default JDBC URL:
```
jdbc:h2:mem:testdb
```

### Example Test Data
```sql
INSERT INTO GEARBOX (id, model, type, gears, manufacturer, year)
VALUES
(1, '8HP70', 'automatic', 8, 'ZF', 2017),
(2, 'DCT450', 'dual-clutch', 6, 'Getrag', 2015);
```

---

---

# 🟦 Frontend — Angular Application

Generated with **Angular CLI 17.3.17**

## ▶ Development server
Run:
```
ng serve
```

Open:
```
http://localhost:4200/
```

The app reloads automatically on file changes.

## 🧱 Code scaffolding
Use:
```
ng generate component component-name
```
or generate:
- directive
- pipe
- service
- class
- guard
- interface
- enum
- module

## 🏗 Build
```
ng build
```
Build artifacts are stored in `dist/`.

## 🧪 Running unit tests
```
ng test
```

## 🔍 Running end-to-end tests
(Configure with your preferred E2E tool)

---

# ✔ Summary
This fullstack project demonstrates:
- RESTful API development with Spring Boot  
- Angular frontend with form validation  
- Full CRUD functionality  
- Git branching and merging workflow  
- Clean code and separation of concerns  

---

# 📬 Author
VEHICLE-PICK-KB  
