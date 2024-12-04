
package utilities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;

import users.Employee;
import users.Manager;
import users.RegularEmployee;





 
/**
 * The DataBaseHandler class manages the connection to the database and provides methods
 * to interact with the employee records. It allows for querying employee details, displaying
 * employee summaries, and reporting the number of employees in each role.
 */
public class DataBaseHandler 
{
    private final String url = "jdbc:mysql://localhost:3306/FirmManagement"; 
    private final String username = "root"; 
    private final String password = "Tecakanadji1"; 
    private Connection connection;
    AsciiArt color = new AsciiArt();
    
    /**
     * Constructs a new DataBaseHandler instance and establishes a connection to the database.
     * If the connection fails, an error message is displayed.
     */
    public DataBaseHandler()
    {
        try 
        {
            connection = DriverManager.getConnection(url, username, password);
        
        } 
        catch (SQLException e) 
        {
            System.err.println(color.BRIGHT_RED + "Database connection failed!! " + e.getMessage() + color.RESET);
        }
    }

    /**
     * Displays all employee records from the database, including employee details like ID, username,
     * role, name, phone number, date of birth, start date, and email. It also shows a summary of employees
     * by role and the total number of employees.
     */
    public void DispAllEmployee() 
    {
        if (connection == null) {
            System.err.println(color.BRIGHT_RED + "Database connection failed!!" + color.RESET);
            return;
        }
    
        try {
            // Using prepared statement for counting employees
            String countQuery = "SELECT COUNT(*) AS total FROM employees";
            try (PreparedStatement countStatement = connection.prepareStatement(countQuery)) 
            {
                ResultSet countResult = countStatement.executeQuery();
                
                // Using prepared statement for fetching employee details
                String query2do = "SELECT * FROM employees";
                try (PreparedStatement statement = connection.prepareStatement(query2do)) 
                {
                    ResultSet infoSet = statement.executeQuery();
    
                    System.out.println(color.MAGENTA + "===================================================================================" +
                            "=========================================================================" + color.RESET);
                    System.out.printf(color.BRIGHT_BLUE + "%-10s | %-15s | %-15s | %-30s | %-15s | %-13s | %-12s | %-30s%n",
                            "Emp ID", "Username", "Role", "Name", "Phone", "Date of Birth", "Start Date", "Email" + color.RESET);
                    System.out.println(color.MAGENTA + "===================================================================================" +
                            "=========================================================================" + color.RESET);
    
                    while (infoSet.next()) 
                    {
                        int dbID = infoSet.getInt("employee_id");
                        String dbUsername = infoSet.getString("username");
                        String dbRole = infoSet.getString("role");
                        String dbName = infoSet.getString("name");
                        String dbSurname = infoSet.getString("surname");
                        String dbPhone = infoSet.getString("phone_no");
                        Date dbDOB = infoSet.getDate("date_of_birth");
                        Date dbDOS = infoSet.getDate("date_of_start");
                        String dbEmail = infoSet.getString("email");
    
                        System.out.printf(color.WHITE + "%-10s | %-15s | %-15s | %-30s | %-15s | %-13s | %-12s | %-30s%n",
                                dbID, dbUsername, dbRole, dbName + " " + dbSurname, dbPhone,
                                dbDOB.toLocalDate(), dbDOS.toLocalDate(), dbEmail);
                        
                        System.out.println(color.MAGENTA + "===================================================================================" +
                                "=========================================================================" + color.RESET);
                    }
                }
    
                displayRoleSummary(); // Display additional role summary
    
                int totalEmployees = 0;
                if (countResult.next()) 
                {
                    totalEmployees = countResult.getInt("total");
                }
    
                System.out.println(color.WHITE + "\nTotal number of employees: " + totalEmployees + color.RESET);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(color.BRIGHT_RED + "Error occurred: " + e.getMessage() + color.RESET);
            e.printStackTrace(); // Optional for debugging
        }
    }
    

    /**
     * Displays a summary of employees by their role. The summary includes the role name and the 
     * number of employees in each role.
     */
    private void displayRoleSummary() 
    {
        if (connection == null) 
        {
            System.err.println(color.BRIGHT_RED + "Database connection failed!!" + color.RESET);
            return;
        }
    
        String query = "SELECT role, COUNT(*) AS role_count FROM employees GROUP BY role";
        try (PreparedStatement roleStatement = connection.prepareStatement(query)) 
        {
            ResultSet resultSet = roleStatement.executeQuery();
    
            System.out.println(color.BRIGHT_BLUE + "\nRole Summary:" + color.RESET);
            System.out.println(color.MAGENTA + "-------------------------" + color.RESET);
            while (resultSet.next()) {
                String role = resultSet.getString("role");
                int count = resultSet.getInt("role_count");
                System.out.printf("Role: %-10s | Number of Employees: %d%n", role, count);
            }
        } 
        catch (SQLException e) 
        {
            System.err.println(color.BRIGHT_RED + "Error occurred while fetching role summary: " + e.getMessage() + color.RESET);
            e.printStackTrace(); // Optional for debugging
        }
    }
    
    

    /**
     * Displays the details of all employees with a specified role.
     * The details include employee ID, username, role, name, phone number,
     * date of birth, start date, and email. The results are displayed in a formatted table.
     *
     * @param role the role of the employees to retrieve (e.g., "Manager", "RegularEmployee")
     */
    public void DispEmployeeWithRole(String role) 
    {
        if (connection == null) 
        {
            System.err.println(color.BRIGHT_RED + "Database connection failed!!" + color.RESET);
            return;
        }
    
        String query2do = "SELECT * FROM employees WHERE role = ?";
        try (PreparedStatement statement = connection.prepareStatement(query2do)) 
        {
            // Set the parameter for the role
            statement.setString(1, role);
            
            ResultSet infoSet = statement.executeQuery();
    
            System.out.println(color.MAGENTA + "==============================================================================" + 
                    "==============================================================================" + color.RESET);
            System.out.printf(color.BRIGHT_BLUE + "| %-10s | %-15s | %-15s | %-30s | %-15s | %-13s | %-12s | %-30s%n",
                    "Emp ID", "Username", "Role", "Name", "Phone No", "Date of Birth", "Start Date", "Email" + color.RESET);
            System.out.println(color.MAGENTA + "==============================================================================" + 
                    "==============================================================================" + color.RESET);
    
            while (infoSet.next()) 
            {
                int dbID = infoSet.getInt("employee_id");
                String dbUsername = infoSet.getString("username");
                String dbRole = infoSet.getString("role");
                String dbName = infoSet.getString("name");
                String dbSurname = infoSet.getString("surname");
                String dbPhone = infoSet.getString("phone_no");
                String dbDOB = infoSet.getString("date_of_birth");
                String dbDOS = infoSet.getString("date_of_start");
                String dbEmail = infoSet.getString("email");
    
                System.out.printf(color.WHITE + "| %-10d | %-15s | %-15s | %-30s | %-15s | %-13s | %-12s | %-30s%n",
                        dbID, dbUsername, dbRole, dbName + " " + dbSurname, dbPhone, dbDOB, dbDOS, dbEmail + color.RESET);
            }
    
            System.out.println(color.MAGENTA + "==============================================================================" + 
                    "==============================================================================" + color.RESET);
    
        } 
        catch (SQLException e) 
        {
            System.err.println(color.BRIGHT_RED + "Error occurred: " + e.getMessage() + color.RESET);
        }
    }
    
    
    /**
     * Displays the details of an employee with a specified username.
     * The details include employee ID, username, role, name, phone number,
     * date of birth, start date, and email. If no such user exists, a message is displayed.
     *
     * @param username the username of the employee to retrieve
     */
    public void DispEmployeeWithUsername(String username) 
    {
        if (connection == null) {
            System.err.println(color.BRIGHT_RED + "Database connection failed!!" + color.RESET);
            return;
        }
    
        String query2do = "SELECT * FROM employees WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query2do)) 
        {
            statement.setString(1, username);
    
            ResultSet infoSet = statement.executeQuery();
    
            
            if (!infoSet.isBeforeFirst()) 
            {
                System.out.println(color.BRIGHT_RED + "User named " + username + " does not exist in the database." + color.RESET);
                return;
            }
    
            System.out.println(color.MAGENTA + "==============================================================================" +
                    "==============================================================================" + color.RESET);
            System.out.printf(color.BRIGHT_BLUE + "| %-10s | %-15s | %-15s | %-30s | %-15s | %-13s | %-12s | %-30s%n",
                    "Emp ID", "Username", "Role", "Name", "Phone No", "Date of Birth", "Start Date", "Email" + color.RESET);
            System.out.println(color.MAGENTA + "==============================================================================" +
                    "==============================================================================" + color.RESET);
    
        
            while (infoSet.next()) 
            {
                int dbID = infoSet.getInt("employee_id");
                String dbUsername = infoSet.getString("username");
                String dbRole = infoSet.getString("role");
                String dbName = infoSet.getString("name");
                String dbSurname = infoSet.getString("surname");
                String dbPhone = infoSet.getString("phone_no");
                String dbDOB = infoSet.getString("date_of_birth");
                String dbDOS = infoSet.getString("date_of_start");
                String dbEmail = infoSet.getString("email");
    
                System.out.printf(color.WHITE + "| %-10d | %-15s | %-15s | %-30s | %-15s | %-13s | %-12s | %-30s%n",
                        dbID, dbUsername, dbRole, dbName + " " + dbSurname, dbPhone, dbDOB, dbDOS, dbEmail + color.RESET);
            }
    
            System.out.println(color.MAGENTA + "==============================================================================" +
                    "==============================================================================" + color.RESET);
    
        } 
        catch (SQLException e) 
        {
            System.out.println(color.BRIGHT_RED + "Error occurred: " + e.getMessage() + color.RESET);
        }
    }
    

    /**
     * Updates the details of an employee based on the provided choice.
     * It allows updating various employee attributes such as username, role, name, surname, 
     * date of birth, and date of start.
     *
     * @param choice The character representing the field to be updated.
     *               '1' for username, '2' for role, '3' for name, '4' for surname, '5' for date of birth, 
     *               '6' for date of start.
     * @param tempEmployee The Employee object whose details are being updated.
     * @param inputHandler The InputHandler object that provides methods to receive user input.
     */
    public void UpdateEmployeeNPF(char choice,Employee tempEmployee,InputHandler inputHandler)
    {
        switch (choice) {
            case '1': 
            {
                Ccleaner();
                String newUsername = inputHandler.UsernameInput();
                Ccleaner();
                String updateUsernameQuery = "UPDATE employees SET username = ? WHERE username = ?";
                try (PreparedStatement statement = connection.prepareStatement(updateUsernameQuery)) 
                {
                    
                    statement.setString(1, newUsername);
                    statement.setString(2, tempEmployee.getUsername());
    
                    int rowsAffected = statement.executeUpdate();
    
                    // Check if the username is the same as the old one
                    if (newUsername.equals(tempEmployee.getUsername())) 
                    {
                        System.out.println(color.BRIGHT_YELLOW + "New username is the same as the old one." + color.RESET);
                    }
    
                    if (rowsAffected > 0) 
                    {
                        System.out.println(color.BRIGHT_GREEN + "Username " + tempEmployee.getUsername() + " updated to " + newUsername + " successfully!" + color.RESET);
                    } 
                    else 
                    {
                        System.out.println(color.BRIGHT_RED + "Update failed. Username not found!!" + color.RESET);
                    }
    
                } 
                catch (SQLException e) 
                {
                    System.out.println(color.BRIGHT_RED + "Error occurred while updating username: " + color.RESET);
                    e.printStackTrace();
                }
    
                tempEmployee.setUsername(newUsername);
    
                break;
                //username
            }
            case '2': 
            {
                Ccleaner();
                
                String newRole = inputHandler.RoleInput(tempEmployee.getRole());
                Ccleaner();
                
                String updateRoleQuery = "UPDATE employees SET role = ? WHERE username = ?";
                try (PreparedStatement statement = connection.prepareStatement(updateRoleQuery)) 
                {
                    statement.setString(1, newRole);
                    statement.setString(2, tempEmployee.getUsername());
            
                    int rowsAffected = statement.executeUpdate();
            
                    if (rowsAffected > 0) 
                    {
                        System.out.println(color.BRIGHT_GREEN + "Username " + tempEmployee.getUsername() + "'s role updated to " + newRole + " from " + tempEmployee.getRole() + " successfully!" + color.RESET);
                    } 
                    else 
                    {
                        System.out.println(color.BRIGHT_RED + "Update failed. Username not found!!" + color.RESET);
                    }
            
                } 
                catch (SQLException e) 
                {
                    System.out.println(color.BRIGHT_RED + "Error occurred while updating role: " + color.RESET);
                    e.printStackTrace();
                }
                
                tempEmployee.setRole(newRole);
                break;
            }
            
            case '3':
            {
                Ccleaner();
                String newName = inputHandler.NameInput(tempEmployee.getName());
                String nameBox = newName.replace("'", "''");
                Ccleaner();
                
                String updateNameQuery = "UPDATE employees SET name = ? WHERE username = ?";
                try 
                {
                    PreparedStatement statement = connection.prepareStatement(updateNameQuery);
                    statement.setString(1, nameBox);
                    statement.setString(2, tempEmployee.getUsername());

                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0)
                    {
                        System.out.println(color.BRIGHT_GREEN + "Username " + tempEmployee.getUsername() + "'s name updated to " + newName + " from " + tempEmployee.getName() + " successfully!" + color.RESET);
                    } 
                    else 
                    {
                        System.out.println(color.BRIGHT_RED + "Update failed. Username not found!!" + color.RESET);
                    }

                } 
                catch (SQLException e) 
                {
                    System.out.println(color.BRIGHT_RED + "Error occurred while updating username: " + color.RESET);
                    e.printStackTrace();
                }

                tempEmployee.setName(newName);
                break;
                //name
            }

            case '4':
            {
                Ccleaner();
                String newSurname = inputHandler.SurnameInput(tempEmployee.getSurname());
                String surnameBox = newSurname.replace("'", "''");

                Ccleaner();
                String updateSurnameQuery = "UPDATE employees SET surname = ? WHERE username = ?";
                try 
                {
                    PreparedStatement statement = connection.prepareStatement(updateSurnameQuery);
                    statement.setString(1, surnameBox);
                    statement.setString(2, tempEmployee.getUsername());

                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0)
                    {
                        System.out.println(color.BRIGHT_GREEN + "Username " + tempEmployee.getUsername() + "'s surname updated to " + newSurname + " from " + tempEmployee.getSurname() + " successfully!" + color.RESET);
                    } 
                    else 
                    {
                        System.out.println(color.BRIGHT_RED + "Update failed. Username not found!!" + color.RESET);
                    }

                } 
                catch (SQLException e) 
                {
                    System.out.println(color.BRIGHT_RED + "Error occurred while updating surname: " + color.RESET);
                    e.printStackTrace();
                }

                tempEmployee.setSurname(newSurname);
                break;
                //surname
            }

            case '5':
            {
                Ccleaner();
                LocalDate newDOB;
                while (true) 
                { 
                    newDOB = inputHandler.DobInput(tempEmployee.getBirthday());
                    Period age = Period.between(newDOB, tempEmployee.getEmploymentday());
                    if (age.getYears() < 18)
                    {
                        System.out.println(color.BRIGHT_RED + "You must be at least 18 years old!!" + color.RESET);
                    }
                    else
                    {
                        break;
                    }
                }

                Ccleaner();
                String updateDOBQuery = "UPDATE employees SET date_of_birth = ? WHERE username = ?";
                try 
                {
                    PreparedStatement statement = connection.prepareStatement(updateDOBQuery);
                    statement.setDate(1, java.sql.Date.valueOf(newDOB)); // Converts LocalDate to SQL Date
                    statement.setString(2, tempEmployee.getUsername());

                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0)
                    {
                        System.out.println(color.BRIGHT_GREEN + "Username " + tempEmployee.getUsername() + "'s date of birth updated to " + newDOB + " from " + tempEmployee.getBirthday() + " successfully!" + color.RESET);
                    } 
                    else 
                    {
                        System.out.println(color.BRIGHT_RED + "Update failed. Username not found!!" + color.RESET);
                    }

                } 
                catch (SQLException e) 
                {
                    System.out.println(color.BRIGHT_RED + "Error occurred while updating date of birth: " + color.RESET);
                    e.printStackTrace();
                }

                tempEmployee.setBirthday(newDOB);
                break;
                //Dob
            }

            case '6':
            {
                Ccleaner();
                LocalDate newDOS;
                while (true)
                { 
                    newDOS = inputHandler.DosInput(tempEmployee.getEmploymentday());
                    Period age = Period.between(tempEmployee.getBirthday(), newDOS);
                    if (age.getYears() < 18)
                    {
                        System.out.println(color.BRIGHT_RED + "You must be at least 18 years old!!" + color.RESET);
                    }
                    else
                    {
                        break;
                    }
                }

                Ccleaner();
                String updateDOSQuery = "UPDATE employees SET date_of_start = ? WHERE username = ?";
                try 
                {
                    PreparedStatement statement = connection.prepareStatement(updateDOSQuery);
                    statement.setDate(1, java.sql.Date.valueOf(newDOS)); // Converts LocalDate to SQL Date
                    statement.setString(2, tempEmployee.getUsername());

                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0)
                    {
                        System.out.println(color.BRIGHT_GREEN + "Username " + tempEmployee.getUsername() + "'s date of start updated to " + newDOS + " from " + tempEmployee.getEmploymentday() + " successfully!" + color.RESET);
                    } 
                    else 
                    {
                        System.out.println(color.BRIGHT_RED + "Update failed. Username not found!!" + color.RESET);
                    }

                } 
                catch (SQLException e) 
                {
                    System.out.println(color.BRIGHT_RED + "Error occurred while updating date of start: " + color.RESET);
                    e.printStackTrace();
                }

                tempEmployee.setEmploymentDay(newDOS);
                break;
            }

        }
        
    } 

    /**
     * Adds a new employee to the database.
     * The employee's details such as username, name, surname, role, date of birth, and date of start 
     * are inserted into the employees table. The password is automatically generated as "Khas" + username.
     *
     * @param username The username of the new employee.
     * @param name The name of the new employee.
     * @param surname The surname of the new employee.
     * @param role The role of the new employee (e.g., "Manager" or "Regular").
     * @param dob The date of birth of the new employee.
     * @param dos The date of start of the new employee.
     */
    public void HireEmployee(String username, String name, String surname, String role, LocalDate dob, LocalDate dos)
    {
        // Add employee to the database
        if (connection == null)
        {
            System.err.println(color.BRIGHT_RED + "Database connection failed!!" + color.RESET);
            return;
        }

        try
        {
            String nameBox = name.replace("'", "''");
            String surnameBox = surname.replace("'", "''");
            String randompassword = "Khas" + username;

            String query2do = "INSERT INTO employees (username, name, surname, role, date_of_birth, date_of_start, password) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(query2do))
            {
                statement.setString(1, username);
                statement.setString(2, nameBox);
                statement.setString(3, surnameBox);
                statement.setString(4, role);
                statement.setDate(5, java.sql.Date.valueOf(dob));  // Converting LocalDate to SQL Date
                statement.setDate(6, java.sql.Date.valueOf(dos));  // Converting LocalDate to SQL Date
                statement.setString(7, randompassword);

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0)
                {
                    Ccleaner();
                    System.out.println(color.BRIGHT_GREEN + "Added Employee " + name + " " + surname + " to the database" + color.RESET);
                }
                else
                {
                    System.out.println(color.BRIGHT_RED + "Error adding employee to the database!!" + color.RESET);
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(color.BRIGHT_RED + "Error occurred during employee insertion: " + e.getMessage() + color.RESET);
            e.printStackTrace();
        }
    }

    
    /**
     * Removes an employee from the database based on the provided username.
     * The employee's record will be deleted from the employees table.
     *
     * @param username The username of the employee to be removed.
     */
    public void FireEmployee(String username)
    {
        try
        {
            // Get the employee details first
            Employee victim = GetEmployeeWithUsername(username);
            
            if (victim == null)
            {
                System.out.println(color.BRIGHT_RED + "Employee with username " + username + " does not exist!" + color.RESET);
                return;
            }

            // Prepare SQL query to delete employee
            String query2do = "DELETE FROM employees WHERE username = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(query2do))
            {
                statement.setString(1, username);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0)
                {
                    Ccleaner();
                    System.out.println(color.RED + "Employee " + victim.getName() + " " + victim.getSurname() + " has been deleted from the database" + color.RESET);
                }
                else
                {
                    Ccleaner();
                    System.out.println(color.BRIGHT_RED + "Error removing employee from the database!!" + color.RESET);
                }
            }
        }
        catch (SQLException e)
        {
            Ccleaner();
            System.out.println(color.BRIGHT_RED + "Error removing employee from the database!!" + color.RESET);
            e.printStackTrace();
        }
    }

    
    /**
     * Retrieves an employee's details from the database based on the provided username.
     * The method constructs an Employee object based on the data from the database.
     *
     * @param username The username of the employee to retrieve.
     * @return The Employee object containing the employee's details, or null if the employee is not found.
     */
    public Employee GetEmployeeWithUsername(String username)
    {
        if (connection == null)
        {
            System.err.println(color.BRIGHT_RED + "Database connection failed!!" + color.RESET);
        }

        try
        {
            String query2do = "SELECT * FROM employees WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query2do);
            statement.setString(1, username);
            ResultSet infoSet = statement.executeQuery();

            if (!infoSet.isBeforeFirst()) // This checks if there are any rows in the ResultSet 
            { 
                //isBeforeFirst() Retrieves whether the cursor is before the first row in this ResultSet object.
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "User named " + username + " does not exist in the database!!" + color.RESET);
                return null;
            }

            while(infoSet.next())
            {
                int dbID = infoSet.getInt("employee_id");
                String dbUsername = infoSet.getString("username");
                String dbRole = infoSet.getString("role");
                String dbName = infoSet.getString("name");
                String dbSurname = infoSet.getString("surname");
                String dbPhone = infoSet.getString("phone_no");
                Date dbDOB = infoSet.getDate("date_of_birth");
                Date dbDOS = infoSet.getDate("date_of_start");
                String dbEmail = infoSet.getString("email");
                String dbPassword = infoSet.getString("password");
                Boolean dbDefault = infoSet.getBoolean("DEFAULT_PASSWORD");

                LocalDate localDOB = dbDOB.toLocalDate();
                LocalDate localDOS = dbDOS.toLocalDate();

                if(dbUsername == "")
                {
                    break;
                }

                if(dbRole.equals("Manager"))
                {
                    //System.out.println("Login successfull!");
                    return new Manager(dbID, dbUsername, dbRole, dbName, dbSurname, dbPhone, localDOB, localDOS, dbEmail, dbPassword, dbDefault);
                }
                else
                {
                    return new RegularEmployee(dbID, dbUsername, dbRole, dbName, dbSurname, dbPhone, localDOB, localDOS, dbEmail, dbPassword, dbDefault);
                }
            }
            
        }
        catch (SQLException e)
        {
            System.out.println(color.BRIGHT_RED + "Error occured!" + color.RESET);
        }
        return null;
    }

    
    /**
     * Retrieves an employee's details from the database based on the provided username and password.
     * The method constructs an Employee object based on the data from the database.
     *
     * @param username The username of the employee to retrieve.
     * @param password The password of the employee for authentication.
     * @return The Employee object containing the employee's details, or null if the employee is not found or the password is incorrect.
     */
    public Employee GetEmployeeWithUsernameAndPassword(String username, String password)
    {
        if (connection == null)
        {
            System.err.println(color.BRIGHT_RED + "Database connection failed" + color.RESET);
        }

        try 
        {
            String query2do = "SELECT * FROM employees WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query2do);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet infoSet = statement.executeQuery();

            if (!infoSet.isBeforeFirst()) // This checks if there are any rows in the ResultSet 
            { 
                //isBeforeFirst() Retrieves whether the cursor is before the first row in this ResultSet object.
                return null;
            }
            
            while(infoSet.next())
            {
                int dbID = infoSet.getInt("employee_id");
                String dbUsername = infoSet.getString("username");
                String dbRole = infoSet.getString("role");
                String dbName = infoSet.getString("name");
                String dbSurname = infoSet.getString("surname");
                String dbPhone = infoSet.getString("phone_no");
                Date dbDOB = infoSet.getDate("date_of_birth");
                Date dbDOS = infoSet.getDate("date_of_start");
                String dbEmail = infoSet.getString("email");
                String dbPassword = infoSet.getString("password");
                Boolean dbDefault = infoSet.getBoolean("DEFAULT_PASSWORD");

                LocalDate localDOB = dbDOB.toLocalDate();
                LocalDate localDOS = dbDOS.toLocalDate();

                if (dbUsername == "")
                {
                    break;
                }

                if (dbRole.equals("Manager"))
                {
                    return new Manager(dbID, dbUsername, dbRole, dbName, dbSurname, dbPhone, localDOB, localDOS, dbEmail, dbPassword, dbDefault);
                }
                else
                {
                    return new RegularEmployee(dbID, dbUsername, dbRole, dbName, dbSurname, dbPhone, localDOB, localDOS, dbEmail, dbPassword, dbDefault);
                }
            }
            
        } 
        catch (SQLException e) 
        {
            System.out.println(color.BRIGHT_RED + "Error occurred!" + color.RESET);
        }
        return null;
    }

    
 
    
    
    /* public boolean CheckUsernameDup(String username)
    {
        if(connection == null)
        {
            System.err.println(color.BRIGHT_RED + "Database connection failed!!" + color.RESET);
        }

        try 
        {
            Statement statement = connection.createStatement();
            String query2do = "SELECT COUNT(*) AS count FROM employees WHERE username = '" + username + "'";
            ResultSet infoSet = statement.executeQuery(query2do);
            if(infoSet.next())
            {
                int count = infoSet.getInt("count");
                
                if(count>0)
                {
                    return true;
                }
            }
            
            
        } 
        catch (SQLException e) 
        {
            System.out.println(color.BRIGHT_RED + "Error occured!!"  + color.RESET);
        }
        return false;
    } */

    /**
     * Checks if a given field contains a duplicate value in the database.
     * 
     * @param field The field in the database to check for duplicates (e.g., "email", "phone_no").
     * @param value The value to check for duplication in the specified field.
     * @param <T> The type of the value (can be String, Integer, etc.).
     * @return true if the value exists in the specified field in the database; false otherwise.
     */
    public <T> boolean CheckDuplicate(String field, T value)
    {
        if (connection == null)
        {
            System.err.println(color.BRIGHT_RED + "Database connection failed!!" + color.RESET);
            return false; 
        }

        try 
        {
            String query = "SELECT COUNT(*) AS count FROM employees WHERE " + field + " = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, value); //This is important
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                int count = resultSet.getInt("count");
                if (count > 0)
                {
                    return true; 
                }
            }
        } 
        catch (SQLException e) 
        {
            System.err.println(color.BRIGHT_RED + "Error occurred while checking duplicate for " + field + color.RESET);
        }
        return false; 
    }


    /**
     * Prints the profile of an employee based on their username.
     * This includes employee details like ID, username, role, name, surname, phone number, 
     * date of birth, date of start, and email.
     *
     * @param username The username of the employee whose profile will be printed.
     */
    public void PrintProfile(String username)
    {
        if(connection == null)
        {
            System.err.println(color.BRIGHT_RED + "Database connection failed!!");
            return;
        }

        try 
        {
            String query2do = "SELECT * FROM employees WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query2do);
            statement.setString(1, username); // Set the username parameter

            ResultSet infoSet = statement.executeQuery();

            if(infoSet.next())
            {
                int dbID = infoSet.getInt("employee_id");
                String dbUsername = infoSet.getString("username");
                String dbRole = infoSet.getString("role");
                String dbName = infoSet.getString("name");
                String dbSurname = infoSet.getString("surname");
                String dbPhone = infoSet.getString("phone_no");
                String dbDOB = infoSet.getString("date_of_birth");
                String dbDOS = infoSet.getString("date_of_start");
                String dbEmail = infoSet.getString("email");

                System.out.println(color.MAGENTA + "Full profile information" + color.RESET);
                System.out.println(color.WHITE + "Employee ID: " + dbID + color.RESET);
                System.out.println(color.WHITE + ", Username: " + dbUsername + color.RESET);
                System.out.println(color.WHITE + ", Role: " + dbRole + color.RESET);
                System.out.println(color.WHITE + ", Name: " + dbName + color.RESET);
                System.out.println(color.WHITE + ", Surname: " + dbSurname + color.RESET);
                System.out.println(color.WHITE + ", Phone Number: " + dbPhone + color.RESET);
                System.out.println(color.WHITE + ", Date of Birth: " + dbDOB + color.RESET); 
                System.out.println(color.WHITE + ", Date of Start: " + dbDOS + color.RESET);
                System.out.println(color.WHITE + ", Email: " + dbEmail + color.RESET);
                System.out.println(color.MAGENTA + "-----------------------------------------------" + color.RESET);
            }

        } 
        catch (SQLException e) 
        {
            System.out.println(color.BRIGHT_RED + "Error occurred!!" + color.RESET);
        }
    }


    /**
     * Updates the phone number of an employee in the database based on their employee ID.
     * If the update is successful, a success message is printed.
     *
     * @param employee_id The ID of the employee whose phone number needs to be updated.
     * @param phone The new phone number to be set for the employee.
     */
    public void UpdatePhone(int employee_id, String phone)
    {
        String query2do = "UPDATE employees SET phone_no = ? WHERE employee_id = " + employee_id;

        try(PreparedStatement statement = connection.prepareStatement(query2do))
        {
            statement.setString(1, phone);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_GREEN + "Phone number updated succesfully\n");
            }
            else
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Error updating phone!!");
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(color.BRIGHT_RED + "Error updating phone!!" + color.RESET);
            e.printStackTrace(); 
        }
    }

    /**
     * Updates the password of an employee in the database based on their employee ID.
     * If the update is successful, a success message is printed.
     *
     * @param employee_id The ID of the employee whose password needs to be updated.
     * @param password The new password to be set for the employee.
     */
    public void UpdatePassword(int employee_id, String password)
    {
        String query2do = "UPDATE employees SET password = ?, DEFAULT_PASSWORD = FALSE WHERE employee_id = " + employee_id;

        try(PreparedStatement statement = connection.prepareStatement(query2do))
        {
            statement.setString(1, password);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_GREEN + "Password updated succesfully\n" + color.RESET);
            }
            else
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Error updating password!!" + color.RESET);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(color.BRIGHT_RED + "Error updating password!!" + color.RESET);
            e.printStackTrace(); 
        }
    }

    /**
     * Updates the email address of an employee in the database based on their employee ID.
     * If the update is successful, a success message is printed.
     *
     * @param employee_id The ID of the employee whose email needs to be updated.
     * @param email The new email address to be set for the employee.
     */
    public void UpdateEmail(int employee_id, String email)
    {
        String query2do = "UPDATE employees SET email = ? WHERE employee_id = " + employee_id;

        try(PreparedStatement statement = connection.prepareStatement(query2do))
        {
            statement.setString(1, email);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_GREEN + "Email updated succesfully\n" + color.RESET);
            }
            else
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Error updating email!!" + color.RESET);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(color.BRIGHT_RED + "Error updating email!!" + color.RESET);
            e.printStackTrace(); 
        }
    }


    /**
     * Clears the console screen.
     * 
     * This method attempts to clear the console by running a system command. 
     * If an error occurs during the process, an error message is printed.
     * 
     *
     */
    static  void Ccleaner()
    {
        try 
        {
            new ProcessBuilder("cmd","/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) 
        {
            System.err.println("Error Code #Clear");
        }
    }
}

