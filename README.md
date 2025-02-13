# 🎓 Institute Management System (Layered Architecture)

A robust and scalable **Institute Management System** built with **Java, JavaFX, Hibernate, and MySQL**, following the **Layered Architecture Pattern**. This system is designed for efficient **student, staff, and course management**, featuring **role-based access control**, **secure authentication**, and **audit trails**.

## 🌟 Features
- ✅ **Student, Staff, and Course Management**
- ✅ **Fee & Payment Tracking**
- ✅ **Role-Based Access Control (Admin-Only)**
- ✅ **Guidance Sessions & Audit Trails**
- ✅ **Secure Authentication with Encryption**
- ✅ **Report Generation using Jasper Reports**
- ✅ **Modern JavaFX UI**

## 📂 Project Structure
The system follows a clean **MVC (Model-View-Controller) Layered Architecture**:

- **Controller Layer** - Manages user interactions and UI logic (JavaFX Controllers)
- **Service Layer** - Implements business logic and service operations
- **Repository Layer** - Handles database operations using Hibernate
- **DTOs & Utilities** - Ensures secure data transfer and includes helper methods

## 🛠️ Technologies Used
- **Java** - Backend Development
- **JavaFX** - User Interface
- **Hibernate** - Object Relational Mapping (ORM)
- **MySQL** - Database Management
- **Maven/Gradle** - Build and Dependency Management
- **Jasper Reports** - PDF/Excel Report Generation
- **BCrypt** - Password Encryption for Secure Authentication

## 🚀 Setup Instructions

### Prerequisites
Ensure you have the following installed on your system:
- **Java JDK 17+**
- **JavaFX SDK**
- **MySQL Server**
- **Maven or Gradle**
- **Git**

### Installation Steps
1. **Clone the repository:**
   ```sh
   git clone https://github.com/Matheesha-Abiman/Institute-Management-System-Layered-Architecture.git
   cd Institute-Management-System-Layered-Architecture
   ```
2. **Configure Database:**
   - Import the MySQL script (`database.sql`) from the `resources/db/` folder.
   - Update `hibernate.cfg.xml` with your MySQL credentials.
3. **Build and Run the Application:**
   ```sh
   mvn clean install
   mvn javafx:run
   ```

## 📊 Security & Encryption
- **BCrypt** is used for password hashing to enhance security.
- **Role-Based Access Control** ensures only admins have control.

## 📄 Reports & Analytics
- **Jasper Reports** is integrated for generating **custom reports**.
- Reports can be exported in **PDF, Excel, and other formats**.

## 📡 Contribution Guidelines
- Fork the repository.
- Create a new branch (`feature-branch-name`).
- Commit changes with meaningful messages.
- Submit a **Pull Request** for review.

## 💪 Author & Maintainer
Developed by **Matheesha Abiman**. Feel free to reach out for contributions and improvements!
