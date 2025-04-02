// Code for Problem 3

// A simple MVC example for a database application
// Model class: Handles data and database interactions
import java.sql.*;

class EmployeeModel {
    static final String DB_URL = "jdbc:mysql://localhost:3306/company"; 
    static final String USER = "root"; 
    static final String PASS = "password"; 

    // Method to fetch employee details
    public ResultSet getEmployeeData() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT EmpID, Name, Salary FROM Employee";
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// View class: Responsible for displaying data
class EmployeeView {
    public void printEmployeeDetails(ResultSet rs) {
        try {
            while (rs.next()) {
                int id = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println("EmpID: " + id + ", Name: " + name + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Controller class: Mediates between Model and View
public class EmployeeController {
    private EmployeeModel model;
    private EmployeeView view;

    public EmployeeController(EmployeeModel model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        ResultSet rs = model.getEmployeeData();
        view.printEmployeeDetails(rs);
    }

    public static void main(String[] args) {
        EmployeeModel model = new EmployeeModel();
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);
        controller.updateView();
    }
}
