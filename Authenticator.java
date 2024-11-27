import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.protocol.Resultset;

public class Authenticator 
{
    private final String url = "jdbc:mysql://localhost:3306/FirmManagement"; // Replace with your DB URL
    private final String username = "root"; // Replace with your DB username
    private final String password = "Admin_123"; // Replace with your DB password
    private Connection connection;
    DataBaseHandler dbHandler = new DataBaseHandler();

    private Employee currUser;

    public Employee login(String username, String password)
    {

        try 
        {
            Employee newEmployee = dbHandler.GetEmployeeWithUsername(username);
            if(newEmployee != null)
            {
                this.currUser = newEmployee;
                System.out.println("");
                return newEmployee;

            }
            else
            {
                System.err.println("");
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
        if(this.currUser == null)
        {
            System.out.println("");
            this.currUser = null;
        }
        else
        {
            System.err.println("Error");
        }
    }

    
}
