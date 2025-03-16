# Point of Sale (POS) System

## 📌 Project Overview

This **Point of Sale (POS) System** is a backend application developed using **Spring Boot** and **MySQL**. It allows businesses to manage **products**, **sales transactions**, and **users**. The system includes **JWT authentication** for secure user access and implements key features like **inventory management**, **sale processing**, and **report generation**.

---

## ⚙️ Technologies Used

- **Backend:** Spring Boot (Java)
- **Database:** MySQL
- **Authentication:** JWT (JSON Web Tokens)
- **Dependency Management:** Maven
- **API Documentation:** Swagger

---

## 🚀 Features

- **User Authentication:** Secure login and registration with JWT tokens.
- **CRUD Operations for Items:** Add, update, delete, and view items in the inventory.
- **Sales Management:** Process transactions, update stock levels, and generate receipts.
- **Role-Based Access:** Admin and user roles with different levels of access.
- **API Documentation:** Swagger UI for easy access to API endpoints.
- **Error Handling:** Detailed error messages and validation for input fields.

---

## 📥 Installation

### Prerequisites
- **Java 11 or higher**
- **MySQL server**
- **Maven**

### Steps to Run the Project

1. **Clone the repository:**

   ```
   git clone https://github.com/dehemiweerakoon/pos-system.git
   cd pos-system
   ```
2. **Set up the MySQL database:**

  Create a database pos_system in MySQL.
  Update the application.properties file with your MySQL database credentials.

3. **Build the project with Maven:**

   ```
    mvn clean install
   ```
4. **Run the Spring Boot application:**

    ```
    mvn spring-boot:run
    ```
Access the API via Swagger UI: Visit http://localhost:9000/swagger-ui.html to view and interact with the API.

## 🛠️ Endpoints
## 🛠️ API Endpoints

### **Stock Controller**
- **GET /stock/{id}**  
  Retrieve stock details by stock ID.
  
- **PUT /stock/{id}**  
  Update stock details by stock ID.
  
- **DELETE /stock/{id}**  
  Delete stock by stock ID.
  
- **GET /stock**  
  Retrieve the list of all stocks.
  
- **POST /stock**  
  Add a new stock item.
  
- **GET /stock/byItem/{id}**  
  Retrieve stock by item ID.

---

### **Transactions**
- **GET /items/{id}**  
  Retrieve item details by item ID.
  
- **PUT /items/{id}**  
  Update item details by item ID.
  
- **DELETE /items/{id}**  
  Delete item by item ID.
  
- **GET /items**  
  Retrieve the list of all items.
  
- **POST /items**  
  Add a new item.
  
- **GET /item/category/{id}**  
  Retrieve items in a specific category by category ID.

---

### **Item Category Controller**
- **GET /categories/{id}**  
  Retrieve category details by category ID.
  
- **PUT /categories/{id}**  
  Update category details by category ID.
  
- **DELETE /categories/{id}**  
  Delete category by category ID.
  
- **GET /categories**  
  Retrieve the list of all categories.
  
- **POST /categories**  
  Add a new category.

---

### **Cart Controller**
- **POST /{cartId}/addItem/{itemId}/{qty}**  
  Add an item to the cart with a specified quantity.
  
- **GET /{cartId}/cart**  
  Retrieve the details of a cart.
  
- **DELETE /{cartId}/cartdelete/{itemId}/{qty}**  
  Remove a specific item and quantity from the cart.

---

### **Image Controller**
- **POST /images**  
  Upload an image.
  
- **GET /images/{filename}**  
  Retrieve an image by its filename.

---

### **File Path Controller**
- **POST /file**  
  Upload a file.
  
- **GET /file/{filename}**  
  Retrieve a file by its filename.

---

### **Transaction Controller**
- **POST /buy/{cartId}**  
  Process a purchase for the cart with the given `cartId`.

---

### **Auth Controller**
- **POST /auth/register**  
  User registration (admin or user).
  
- **POST /auth/login**  
  User login (return JWT token).


## ⚙️ Configuration
Database Configuration: edit in your application properties 

    server.port=9000
    spring.datasource.url=jdbc:mysql://localhost:3306/[your_database]?createDatabaseIfNotExist=true
    spring.datasource.username=[your_username]
    spring.datasource.password=[your password]
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    
    spring.jpa.hibernate.ddl-auto=update
    
    ijseapp.jwt.secret = [your key]
    ijseapp.jwt.jwtExpiration = 86400000

📝 Contributing
   1. Fork the repository.
      
   2. Create your feature branch (git checkout -b feature/your-feature).
      
   3. Commit your changes (git commit -am 'Add new feature').
      
   4. Push to the branch (git push origin feature/your-feature).

   5.Open a pull request.
