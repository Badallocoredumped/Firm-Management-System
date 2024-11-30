
import java.util.Scanner;

import users.Employee;
import users.Manager;
import users.RegularEmployee;
import utilities.Authenticator;
import utilities.DataBaseHandler;


public class Main 
{
    public static void main(String[] args)
    {
        /*dbHandler.DispAllEmployee();
        System.out.println("Displayed All Employees");
        dbHandler.DispEmployeeWithRole("manager");
        System.out.println("Displayed All Employees with the role");
        dbHandler.DispEmployeeWithUsername("emir5757");
        dbHandler.DispEmployeeWithNameSurname("Emir","Özen");
        dbHandler.HireEmployee("dummyvolkan", "Volkan", "Erdoğan", "intern", "0523432", "2022.11.01", "2022.12.2", "bozoman");
        dbHandler.FireEmployee(22,"dummyvolkan"); */


        //Add register
        DataBaseHandler dbHandler = new DataBaseHandler();
        Scanner scanner = new Scanner(System.in);
        Authenticator authenticator = new Authenticator();
        Employee currUser = null;
        boolean systemPower = true;

        String RMString;
        char RMInput = '0';
        

        
        while (systemPower) 
        {
            // Main menu: Login or Exit System
            System.out.println("Welcome to the Firm Management System!");
            System.out.println("1. Login");
            System.out.println("2. Exit System");
            System.out.println();
            System.out.print("Select an Operation: ");
            RMString = scanner.nextLine();
        
            // Validate single character input
            if (RMString.isEmpty() || RMString.length() > 1) 
            {
                Ccleaner();
                System.out.println("Invalid input. Please enter 1 to Login or 2 to Exit.");
                System.out.println();
                continue;
            }
        
            RMInput = RMString.charAt(0);
        
            if (RMInput == '1') 
            {
                // Login flow
                Ccleaner();
                while (currUser == null) 
                {
                    System.out.println("Please login with your username and password!");
                    System.out.print("Username: ");
                    String userName = scanner.nextLine();
        
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
        
                    currUser = authenticator.login(userName, password);
        
                    if (currUser == null) 
                    {
                        Ccleaner();
                        System.out.println("Login failed. Please try again.\n");
                    }
                }
        
                // Role-based menu
                
                if (currUser instanceof Manager) 
                {
                    Ccleaner();
                    System.out.println("Logged in as a Manager");
                    currUser.Menu();
                    System.out.println("Exited Manager Menu");
                } 
                else if (currUser instanceof RegularEmployee) 
                {
                    Ccleaner();
                    System.out.println("Logged in as a Regular Employee");
                    currUser.Menu();
                    System.out.println("Exited Regular Employee Menu");
                }
        
                authenticator.logout();
                currUser = null;
        
            } 
            else if (RMInput == '2') 
            {
                // Exit system
                Ccleaner();
                System.out.println("Exiting the Firm Management System. Goodbye!");
                systemPower = false;
                scanner.close();
        
            } 
            else 
            {
                // Invalid input
                Ccleaner();
                System.out.println("Invalid input. Please enter 1 to Login or 2 to Exit.\n");
            }
        }

    }
    
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
