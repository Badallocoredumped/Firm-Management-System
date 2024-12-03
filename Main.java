import java.util.Scanner;

import users.Employee;
import users.Manager;
import users.RegularEmployee;
import utilities.AsciiArt;
import utilities.Authenticator;
import utilities.InputUtil;


/**
 * Main class for the Firm Management System.
 * 
 * This class serves as the entry point for the application. It handles the 
 * main menu, user login/logout flow, and role-based menu navigation. The system 
 * supports roles like Manager and RegularEmployee, and interacts with utility 
 * classes such as AsciiArt, Authenticator, and InputUtil.
 * 
 * The system continues running until the user opts to exit.
 */
public class Main 
{
    public static void main(String[] args)
    {
        AsciiArt asciiArt = new AsciiArt();
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
            asciiArt.PrintAuthors();
            System.out.println(asciiArt.GREEN + "1. Login" + asciiArt.RESET);
            System.out.println(asciiArt.RED + "2. Exit System" + asciiArt.RESET);
            System.out.println();
            System.out.print(asciiArt.WHITE + "Select an Operation (1-2): " + asciiArt.RESET);
            RMString = scanner.nextLine();
        
            // Validate single character input
            if (RMString.isEmpty() || RMString.length() > 1) 
            {
                Ccleaner();
                System.out.println(asciiArt.BRIGHT_RED + "Invalid input. Please enter 1 to Login or 2 to Exit!!"  + asciiArt.RESET);
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
                    System.out.println(asciiArt.WHITE + "Please login with your username and password!!"  + asciiArt.RESET);
                    System.out.print(asciiArt.BLUE + "Username: " + asciiArt.RESET);
                    String userName = scanner.nextLine();
        
                    System.out.print(asciiArt.BLUE + "Password: " + asciiArt.RESET);
                    String password = scanner.nextLine();
                    currUser = authenticator.login(userName, password);
                    if (currUser == null) 
                    {
                        Ccleaner();
                        System.out.println(asciiArt.BRIGHT_RED +"Login failed. Please try again!!" + asciiArt.RESET);
                    }
                }
        
                // Role-based menu
                
                if (currUser instanceof Manager) 
                {
                    Ccleaner();
                    currUser.Menu();
                    Ccleaner();
                } 
                else if (currUser instanceof RegularEmployee) 
                {
                    Ccleaner();
                    currUser.Menu();
                    Ccleaner();
                }
        
                authenticator.logout(currUser);
                currUser = null;
        
            } 
            else if (RMInput == '2') 
            {
                // Exit system
                Ccleaner();
                System.out.println(asciiArt.RED + "Exiting the Firm Management System. Goodbye!!" + asciiArt.RESET);
                systemPower = false;
                scanner.close();
        
            } 
            else 
            {
                // Invalid input
                Ccleaner();
                System.out.println(asciiArt.BRIGHT_RED + "Invalid input. Please enter 1 to Login or 2 to Exit!!" + asciiArt.RESET);
            }
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
