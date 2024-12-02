package users;
import java.time.LocalDate;
import java.util.Scanner;

import utilities.AsciiArt;
import utilities.InputUtil;

public class RegularEmployee extends Employee
{
    AsciiArt color = new AsciiArt();
    public static Scanner input = InputUtil.scanner;
    public RegularEmployee(int ID, String Username, String Role, String Name, String Surname, String Phone, LocalDate DOB, LocalDate DOS, String Email, String Password, Boolean DEFAULT_PASSWORD)
    {
        super(ID, Username,Role,Name,Surname,Phone,DOB,DOS,Email,Password, DEFAULT_PASSWORD);
    }

    // Regular Employee Menu
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

            System.out.println(color.WHITE + " 1. Profile Information");
            System.out.println(color.WHITE + " 2. Update Information");
            System.out.println(color.WHITE + " 3. Logout");
            System.out.println(color.MAGENTA + "-----------------------------------------------------" + color.RESET);
            System.out.print(color.BRIGHT_BLUE + "Select an Operation (1-3): ");

            RMString = input.nextLine();

            // Checks single character inputs
            if(RMString.isEmpty() || RMString.length() > 1)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 3." + color.RESET);
                System.out.println();
                continue;
            }
            RMInput = RMString.charAt(0);
            System.out.println();

            if (RMInput < '1' || RMInput > '3') 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED+ "You entered an invalid input. Please enter a number between 1 and 3." + color.RESET);
                System.out.println();
            }
        

            // Executes selected operation
            switch (RMInput)
            {
                case '1'-> //Profile info
                {
                    Ccleaner();
                    PrintProfile();
                    System.out.println("Enter anything to return");
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

