import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

    //Username should not be a duplicate

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
            System.out.println("Database connected successfully!");            
        } 
        catch (SQLException e) 
        {
            System.err.println("Database connection failed: " + e.getMessage());
        }
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

    public void UpdateEmployeeNPF()
    {
        //Update employees NPF fields: Everything except password, phone_no, and e-mail






        /* int dbID = infoSet.getInt("employee_id");
        String dbUsername = infoSet.getString("username");
        String dbRole = infoSet.getString("role");
        String dbName = infoSet.getString("name");
        String dbSurname = infoSet.getString("surname");
        //String dbPhone = infoSet.getString("phone_no");
        String dbDOB = infoSet.getString("date_of_birth");
        String dbDOS = infoSet.getString("date_of_start");
        //String dbEmail = infoSet.getString("email");
        */
    } 

    private void HireEmployee(String username, String name, String surname, String role, String phone, String dob, String dos, String email)
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
    public void HireEmployeeForManager(String username, String name, String surname, String role, String phone, String dob, String dos, String email)
    {
        HireEmployee(username, name, surname, role, phone, dob, dos, email);
    }
    
    void FireEmployee(int employee_id,String username)
    {
        //Remove employee from the database
        //Ask if you are sure you want to delete
        try 
        {
            Statement statement = connection.createStatement();
            String query2do = "DELETE FROM employees WHERE employee_id = " + employee_id;
            int rowsAffected = statement.executeUpdate(query2do);

            Employee victim = GetEmployeeWithUsername(username);

            if(rowsAffected > 0)
            {
                System.out.println("Employee " + victim.name + " " + victim.surname + " has been deleted from the database");
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
    public void FireEmployeeForManager(int employee_id,String username)
    {
        FireEmployee(employee_id,username);
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

                if(dbRole.equals("Manager"))
                {
                    System.out.println("Login successfull!");
                    return new Manager(dbID,dbUsername,dbRole,dbName,dbSurname,dbPhone,dbDOB,dbDOS,dbEmail,dbPassword);
                }
                else
                {
                    return new RegularEmployee(dbID,dbUsername,dbRole,dbName,dbSurname,dbPhone,dbDOB,dbDOS,dbEmail,dbPassword);
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
