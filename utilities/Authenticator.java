package utilities;

import java.sql.Connection;

import users.Employee;

public class Authenticator 
{
    private final String url = "jdbc:mysql://localhost:3306/FirmManagement"; 
    private final String username = "root"; 
    private final String password = "Admin_123"; 
    private Connection connection;
    DataBaseHandler dbHandler = new DataBaseHandler();
    private Employee currUser;

    public Employee login(String username, String password)
    {

        try 
        {
            Employee newEmployee = dbHandler.GetEmployeeWithUsername(username);
            System.out.println(newEmployee.getPassword());
            if(newEmployee != null && newEmployee.getPassword().equals(password))
            {
                this.currUser = newEmployee;
                System.out.println("Successfully logged in");
                return newEmployee;

            }
            else
            {
                System.err.println("Error signig in from authenticator");
            }
            
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
        }
        return null;
    }
    public void logout()
    {
        if(this.currUser != null)
        {
            System.out.println("");
            this.currUser = null;
        }
        else
        {
            System.err.println("Error logout");
            
        }
    }

    
}


/* import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Authenticator {
    private final String url = "jdbc:mysql://localhost:3306/FirmManagement"; 
    private final String username = "root"; 
    private final String password = "Admin_123"; 
    private Connection connection;
    private DataBaseHandler dbHandler = new DataBaseHandler();
    private Employee currUser;

    public Employee login(String username, String password) {
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            System.err.println("Invalid username or password. Please try again.");
            return null;
        }

        try {
            Employee newEmployee = dbHandler.GetEmployeeWithUsername(username);

            if (newEmployee != null) {
                if (newEmployee.getPassword().equals(password)) { // Assuming Employee class has `getPassword`
                    this.currUser = newEmployee;
                    System.out.println("Login successful. Welcome, " + newEmployee.getName() + "!");
                    return newEmployee;
                } else {
                    System.err.println("Incorrect password. Please try again.");
                }
            } else {
                System.err.println("No employee found with the given username.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred during login: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public void logout() {
        if (this.currUser != null) {
            System.out.println("User " + currUser.getName() + " has been logged out.");
            this.currUser = null;
        } else {
            System.err.println("No user is currently logged in.");
        }
    }
}
*/

