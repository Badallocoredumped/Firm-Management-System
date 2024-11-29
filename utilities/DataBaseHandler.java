
package utilities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import users.Employee;
import users.Manager;
import users.RegularEmployee;





    //Username should not be a duplicate
    //need to change the datatype for all DOS DOB
    //database is case insensitive

public class DataBaseHandler 
{
    private final String url = "jdbc:mysql://localhost:3306/FirmManagement"; // Replace with your DB URL
    private final String username = "root"; // Replace with your DB username
    private final String password = "Admin_123"; // Replace with your DB password
    private Connection connection;
    
    public DataBaseHandler()
    {
        try 
        {
            connection = DriverManager.getConnection(url, username, password);
            //System.out.println("Database connected successfully!");   
            //This works twice when changing managers         
        } 
        catch (SQLException e) 
        {
            System.err.println("Database connection failed: " + e.getMessage());
        }
    }

    public void CountAllEmployee()
    {
        //maybe add subfunctions that prints how many people you have for each role

    }

    public void DispAllEmployee()
    {
        if(connection == null)
        {
            System.err.println("Database connection failed");
            return;
        }

        try 
        {
                        
            //Maybe make this a seperate function
            Statement countStatement = connection.createStatement();
            String countQuery = "SELECT COUNT(*) AS total FROM employees";
            ResultSet countResult = countStatement.executeQuery(countQuery);
            
            int totalEmployees = 0;
            if (countResult.next()) 
            {
                totalEmployees = countResult.getInt("total");
            }
            //Maybe make this a seperate function
            Statement roleStatement = connection.createStatement();
            String query = "SELECT role, COUNT(*) AS role_count FROM employees GROUP BY role";
            ResultSet resultSet = roleStatement.executeQuery(query);

            


            Statement statement = connection.createStatement();
            String query2do = "SELECT * FROM employees";
            ResultSet infoSet = statement.executeQuery(query2do);

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

                LocalDate dob = dbDOB.toLocalDate();
                LocalDate dos = dbDOS.toLocalDate();

                System.out.println("Employee ID: " + dbID + ", Username: " + dbUsername + ", Role: " + dbRole +
                   ", Name: " + dbName + " " + dbSurname + ", Phone Number: " + dbPhone + 
                   ", Date of Birth: " + dob + ", Date of Start: " + dos + ", Email: " + dbEmail);
            }

            //Maybe make this a seperate function
            System.out.println();
            while (resultSet.next()) 
            {
                String role = resultSet.getString("role");
                int count = resultSet.getInt("role_count");
                System.out.println("Role: " + role + " | Number of Employees: " + count);
            }

            //Maybe make this a seperate function
            System.out.println("\nTotal number of employees: " + totalEmployees);


        } 
        catch (SQLException e) 
        {
            System.out.println("Error occured!");
        }

    }

    public void DispEmployeeWithRole(String role)
    {
        if(connection == null)
        {
            System.err.println("Database connection failed");
        }

        try 
        {
            Statement statement = connection.createStatement();
            String query2do = "SELECT * FROM employees WHERE role = '" + role + "'";
            ResultSet infoSet = statement.executeQuery(query2do);

            while(infoSet.next())
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

                System.out.println("Employee ID: " + dbID + ", Username: " + dbUsername + ", Role: " + dbRole +
                   ", Name: " + dbName + " " + dbSurname + ", Phone Number: " + dbPhone + 
                   ", Date of Birth: " + dbDOB + ", Date of Start: " + dbDOS + ", Email: " + dbEmail);
            }
            
        } 
        catch (SQLException e) 
        {
            System.out.println("Error occured!");
        }
    }

    public void DispEmployeeWithUsername(String username)
    {
        if(connection == null)
        {
            System.err.println("Database connection failed");
        }

        try 
        {
            Statement statement = connection.createStatement();
            String query2do = "SELECT * FROM employees WHERE username = '" + username + "'";
            ResultSet infoSet = statement.executeQuery(query2do);
            if (!infoSet.isBeforeFirst()) // This checks if there are any rows in the ResultSet 
            { 
                //isBeforeFirst() Retrieves whether the cursor is before the first row in this ResultSet object.
                System.out.println("User named " + username + " does not exist in the database inside displayemployee.");
            }
            while(infoSet.next())
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

                System.out.println("Employee ID: " + dbID + ", Username: " + dbUsername + ", Role: " + dbRole +
                    ", Name: " + dbName + " " + dbSurname + ", Phone Number: " + dbPhone + 
                    ", Date of Birth: " + dbDOB + ", Date of Start: " + dbDOS + ", Email: " + dbEmail);
                
            }
        }
        catch (SQLException e) 
        {
            System.out.println("Error occured!");
        }
    }

    public void DispEmployeeWithNameSurname(String Name,String Surname)
    {
        if(connection == null)
        {
            System.err.println("Database connection failed");
        }

        try 
        {
            Statement statement = connection.createStatement();
            String query2do = "SELECT * FROM employees WHERE name = '" + Name + "' AND surname = '" + Surname + "'";

            ResultSet infoSet = statement.executeQuery(query2do);

            while(infoSet.next())
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

                System.out.println("Employee ID: " + dbID + ", Username: " + dbUsername + ", Role: " + dbRole +
                   ", Name: " + dbName + " " + dbSurname + ", Phone Number: " + dbPhone + 
                   ", Date of Birth: " + dbDOB + ", Date of Start: " + dbDOS + ", Email: " + dbEmail);
            }
            
        } 
        catch (SQLException e) 
        {
            System.out.println("Error occured!");
        }
    }

    public void UpdateEmployeeNPF(char choice,Employee tempEmployee,InputHandler inputHandler)
    {
        switch (choice) 
        {
            case '1':
            {
                String newUsername = inputHandler.UsernameInput();
                String updateUsernameQuery = "UPDATE employees SET username = '" + newUsername + "' WHERE username = '" + tempEmployee.getUsername() + "'";
                try 
                {
                    Statement statement = connection.createStatement();
                    int rowsAffected = statement.executeUpdate(updateUsernameQuery);

                    if (rowsAffected > 0)
                    {
                        System.out.println("Username " + tempEmployee.getUsername() + " updated to " + newUsername + " successfully!");
                    } 
                    else 
                    {
                        System.out.println("Update failed. Username not found.");
                    }
                    
                } 
                catch (SQLException e) 
                {
                    System.out.println("Error occurred while updating username: ");
                    e.printStackTrace();
                }
                tempEmployee.setUsername(newUsername);


                break;
                //username
            }
            case '2':
            {
                String newRole = inputHandler.RoleInput();
                String updateRoleQuery = "UPDATE employees SET role = '" + newRole + "' WHERE username = '" + tempEmployee.getUsername() + "'";
                try 
                {
                    Statement statement = connection.createStatement();
                    int rowsAffected = statement.executeUpdate(updateRoleQuery);

                    if (rowsAffected > 0)
                    {
                        System.out.println("Username " + tempEmployee.getUsername() + "'s role updated to " + newRole + " from " + tempEmployee.getRole() + " successfully!");
                    } 
                    else 
                    {
                        System.out.println("Update failed. Username not found.");
                    }
                    
                } 
                catch (SQLException e) 
                {
                    System.out.println("Error occurred while updating username: ");
                    e.printStackTrace();
                }
                tempEmployee.setRole(newRole);
                break;
                //role
            }
            case '3':
            {
                String newName = inputHandler.NameInput();
                String updateNameQuery = "UPDATE employees SET name = '" + newName + "' WHERE username = '" + tempEmployee.getUsername() + "'";
                try 
                {
                    Statement statement = connection.createStatement();
                    int rowsAffected = statement.executeUpdate(updateNameQuery);

                    if (rowsAffected > 0)
                    {
                        System.out.println("Username " + tempEmployee.getUsername() + "'s name updated to " + newName + " from " + tempEmployee.getName() + " successfully!");
                    } 
                    else 
                    {
                        System.out.println("Update failed. Username not found.");
                    }
                    
                } 
                catch (SQLException e) 
                {
                    System.out.println("Error occurred while updating username: ");
                    e.printStackTrace();
                }
                tempEmployee.setName(newName);
                break;
                //name
            }
            case '4':
            {
                String newSurname = inputHandler.SurnameInput();
                String updateSurnameQuery = "UPDATE employees SET surname = '" + newSurname + "' WHERE username = '" + tempEmployee.getUsername() + "'";
                try 
                {
                    Statement statement = connection.createStatement();
                    int rowsAffected = statement.executeUpdate(updateSurnameQuery);

                    if (rowsAffected > 0)
                    {
                        System.out.println("Username " + tempEmployee.getUsername() + "'s surname updated to " + newSurname + " from " + tempEmployee.getSurname() + " successfully!");
                    } 
                    else 
                    {
                        System.out.println("Update failed. Username not found.");
                    }
                    
                } 
                catch (SQLException e) 
                {
                    System.out.println("Error occurred while updating username: ");
                    e.printStackTrace();
                }
                tempEmployee.setSurname(newSurname);
                break;
                //surname
            }
            case '5':
            {
                LocalDate newDOB = inputHandler.DobInput();
                String updateDOBQuery = "UPDATE employees SET date_of_birth = '" + newDOB + "' WHERE username = '" + tempEmployee.getUsername() + "'";
                try 
                {
                    Statement statement = connection.createStatement();
                    int rowsAffected = statement.executeUpdate(updateDOBQuery);

                    if (rowsAffected > 0)
                    {
                        System.out.println("Username " + tempEmployee.getUsername() + "'s date of birth updated to " + newDOB + " from " + tempEmployee.getBirthday() + " successfully!");
                    } 
                    else 
                    {
                        System.out.println("Update failed. Username not found.");
                    }
                    
                } 
                catch (SQLException e) 
                {
                    System.out.println("Error occurred while updating username: ");
                    e.printStackTrace();
                }
                tempEmployee.setBirthday(newDOB);
                break;
                //DOB
            }
            case '6':
            {
                LocalDate newDOS = inputHandler.DosInput();
                String updateDOSQuery = "UPDATE employees SET date_of_start = '" + newDOS + "' WHERE username = '" + tempEmployee.getUsername() + "'";
                try 
                {
                    Statement statement = connection.createStatement();
                    int rowsAffected = statement.executeUpdate(updateDOSQuery);

                    if (rowsAffected > 0)
                    {
                        System.out.println("Username " + tempEmployee.getUsername() + "'s date of start updated to " + newDOS + " from " + tempEmployee.getEmploymentday() + " successfully!");
                    } 
                    else 
                    {
                        System.out.println("Update failed. Username not found.");
                    }
                    
                } 
                catch (SQLException e) 
                {
                    System.out.println("Error occurred while updating username: ");
                    e.printStackTrace();
                }
                tempEmployee.setEmploymentDay(newDOS);
                break;
                //DOS
            }
            case '7':
            {
                String newEmail = inputHandler.EmailInput();
                String updateEmailQuery = "UPDATE employees SET email = '" + newEmail + "' WHERE username = '" + tempEmployee.getUsername() + "'";
                try 
                {
                    Statement statement = connection.createStatement();
                    int rowsAffected = statement.executeUpdate(updateEmailQuery);

                    if (rowsAffected > 0)
                    {
                        System.out.println("Username " + tempEmployee.getUsername() + "'s date of start updated to " + newEmail + " from " + tempEmployee.getEmail() + " successfully!");
                    } 
                    else 
                    {
                        System.out.println("Update failed. Username not found.");
                    }
                    
                } 
                catch (SQLException e) 
                {
                    System.out.println("Error occurred while updating username: ");
                    e.printStackTrace();
                }
                tempEmployee.setEmail(newEmail);
                break;
                //email
            }
            /* default:
            {
                System.out.println("Invalid option. Please try again.");
            } */
        
        }
        
    } 

    public void HireEmployee(String username, String name, String surname, String role, String phone, LocalDate dob, LocalDate dos, String email)
    {
        //Add employee to the database
        if(connection == null)
        {
            System.err.println("Database connection failed");
        }

        try 
        {
            Statement statement = connection.createStatement();
            String randompassword = "Khas"+username;
            String query2do = "INSERT INTO employees (username, name, surname, role, phone_no, date_of_birth, date_of_start, email,password) " +
            "VALUES ('" + username + "', '" + name + "', '" + surname + "', '" + role + "', '" + phone + "', '" + dob + "', '" + dos + "', '" + email + "', '" + randompassword + "')";
            

            int rowsAffected = statement.executeUpdate(query2do);

            if(rowsAffected > 0)
            {
                System.out.println("Added Employee " + name + " " + surname + " to the database");
            }
            else
            {
                System.out.println("Error adding employee to the database");
            }
            
            
        } 
        catch (SQLException e) 
        {
            System.out.println("Error occurred during employee insertion: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    public void FireEmployee(String username)
    {
        //Remove employee from the database
        //Ask if you are sure you want to delete
        try 
        {
            Statement statement = connection.createStatement();
            
            Employee victim = GetEmployeeWithUsername(username);
            String query2do = "DELETE FROM employees WHERE username = '" + username + "'";
            int rowsAffected = statement.executeUpdate(query2do);


            if(rowsAffected > 0)
            {
                System.out.println("Employee " + victim.getName() + " " + victim.getSurname() + " has been deleted from the database");
            }
            else
            {
                System.out.println("Error removing employee from the database");
            }


        } 
        catch (SQLException e) 
        {
            System.out.println("Error removing employee from the database");
            e.printStackTrace(); 
        }
    }
    
    public Employee GetEmployeeWithUsername(String username)
    {
        if(connection == null)
        {
            System.err.println("Database connection failed");
        }

        try 
        {
            Statement statement = connection.createStatement();
            String query2do = "SELECT * FROM employees WHERE username = '" + username + "'";
            ResultSet infoSet = statement.executeQuery(query2do);

            if (!infoSet.isBeforeFirst()) // This checks if there are any rows in the ResultSet 
            { 
                //isBeforeFirst() Retrieves whether the cursor is before the first row in this ResultSet object.
                System.out.println("User named " + username + " does not exist in the database. inside get employee");
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

                LocalDate localDOB = dbDOB.toLocalDate();
                LocalDate localDOS = dbDOS.toLocalDate();

                if(dbUsername == "")
                {
                    break;
                }
                if(dbRole.equals("Manager"))
                {
                    //System.out.println("Login successfull!");
                    return new Manager(dbID,dbUsername,dbRole,dbName,dbSurname,dbPhone,localDOB,localDOS,dbEmail,dbPassword);
                }
                else
                {
                    return new RegularEmployee(dbID,dbUsername,dbRole,dbName,dbSurname,dbPhone,localDOB,localDOS,dbEmail,dbPassword);
                }
                
            }
            
        } 
        catch (SQLException e) 
        {
            System.out.println("Error occured!");
        }
        return null;

    }
    
 
    
    
    public boolean CheckUsernameDup(String username)
    {
        if(connection == null)
        {
            System.err.println("Database connection failed");
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
            System.out.println("Error occured!");
        }
        return false;

    }
}
