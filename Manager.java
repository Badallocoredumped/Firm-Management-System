import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;


public class Manager extends Employee
{
    DataBaseHandler dbHandler = new DataBaseHandler();
    InputHandler inHandle = new InputHandler();
    SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

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
 
    public Manager(int ID, String Username,String Role,String Name,String Surname,String Phone,LocalDate DOB,LocalDate DOS,String Email,String Password)
    {
        super(ID, Username,Role,Name,Surname,Phone,DOB,DOS,Email,Password);
    }


    @Override
    public void Menu() 
    {
        Scanner scanner = new Scanner(System.in);
        String RMString;
        char RMInput = '0';
        while(RMInput != '9')
        {
            System.out.println("\n--- Manager Menu ---");
            System.out.println("1. Update Profile");
            System.out.println("2. Display All Employees"); //done
            System.out.println("3. Display Employees by Role");//done
            System.out.println("4. Display Employee by Username");//done
            System.out.println("5. Update Employee (Non-Profile Fields)");//done
            System.out.println("6. Hire Employee");//done
            System.out.println("7. Fire Employee");//done
            System.out.println("8. Algorithms");//done
            System.out.println("9. Logout"); //done
            System.out.print("Select an option: ");

            RMString = scanner.nextLine();

            // Checks single character inputs
            if(RMString.isEmpty() || RMString.length() > 1)
            {
                Ccleaner();
                System.out.println("You entered an invalid input. Please enter a number between 1 and 9.");
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
                case '1' ->  //Update will do later
                {
                    Ccleaner();
                    UpdateProfile();
                }
                case '2' -> 
                {
                    Ccleaner();
                    dbHandler.DispAllEmployee();
                }
                case '3' -> 
                {
                    Ccleaner();
                    String role = inHandle.RoleInput();
                    dbHandler.DispEmployeeWithRole(role);
                }
                case '4' -> 
                {
                    Ccleaner();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    dbHandler.DispEmployeeWithUsername(username);
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
                }
                case '7' -> 
                {
                    Ccleaner();
                    FireEmployeeManager();
                }
                case '8' -> 
                {
                    Ccleaner();
                    boolean want2return = false;
                    System.out.println("Help me please");
                    while(!want2return)
                    {
                        sortingAlgorithms.getInputAndRunAlgorithms(scanner);
                        want2return = inHandle.WannaReturn(scanner, want2return);
                    }
                }
                case '9' -> 
                {
                    Ccleaner();
                    System.out.println("Logging out...");
                    return;
                }
                //default -> System.out.println("Invalid option. Please try again.");
            }
        }
                
        scanner.close();
    }


    protected void UpdateProfile()
    {

    }

    protected void HireEmployeeManager()
    {
        Username = inHandle.UsernameInput();
        name = inHandle.NameInput();
        surname = inHandle.SurnameInput();
        role = inHandle.RoleInput();
        phone = inHandle.PhoneInput();
        while(true)
        {
            DOB = inHandle.DobInput();
            DOS = inHandle.DosInput();
            if(inHandle.DoesDatesMakeSense(DOB, DOS))
            {
                break;
            }
        }
        Email = inHandle.EmailInput();
        
        dbHandler.HireEmployee(Username, name, surname, role, phone, DOB, DOS, Email);
    }

    protected void FireEmployeeManager()
    {
        
        String victimName = inHandle.UsernameInputToOperate();
        Employee employee = dbHandler.GetEmployeeWithUsername(victimName);
        if(employee.Username.equals(Username))
        {
            System.out.println("You can not fire yourself!!!!!");
            return;

        }

        if(employee.role.equalsIgnoreCase("manager"))
        {
            System.out.println("You can not fire other managers!");
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
        
        //Non-profile so everything except password phoneno and email
        //Update all or any of the non-profile 
        
    }
    
    protected void DisplayAllEmployee()
    {

    }

    protected void DisplayEmployeeWithRole()
    {

    }   
    
    protected void DisplayEmployeeWithUsername()
    {

    }

    protected void RunAlgortihms()
    {
        //not my part
    }

    
}
