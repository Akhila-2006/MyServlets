# 🌐 Java Servlets Projects – MyServlets

This repository contains Java Servlet-based web applications demonstrating key backend functionalities like **user login with cookies** and **CRUD operations using JDBC**.

These are beginner-friendly mini projects ideal for understanding how servlets handle web requests, sessions, cookies, and database interactions.

---

## 📁 Files Included

### 1️⃣ `LoginformUsingServletsandCookies.java`
- 📋 Handles user login form submission using `doPost()` method.
- 🍪 Uses **Cookies** to store and retrieve login information.
- ✅ Useful for learning session management with lightweight client-side storage.

### 2️⃣ `JDBCCRUDUsingServlets.java`
- 🛠️ A complete **CRUD (Create, Read, Update, Delete)** implementation using Java Servlets and JDBC.
- 🗃️ Connects to a backend database to manage records.
- 📌 Teaches database connection, form submission, and dynamic HTML generation with servlets.

---

## 🚀 How to Run These Projects

> 💡 Prerequisite: Apache Tomcat server, Java JDK, and MySQL or other supported DB.

1. Place `.java` files in your servlet-enabled project structure:

2. Set up `web.xml` configuration to map servlet classes.

3. Compile and deploy the project in Tomcat server.

4. Access via browser:
http://localhost:8080/YourProject/login
http://localhost:8080/YourProject/crud
---

## 🧰 Technologies Used

- Java Servlets (J2EE)
- JDBC (Java Database Connectivity)
- Apache Tomcat
- HTML/CSS (for front-end)
- MySQL or any RDBMS (for backend)

---

## 📚 Learning Outcomes

- Understanding how servlets handle form data using `GET` and `POST`
- Using cookies for lightweight session handling
- Performing Create, Read, Update, and Delete operations with JDBC
- Writing dynamic responses using `PrintWriter` in servlets
