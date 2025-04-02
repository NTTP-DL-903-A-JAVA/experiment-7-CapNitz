// Code for Problem 2

// (Setup for database/table might be similar or extended as needed for this problem.)

import java.sql.*;

public class UpdateEmployeeSalary {
    // Database URL, username, and password
    static final String DB_URL = "jdbc:mysql://localhost:3306/company"; 
    static final String USER = "root"; 
    static final String PASS = "password"; 

    public static void main(String[] args) {
        // This program updates the salary of an employee in the Employee table.
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Step 1: Prepare the update statement
            String sql = "UPDATE Employee SET Salary = ? WHERE EmpID = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                // For example, update the salary for EmpID 1
                pstmt.setDouble(1, 52000.00);  // New salary
                pstmt.setInt(2, 1);            // EmpID to update
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("An existing employee's salary was updated successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
