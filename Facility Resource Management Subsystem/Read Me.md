# Facility Resource Management Subsystem  
**Part of the Residential Aged Care Facility Management System Project**  
Developed by: Viralkumar Dasharathbhai Patel  
Course: ITECH7201 – Software Engineering: Analysis and Design  
Semester: T1, 2025

---

## 📘 Overview

This Java console-based application is a standalone subsystem of the Residential Aged Care Facility Management System. It handles the efficient allocation, management, and maintenance of resources such as **rooms**, **equipment**, and **staff rosters** within an aged care facility.

The subsystem implements **Object-Oriented Design Principles** and makes use of the **Singleton**, **State**, and **Command** design patterns. It is built to be **modular**, **testable**, and **easily integrable** into the overall system.

---

## 📂 Subsystem Features

### 🛏️ Room Management
- Allocate room to new resident
- Set room as under maintenance
- Release room after discharge or maintenance
- View available and occupied rooms

### 🧰 Equipment Management
- Assign equipment to resident
- Mark equipment as faulty
- View available equipment by type
- Release or reassign equipment

### 👨‍⚕️ Roster & Scheduling
- Create weekly roster
- Add staff schedules
- Update shift assignments
- View complete roster

---

## 🔧 Design Patterns Used

- **Singleton Pattern**: Used in `RoomManager`, `EquipmentManager`, and `RosterManager` to ensure a single instance throughout the application.
- **State Pattern**: 
  - `RoomState`: With states like `AvailableState`, `OccupiedState`, `UnderMaintenanceState`.
  - `EquipmentState`: With states like `AvailableState`, `InUseState`, `OutOfOrderState`.
- **Command Pattern**: Used to encapsulate system commands such as `AllocateRoomCommand`, `ReleaseRoomCommand`, `AssignEquipmentCommand`, etc.

---

## 🧪 Unit Testing Summary

- Framework: **JUnit 4**
- 6 test cases implemented covering:
  - Normal scenarios
  - Edge cases
  - Error handling
- Assertion types used: `assertTrue`, `assertFalse`, `assertEquals`, `assertNotNull`, `assertNull`, `assertNotSame`
- Test files: 
  - `RoomManagerTest.java`
  - `EquipmentManagerTest.java`

All tests passed successfully ✅

---

## 📜 How to Run

1. Clone this repository.
2. Open it in **Eclipse** or **IntelliJ**.
3. Run `Main.java` to launch the console application.
4. To run tests, right-click the test class → `Run As` → `JUnit Test`.

---

## ✍️ Developer Contributions

- Implemented all classes for Room, Equipment, Roster, and associated managers
- Applied Singleton, State, and Command design patterns
- Designed user stories, Java class structure, and command interface
- Created all JUnit tests with full assertion coverage
- Managed version control and commits via GitHub

---

## 🔗 Integration Note

This subsystem is independently testable and will be integrated with the `Admission and Record Subsystem` under the `/Integrated Code/` directory for final submission.

---

## 📧 Contact

Viralkumar Dasharathbhai Patel  
GitHub: [@viral-patel-b93988157](https://github.com/viral-patel-b93988157)  
Email: viral.patel.1532@gmail.com  
Student ID: 30446973

---

