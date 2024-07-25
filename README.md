Customer Management System
      This project is a CRUD application for managing customer information, developed using Java, JSP, JDBC, Java Servlets, HTML, CSS, and MySQL. 
  It supports features such as adding, updating, deleting customers, searching, pagination, and syncing customer data from a remote API.

Features

  Add Customer: Create a new customer record.
  Update Customer: Modify existing customer details.
  Delete Customer: Remove a customer from the database.
  Search Customer: Find customers based on various criteria.
  Pagination: View customers in a paginated format.
  Sync Customers: Sync customer data from a remote API, updating existing records or adding new ones.


Project Structure
  Backend: Java Servlets, JSP, JDBC
  Frontend: HTML, CSS
  Database: MySQL

Getting Started
Prerequisites
 
  Java Development Kit (JDK)
  Apache Tomcat
  MySQL Database
  Git

Setup Instructions

  1. Clone the Repository
     git clone https://github.com/yourusername/customerManagement.git
    cd customerManagement

  2. Database Setup
    Create a MySQL database named customer_management.
    Execute the following SQL script to create the customer table:
    CREATE DATABASE customer_db;

      USE customer_db;

      CREATE TABLE customers (
      id INT AUTO_INCREMENT PRIMARY KEY,
      first_name VARCHAR(50),
      last_name VARCHAR(50),
      street VARCHAR(100),
      address VARCHAR(100),
      city VARCHAR(50),
      state VARCHAR(50),
      email VARCHAR(100),
      phone VARCHAR(20)
  );


3. Configure Database Connection
      Update the database connection settings in the db.properties file:

    db.url=jdbc:mysql://localhost:3306/customer_db
    db.username=root
    db.password=yourpassword
   
5. Deploy the Application
    Compile and package the project using your preferred IDE or build tool.
    Deploy the compiled WAR file to your Apache Tomcat server.

   
Usage

1. Access the Application
Start your Tomcat server.
Open a web browser and navigate to http://localhost:8080/customerManagement.

3. Login
Use the credentials specified in the assignment (userName- test@sunbasedata.com , Password- Test@123).

Sync Customer Data
Click on the "Sync" button on the customer list screen to fetch and update customer data from the remote API.

Project Details


1.  Authentication API:
  Path: https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp
  Method: POST
  Body:
{
    "login_id" : "test@sunbasedata.com",
    "password" : "Test@123"
}
Response: Bearer token for further API calls.


2.Fetch Customer List API
Path: https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp
Method: GET
Parameters: cmd=get_customer_list
