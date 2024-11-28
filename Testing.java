import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;


public class Testing 
{
    public static void main(String[] args) 
    {
        Authenticator Auth = new Authenticator();
        Auth.LoginMenu();
        /*Scanner input = new Scanner(System.in);
        DataBaseHandler dbHandler = new DataBaseHandler();
        String username = "Teca7";
        Employee employee = dbHandler.GetEmployeeWithUsername(username);
        System.out.print("New password: ");
        String NewPassword = input.nextLine();
        dbHandler.UpdatePassword(employee.getID(), NewPassword);*/
    }
}

// javac -cp .;lib/mysql-connector-j-8.2.0.jar Testing.java
// java -cp .;lib/mysql-connector-j-8.2.0.jar Testing
