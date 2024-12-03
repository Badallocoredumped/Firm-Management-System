package users;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import utilities.AsciiArt;
import utilities.DataBaseHandler;
import utilities.InputHandler;
import utilities.InputUtil;
import utilities.SortingAlgorithms;




/**
 * The Manager class represents a Manager user in the Firm Management System.
 * 
 * This class extends the Employee superclass and provides additional functionality
 * specific to the Manager role. Managers can perform various operations such as 
 * viewing and managing employees, hiring and firing, and accessing algorithms 
*/

public class Manager extends Employee
{
    DataBaseHandler dbHandler = new DataBaseHandler();
    InputHandler inHandle = new InputHandler();
    SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
    AsciiArt color = new AsciiArt();


    /**
     * Constructs a Manager object with the specified attributes.
     *
     * @param ID              Unique identifier for the manager.
     * @param Username        The manager's username.
     * @param Role            The role of the user (Manager).
     * @param Name            The manager's first name.
     * @param Surname         The manager's last name.
     * @param Phone           The manager's phone number.
     * @param DOB             Date of birth of the manager.
     * @param DOS             Date of starting in the organization.
     * @param Email           The manager's email address.
     * @param Password        The manager's password.
     * @param DEFAULT_PASSWORD Whether the password is default or customized.
     */
    public Manager(int ID, String Username,String Role,String Name,String Surname,String Phone,LocalDate DOB,LocalDate DOS,String Email,String Password,Boolean DEFAULT_PASSWORD)
    {
        super(ID, Username,Role,Name,Surname,Phone,DOB,DOS,Email,Password,DEFAULT_PASSWORD);
    }

    /**
     * Displays the Manager's menu and processes user input.
     * 
     * The menu allows the manager to perform actions such as viewing and updating profiles,
     * managing employees, and executing algorithms. The menu runs in a loop until the manager
     * chooses to log out.
     */
    @Override
    public void Menu() 
    {
        Scanner scanner = InputUtil.scanner;
        String RMString;
        char RMInput = '0';
        while(RMInput != '9')
        {
            //add display profile
            System.out.println(color.MAGENTA + "=========================================" + color.RESET);
            System.out.println(color.MAGENTA + "          *** Manager Menu ***           " + color.RESET);
            System.out.println(color.MAGENTA + "=========================================" + color.RESET);
            System.out.println(color.BRIGHT_BLUE + "Good day, " + getRole() + " " + getName() + " " + getSurname() + "!" + color.RESET);
            System.out.println(color.MAGENTA + "-----------------------------------------" + color.RESET);
            System.out.println(color.WHITE + " 0. Display Profile");
            System.out.println(" 1. Update Profile");
            System.out.println(" 2. Display All Employees");
            System.out.println(" 3. Display Employees by Role");
            System.out.println(" 4. Display Employee by Username");
            System.out.println(" 5. Update Employee (Non-Profile Fields)");
            System.out.println(" 6. Hire Employee");
            System.out.println(" 7. Fire Employee");
            System.out.println(" 8. Algorithms");
            System.out.println(" 9. Logout" + color.RESET);
            System.out.println(color.MAGENTA +"-----------------------------------------"+ color.RESET);
            System.out.print(color.WHITE + "Select an option (0-9): " + color.RESET);


            RMString = scanner.nextLine();

            // Checks single character inputs
            if(RMString.isEmpty() || RMString.length() > 1)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 9!!" + color.RESET);
                System.out.println();
                continue;
            }
            RMInput = RMString.charAt(0);
            System.out.println();

            if (RMInput < '1' || RMInput > '9') 
            {
                    Ccleaner();
                    System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 9!!" + color.RESET);
                    System.out.println();
            }
        
            switch (RMInput) 
            {
                case '0' ->  
                {
                    Ccleaner();
                    PrintProfile();
                    System.out.println("Enter anything to return");
                    scanner.nextLine();
                    Ccleaner();
                    
                }
                case '1' ->  
                {
                    Ccleaner();
                    UpdateProfile();
                    Ccleaner();
                    
                }
                case '2' -> 
                {
                    Ccleaner();
                    dbHandler.DispAllEmployee();
                    System.out.println("Enter anything to return");
                    scanner.nextLine();
                    Ccleaner();
                }
                case '3' -> 
                {
                    Ccleaner();
                    String role = inHandle.RoleInput("");
                    Ccleaner();
                    dbHandler.DispEmployeeWithRole(role);
                    System.out.println("Enter anything to return");
                    scanner.nextLine();
                    Ccleaner();
                }
                case '4' -> 
                {
                    Ccleaner();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    Ccleaner();
                    dbHandler.DispEmployeeWithUsername(username);
                    System.out.println("Enter anything to return");
                    scanner.nextLine();
                    Ccleaner();
                }
                case '5' -> 
                {
                    Ccleaner();
                    UpdateEmployee();
                }
                case '6' -> 
                {
                    Ccleaner();
                    HireEmployeeManager();
                    System.out.println("Enter anything to return");
                    scanner.nextLine();
                    Ccleaner();

                }
                case '7' -> 
                {
                    Ccleaner();
                    FireEmployeeManager();
                    System.out.println("Enter anything to return");
                    scanner.nextLine();
                    Ccleaner();
                }
                case '8' -> 
                {
                    Ccleaner();
                    boolean want2return = false;
                    while(!want2return)
                    {
                        sortingAlgorithms.getInputAndRunAlgorithms(scanner);
                        want2return = inHandle.WannaReturn(scanner, want2return);
                    }
                }
                case '9' -> 
                {
                    Ccleaner();
                    System.out.println("Logging out..." + color.RESET);
                    return;
                }
            }
        }
                
        scanner.close();
    }


    /**
     * Allows the manager to hire a new employee.
     * 
     * The method collects necessary details about the new employee such as
     * username, name, surname, role, date of birth, and date of starting. The
     * details are validated before being added to the database.
     */
    protected void HireEmployeeManager()
    {
        String newUsername = inHandle.UsernameInput();
        Ccleaner();
        String newName = inHandle.NameInput("");
        Ccleaner();
        String newSurname = inHandle.SurnameInput("");
        Ccleaner();
        String newRole = inHandle.RoleInput("");
        Ccleaner();
        //String newPhone = inHandle.PhoneInput("");
        //String newPassword = inHandle.PasswordInput("");
        LocalDate newDOB;
        LocalDate newDOS;
        while(true)
        {
            newDOB = inHandle.DobInput(null);
            newDOS = inHandle.DosInput(null);
            Period age = Period.between(newDOB, newDOS);

            if(age.getYears() < 18)
            {
                System.out.println("You must be at least 18 years old!!");
                continue;
            }
            if(inHandle.DoesDatesMakeSense(newDOB, newDOS))
            {
                Ccleaner();
                break;
            }
            Ccleaner();
            System.out.println("So you were born after you got the job. Amazing employe.");
        }
        //String newEmail = inHandle.EmailInput("");
        
        dbHandler.HireEmployee(newUsername, newName, newSurname, newRole, newDOB, newDOS);
    }

    /**
     * Allows the manager to fire an existing employee.
     * 
     * The method verifies if the employee exists and prevents the manager from
     * firing themselves. If validation succeeds, the employee is removed from
     * the database.
     */
    protected void FireEmployeeManager()
    {
        boolean abort = false;
        Scanner tempScanner = InputUtil.scanner;
        
        
        /* System.out.println(color.BRIGHT_RED + "You are about to fire an employee." + color.RESET);
        System.out.println(color.BRIGHT_RED + "There will be no more warnings" + color.RESET); */
        abort = inHandle.WannaAbort(tempScanner,abort);
        if(abort)
        {
            return;
        }
        
        String victimName = inHandle.UsernameInputToOperate();
        Employee employee = dbHandler.GetEmployeeWithUsername(victimName);
        if(employee == null)
        {
            return;
        }
        if(employee.Username.equals(Username))
        {
            System.out.println("You can not fire yourself!!!!!");
            return;

        }

        dbHandler.FireEmployee(victimName);
        employee = null;
    }

    /**
     * Updates information for an existing employee.
     * 
     * The method prompts the manager to modify specific fields of the employee
     * profile except for personal details.
     */
    protected void UpdateEmployee()
    {
         
        inHandle.UpdateInput(this.Username);
        
        
    }
    
    

    
}
