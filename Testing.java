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
    }
}

// javac -cp .;lib/mysql-connector-j-8.2.0.jar Testing.java
// java -cp .;lib/mysql-connector-j-8.2.0.jar Testing
