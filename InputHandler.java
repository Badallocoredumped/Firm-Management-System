import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

public class InputHandler 
{
    Scanner scanner = new Scanner(System.in);
    DataBaseHandler dbHandler = new DataBaseHandler();

    protected String UsernameInput()
    {
        String username;
        while (true) 
        {
            System.out.print("Enter a Username (Minimum 4 characters): ");
            username = scanner.nextLine().trim();
            if(dbHandler.CheckUsernameDup(username))
            {
                System.out.println("Username " + username + " is already taken!");
            }
            else if(username.length()<4)
            {
                System.out.println("Username " + username + " is smaller than 4 characters!");
            }
            else if(username.isBlank())
            {
                System.out.println("Username can not be blank!");
            }
            else
            {
                return username;
            }
        }
    }
    protected String UsernameInputToOperate()
    {
        String username;
        while (true) 
        {
            System.out.print("Enter a Username (Minimum 4 characters): ");
            username = scanner.nextLine().trim();
            
            if(username.length()<4)
            {
                System.out.println("Username " + username + " is smaller than 4 characters!");
            }
            else if(username.isBlank())
            {
                System.out.println("Username can not be blank!");
            }
            else
            {
                return username;
            }
        }
    }
    
    //NOTE: The matches() method in Java checks if a string matches a given regular expression (regex)
    protected String NameInput()
    {
        String name;
        while (true) 
        {
            System.out.print("Enter Name: ");
            name = scanner.nextLine().trim();
            if (name.matches("^[A-Za-zÇçŞşİıĞğÖöÜü]+$")) 
            {
                return name;
            } 
            else 
            {
                System.out.println("Invalid name! Name should only contain letters and cannot be blank.");
            }
        }
    }
    protected String SurnameInput()
    {
        String surname = "";
        while (true) 
        {
            System.out.print("Enter Surname: ");
            surname = scanner.nextLine().trim();
            if (surname.matches("^[A-Za-zÇçŞşİıĞğÖöÜü]+$")) 
            {
                return surname;
            } 
            else 
            {
                System.out.println("Invalid surname! Surname should only contain letters and cannot be blank.");
            }
        }
    }
    
    protected String RoleInput()
    {
        Set<String> validRoles = Set.of("manager", "engineer", "technician", "intern"); //Simple hashset
        String role;
        while (true) 
        {
            System.out.print("Enter Role (manager, engineer, technician, intern): ");
            role = scanner.nextLine().trim().toLowerCase();
            if (validRoles.contains(role)) 
            {
                return role; 
            } 
            else 
            {
                Ccleaner();
                System.out.println("Invalid role. Please enter one of the following: manager, engineer, technician, intern.");
            }
        }
    }

    protected String PhoneInput()
    {
        String phone = "";
        while (true) 
        {
            System.out.print("Enter Phone Number: ");
            phone = scanner.nextLine().trim();
            if (phone.matches("\\d{1,15}")) //This checks if its maching the digits from 0 to 9, and atleast 1 time at most 15 times
            {
                return phone;
            } 
            else 
            {
                System.out.println("Invalid phone number! It should only contain numbers, cannot be empty, and must not exceed 15 digits.");
            }
        }
    }

    protected LocalDate DobInput()
    {
        //Make sure date of start can not be smaller than date of birth
        while(true)
        {
            
            System.out.println("Enter Date of Birth (YYYY-MM-DD):");
            String dobInput = scanner.nextLine();
    
            try 
            {
                LocalDate dob = LocalDate.parse(dobInput, DateTimeFormatter.ISO_LOCAL_DATE);
                System.out.println("Valid Date of Birth: " + dob);
                return dob;
            } 
            catch (Exception e) 
            {
                System.out.println("Invalid date format! Please use YYYY-MM-DD.");
            }

        }
    }

    protected LocalDate DosInput()
    {
        while(true)
        {
            
            System.out.println("Enter Date of Start (YYYY-MM-DD):");
            String dosInput = scanner.nextLine();
            
    
            try 
            {
                LocalDate dos = LocalDate.parse(dosInput, DateTimeFormatter.ISO_LOCAL_DATE);
                System.out.println("Valid Date of Start: " + dos);
                return dos;
            } 
            catch (Exception e) 
            {
                System.out.println("Invalid date format! Please use YYYY-MM-DD.");
            }
        }
    }

    protected boolean DoesDatesMakeSense(LocalDate DOB, LocalDate DOS)
    {
        if(DOS.isAfter(DOB))
        {
            return true;
        }
        return false;
    }

    protected String EmailInput()
    {
        String email = "";
        while (true) 
        {
            System.out.print("Enter Email: ");
            email = scanner.nextLine().trim();
            if (email.matches("^[A-Za-z0-9+_.-çÇğĞıİöÖşŞüÜ]+@[A-Za-z0-9.-çÇğĞıİöÖşŞüÜ]+\\.[A-Za-z]{2,}$"))  
            // ^ start of string,[A-Za-z0-9+_.-] local part of email allows only upper or lowercase characters numbers or special chars +@ .- permits dots and hyphens $ is end of the string
            {
                return email;
            } 
            else 
            {
                System.out.println("Invalid email format! Please enter a valid email address.");
            }
        }
    }

    public boolean WannaReturn(Scanner input,boolean flag)
    {
        char PA = '0';
        input.nextLine();
        do
        {
            System.out.println("\nDo you want to return to the Main Menu?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Selection: ");
            String PAString = input.nextLine();
            if(PAString.isEmpty() || PAString.length() > 1)
            {
                Ccleaner();
                System.out.println("You entered an invalid input. Please enter a number between 1 or 2.");
                System.out.println();
                continue;
            }
            PA = PAString.charAt(0);
            if (PA < '1' || PA > '2') 
            {
                Ccleaner();
                System.out.println("You entered an invalid input. Please enter a number 1 or 2.");
                System.out.println();
        }
            if (PA == '1') 
            {
                Ccleaner();
                return true;
            }
            else if (PA == '2')
            {
                Ccleaner();
                return false;
            }
        } while (PA != '1' || PA != '2');
        return false;
    }

    public void UpdateInput()
    {
        System.out.println("Enter the username of the employee you would like to update");
        String tempUsername = UsernameInputToOperate();
        Employee tempEmployee = dbHandler.GetEmployeeWithUsername(tempUsername);
        System.out.println("After getting the employee");
        if(tempEmployee == null)
        {
            return;
        }


        String RMString;
        char RMInput = '0';
        while(RMInput != '8' )
        {
            System.out.println("Which field would you like to update?\n" +
            "1: Username\n" +
            "2: Role\n" +
            "3: Name\n" +
            "4: Surname\n" +
            "5: Date of Birth\n" +
            "6: Date of Start\n" +
            "7: Email\n" +
            "8: Exit");

            RMString = scanner.nextLine();
            
            if(RMString.isEmpty() || RMString.length() > 1)
            {
                Ccleaner();
                System.out.println("You entered an invalid input. Please enter a number between 1 and 9.");
                System.out.println();
                continue;
            }
            RMInput = RMString.charAt(0);
            System.out.println();

            if (RMInput < '1' || RMInput > '8') 
            {
                    Ccleaner();
                    System.out.println("You entered an invalid input. Please enter a number between 1 and 9.");
                    System.out.println();
                    continue;
            }
            InputHandler inputHandler = new InputHandler();

            dbHandler.UpdateEmployeeNPF(RMInput,tempEmployee,inputHandler);
            System.out.println("Shits working man");
            //i dont think i need this
            
                //default -> System.out.println("Invalid option. Please try again input handler.");
            
        }
        
    }

        
    
    
    static public void Ccleaner()
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
    

