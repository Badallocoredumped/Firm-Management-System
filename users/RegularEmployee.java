package users;
import java.time.LocalDate;
import java.util.Scanner;

import utilities.AsciiArt;
import utilities.InputUtil;

/**
 * Represents a regular employee in the system. Extends the Employee class and 
 * provides specific functionality for the regular employee menu and profile management.
 */
public class RegularEmployee extends Employee
{
    AsciiArt color = new AsciiArt();
    public static Scanner input = InputUtil.scanner;


    /**
     * Constructor for the RegularEmployee class.
     * Initializes the regular employee with the provided attributes.
     *
     * @param ID The employee's unique ID.
     * @param Username The username of the employee.
     * @param Role The role of the employee.
     * @param Name The first name of the employee.
     * @param Surname The surname of the employee.
     * @param Phone The phone number of the employee.
     * @param DOB The date of birth of the employee.
     * @param DOS The date of start of the employee.
     * @param Email The email address of the employee.
     * @param Password The password of the employee.
     * @param DEFAULT_PASSWORD A flag indicating whether the employee has a default password.
     */
    public RegularEmployee(int ID, String Username, String Role, String Name, String Surname, String Phone, LocalDate DOB, LocalDate DOS, String Email, String Password, Boolean DEFAULT_PASSWORD)
    {
        super(ID, Username,Role,Name,Surname,Phone,DOB,DOS,Email,Password, DEFAULT_PASSWORD);
    }

    // Regular Employee Menu
    /**
     * Displays the employee menu and handles user input to allow the regular employee to:
     * 1. View their profile information.
     * 2. Update their profile information.
     * 3. Log out of the system.
     * <p>
     * This method runs a loop that continuously displays the menu until the employee selects 
     * the option to log out (option '3').
     * </p>
     */
    @Override
    public void Menu()
    {
        String RMString;
        char RMInput = '0';
        while(RMInput != '3')
        {
            System.out.println(color.MAGENTA + "=====================================================" + color.RESET);
            System.out.println(color.MAGENTA + "                *** Employee Menu ***                " + color.RESET);
            System.out.println(color.MAGENTA + "=====================================================" + color.RESET);
            System.out.println(color.BRIGHT_BLUE + "Good day, " + getRole() + " " + getName() + " " + getSurname() + "!" + color.RESET);
            System.out.println(color.MAGENTA + "-----------------------------------------------------" + color.RESET);
            System.out.println(color.WHITE + " 1. Profile Information" + color.RESET);
            System.out.println(color.WHITE + " 2. Update Information" + color.RESET);
            System.out.println(color.WHITE + " 3. Logout" + color.RESET);
            System.out.println(color.MAGENTA + "-----------------------------------------------------" + color.RESET);
            System.out.print(color.BRIGHT_BLUE + "Select an Operation (1-3): ");

            RMString = input.nextLine();

            // Checks single character inputs
            if(RMString.isEmpty() || RMString.length() > 1)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 3!!" + color.RESET);
                System.out.println();
                continue;
            }
            RMInput = RMString.charAt(0);
            System.out.println();

            if (RMInput < '1' || RMInput > '3') 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED+ "You entered an invalid input. Please enter a number between 1 and 3!!" + color.RESET);
                System.out.println();
            }
        

            // Executes selected operation
            switch (RMInput)
            {
                case '1'-> //Profile info
                {
                    Ccleaner();
                    PrintProfile();
                    System.out.println(color.BRIGHT_BLUE +"Enter anything to return" + color.RESET);
                    input.nextLine();
                    Ccleaner();
                }

                case '2'-> //Update info
                {
                    Ccleaner();
                    UpdateProfile();
                }
                
                case '3'-> //Logout
                {
                    Ccleaner();
                    System.out.print(color.RED + "Logginng out...");
                    return;
                }

                default -> 
                {
                    Ccleaner();
                    System.out.println(color.WHITE + "Please enter a number between 1 and 3");
                }
            }
        }
    }

    

    
}

