import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.protocol.Resultset;

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
