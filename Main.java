
import java.util.Scanner;

import users.Employee;
import users.Manager;
import users.RegularEmployee;
import utilities.AsciiArt;
import utilities.Authenticator;


public class Main 
{
    public static void main(String[] args)
    {
        AsciiArt asciiArt = new AsciiArt();

        //Add register??
        //check if the name is the same or someshit in manager update thing
        //Make the phone number exactly 10 digits max maybe change the database 
        //Make sure you log in and credential are correct before updating the password

        //Algorithms needs to be english
        //password should accept turkish
        //Alara has to do the ascii
        //ask teh registration

        Scanner scanner = InputUtil.scanner;
        Authenticator authenticator = new Authenticator();
        Employee currUser = null;
        boolean systemPower = true;
        

        String RMString;
        char RMInput = '0';
        

        
        while (systemPower) 
        {
            // Main menu: Login or Exit System
            asciiArt.printWelcome();
            System.out.println(asciiArt.GREEN + "1. Login" + asciiArt.RESET);
            System.out.println(asciiArt.RED + "2. Exit System" + asciiArt.RESET);
            System.out.println();
            System.out.print(asciiArt.WHITE + "Select an Operation (1-2): " + asciiArt.RESET);
            RMString = scanner.nextLine();
        
            // Validate single character input
            if (RMString.isEmpty() || RMString.length() > 1) 
            {
                Ccleaner();
                System.out.println(asciiArt.WHITE + "Invalid input. Please enter 1 to Login or 2 to Exit."  + asciiArt.RESET);
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
                    System.out.println(asciiArt.WHITE + "Please login with your username and password!"  + asciiArt.RESET);
                    System.out.print(asciiArt.BLUE + "Username: " + asciiArt.RESET);
                    String userName = scanner.nextLine();
        
                    System.out.print(asciiArt.BLUE + "Password: " + asciiArt.RESET);
                    String password = scanner.nextLine();
                    currUser = authenticator.login(userName, password);
                    if (currUser == null) 
                    {
                        Ccleaner();
                        System.out.println(asciiArt.WHITE +"Login failed. Please try again." + asciiArt.RESET);
                    }
                }
        
                // Role-based menu
                
                if (currUser instanceof Manager) 
                {
                    Ccleaner();
                    currUser.Menu();
                    System.out.println(asciiArt.WHITE + "Enter anything to return" + asciiArt.RESET);
                    scanner.nextLine();
                    Ccleaner();
                } 
                else if (currUser instanceof RegularEmployee) 
                {
                    Ccleaner();
                    currUser.Menu();
                    System.out.println(asciiArt.WHITE + "Enter anything to return" + asciiArt.RESET);
                    scanner.nextLine();
                    Ccleaner();
                }
        
                authenticator.logout(currUser);
                currUser = null;
        
            } 
            else if (RMInput == '2') 
            {
                // Exit system
                Ccleaner();
                System.out.println(asciiArt.WHITE + "Exiting the Firm Management System. Goodbye!" + asciiArt.RESET);
                systemPower = false;
                scanner.close();
        
            } 
            else 
            {
                // Invalid input
                Ccleaner();
                System.out.println(asciiArt.WHITE + "Invalid input. Please enter 1 to Login or 2 to Exit." + asciiArt.RESET);
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
