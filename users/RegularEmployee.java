package users;
import java.time.LocalDate;
import java.util.Scanner;

public class RegularEmployee extends Employee
{
    public static Scanner input = new Scanner(System.in);
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
            System.out.println("Employee menu");
            System.out.println("1. Profile Information");
            System.out.println("2. Update Information");
            System.out.println("3. Logout");
            System.out.println();
            System.out.print("Select an Operation: ");
            RMString = input.nextLine();

            // Checks single character inputs
            if(RMString.isEmpty() || RMString.length() > 1)
            {
                Ccleaner();
                System.out.println("You entered an invalid input. Please enter a number between 1 and 3.");
                System.out.println();
                continue;
            }
            RMInput = RMString.charAt(0);
            System.out.println();

            if (RMInput < '1' || RMInput > '3') 
            {
                Ccleaner();
                System.out.println("You entered an invalid input. Please enter a number between 1 and 3.");
                System.out.println();
            }
        

            // Executes selected operation
            switch (RMInput)
            {
                case '1'-> //Profile info
                {
                    Ccleaner();
                    PrintProfile();
                }

                case '2'-> //Update info
                {
                    Ccleaner();
                    UpdateProfile();
                }
                
                case '3'-> //Logout
                // Professor reply: We should go to the login page after log out and put a exit(terminate) on the login page
                {
                    Ccleaner();
                    System.out.print("Logginng out...");
                    return;
                }

                default -> 
                {
                    Ccleaner();
                    System.out.println("Please enter a number between 1 and 3");
                }
            }
        }
    }

    

    
}

