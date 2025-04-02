// Code for Problem 1

// SQL statements used to set up the database and table:
/*
CREATE DATABASE company;
USE company;
CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(100),
    Salary DECIMAL(10, 2)
);
INSERT INTO Employee (EmpID, Name, Salary)
VALUES (1, 'John Doe', 50000.00),
       (2, 'Jane Smith', 55000.00),
       (3, 'Sam Brown', 45000.00);
*/

import java.sql.*;

public class MySQLJDBCExample {
    // Database URL, username, and password
    static final String DB_URL = "jdbc:mysql://localhost:3306/company"; // Update the URL based on your setup
    static final String USER = "root";  // MySQL username
    static final String PASS = "password";  // MySQL password (replace with your actual password)
    
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Step 2: Create a statement object to execute SQL queries
            String sql = "SELECT EmpID, Name, Salary FROM Employee";
            try (Statement stmt = connection.createStatement()) {
                // Step 3: Execute the query and obtain the result set
                ResultSet rs = stmt.executeQuery(sql);
                // Step 4: Process the result set
                while (rs.next()) {
                    int id = rs.getInt("EmpID");
                    String name = rs.getString("Name");
                    double salary = rs.getDouble("Salary");
                    System.out.println("EmpID: " + id + ", Name: " + name + ", Salary: " + salary);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
