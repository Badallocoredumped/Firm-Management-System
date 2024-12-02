package users;
import java.time.LocalDate;
import java.util.Scanner;

import utilities.AsciiArt;
import utilities.DataBaseHandler;
import utilities.InputHandler;
import utilities.InputUtil;
import utilities.SortingAlgorithms;

public class Manager extends Employee
{
    DataBaseHandler dbHandler = new DataBaseHandler();
    InputHandler inHandle = new InputHandler();
    SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
    AsciiArt color = new AsciiArt();

    /* protected int ID;
    protected String username;
    protected String role;
    protected String name;
    protected String surname;
    protected String phone;
    protected LocalDate DOB;
    protected LocalDate DOS;
    protected String email;
    protected String password; */
 
    public Manager(int ID, String Username,String Role,String Name,String Surname,String Phone,LocalDate DOB,LocalDate DOS,String Email,String Password,Boolean DEFAULT_PASSWORD)
    {
        super(ID, Username,Role,Name,Surname,Phone,DOB,DOS,Email,Password,DEFAULT_PASSWORD);
    }


    @Override
    public void Menu() 
    {
        Scanner scanner = InputUtil.scanner;
        String RMString;
        char RMInput = '0';
        while(RMInput != '9')
        {
            //add display profile
            System.out.println(color.MAGENTA + "=================================" + color.RESET);
            System.out.println(color.MAGENTA + "      *** Manager Menu ***       " + color.RESET);
            System.out.println(color.MAGENTA + "=================================" + color.RESET);
            System.out.println(color.BRIGHT_BLUE + "Good day, " + getName() + "!" + color.RESET);
            System.out.println(color.MAGENTA + "---------------------------------" + color.RESET);
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
            System.out.println(color.MAGENTA +"---------------------------------"+ color.RESET);
            System.out.print(color.WHITE + "Select an option (0-9): " + color.RESET);


            RMString = scanner.nextLine();

            // Checks single character inputs
            if(RMString.isEmpty() || RMString.length() > 1)
            {
                Ccleaner();
                System.out.println(color.WHITE + "You entered an invalid input. Please enter a number between 1 and 9.");
                System.out.println();
                continue;
            }
            RMInput = RMString.charAt(0);
            System.out.println();

            if (RMInput < '1' || RMInput > '9') 
            {
                    Ccleaner();
                    System.out.println("You entered an invalid input. Please enter a number between 1 and 9.");
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


    
    protected void HireEmployeeManager()
    {
        String newUsername = inHandle.UsernameInput();
        String newName = inHandle.NameInput("");
        String newSurname = inHandle.SurnameInput("");
        String newRole = inHandle.RoleInput("");
        String newPhone = inHandle.PhoneInput("");
        LocalDate newDOB;
        LocalDate newDOS;
        while(true)
        {
            newDOB = inHandle.DobInput(null);
            newDOS = inHandle.DosInput(null);
            if(inHandle.DoesDatesMakeSense(newDOB, newDOS))
            {
                Ccleaner();
                break;
            }
            Ccleaner();
            System.out.println("So you were born after you got the job. Amazing employe.");
        }
        String newEmail = inHandle.EmailInput("");
        
        dbHandler.HireEmployee(newUsername, newName, newSurname, newRole, newPhone, newDOB, newDOS, newEmail);
    }

    protected void FireEmployeeManager()
    {
        
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

    
    protected void UpdateSelf()
    {
        //this will be overidden from the employee superclass
    }
    
    protected void UpdateEmployee()
    {
         
        inHandle.UpdateInput();
        
        
    }
    
    

    
}
