package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;
import utilities.AsciiArt;

import users.Employee;

public class InputHandler 
{
    Scanner scanner = new Scanner(System.in);
    DataBaseHandler dbHandler = new DataBaseHandler();
    AsciiArt color = new AsciiArt();

    public String UsernameInput()
    {
        String username;
        while (true) 
        {
            System.out.print(color.WHITE + "Enter a Username (Minimum 4 characters): ");
            username = scanner.nextLine().trim();
            if(dbHandler.CheckDuplicate("username",username))
            {
                Ccleaner();
                System.out.println(color.WHITE + "Username " + username + " is already taken!");
            }
            else if(username.length()<4)
            {
                Ccleaner();
                System.out.println(color.WHITE + "Username " + username + " is smaller than 4 characters!");
            }
            else if(username.isBlank())
            {
                Ccleaner();
                System.out.println(color.WHITE + "Username can not be blank!");
            }
            else if(username.contains(" "))
            {
                Ccleaner();
                System.out.println(color.WHITE + "Username can not have spaces!");
            }
            else
            {
                return username;
            }
        }
    }
    public String UsernameInputToOperate()
    {
        String username;
        while (true) 
        {
            System.out.print(color.WHITE + "Enter a Username (Minimum 4 characters): ");
            username = scanner.nextLine().trim();
            
            if(username.length()<4)
            {
                Ccleaner();
                System.out.println(color.WHITE + "Username " + username + " is smaller than 4 characters!");
            }
            else if(username.isBlank())
            {
                Ccleaner();
                System.out.println(color.WHITE + "Username can not be blank!");
            }
            else
            {
                return username;
            }
        }
    }
    
    //NOTE: The matches() method in Java checks if a string matches a given regular expression (regex)

    public String NameInput(String tempName)
    {
        String name;
        while (true) 
        {
            System.out.print(color.WHITE + "Enter Name: ");
            name = scanner.nextLine();
            if (tempName != "" && name.equals(tempName)) 
            {
                Ccleaner();
                System.out.println(color.WHITE + "You can not use the same name!!");
                continue;
            }
            else if(name.matches("^[A-Za-zÇçŞşİıĞğÖöÜü]+(\\s[A-Za-zÇçŞşİıĞğÖöÜü]+)*$"))
            {
                return name;
            } 
            else 
            {
                Ccleaner();
                System.out.println(color.WHITE + "Invalid name! Name should only contain letters and cannot be blank.");
            }
        }
    }
    public String SurnameInput(String tempSurname)
    {
        String surname = "";
        while (true) 
        {
            System.out.print(color.WHITE + "Enter Surname: ");
            surname = scanner.nextLine().trim();


            if (tempSurname != "" && surname.equals(tempSurname)) 
            {
                Ccleaner();
                System.out.println(color.WHITE + "You can not use the same surname!!");
                continue;
            }
            else if(surname.matches("^[A-Za-zÇçŞşİıĞğÖöÜü]+$"))
            {
                return surname;
            } 
            else 
            {
                Ccleaner();
                System.out.println(color.WHITE + "Invalid surname! Surname should only contain letters and cannot be blank.");
            }
        }
    }
    
    public String RoleInput(String tempRole)
    {
        Set<String> validRoles = Set.of("manager", "engineer", "technician", "intern"); //Simple hashset
        String role;
        while (true) 
        {
            System.out.print(color.WHITE + "Enter Role (manager, engineer, technician, intern): ");
            role = scanner.nextLine().trim().toLowerCase();

            //Enable this to enable depromotion of other managers
            /* if (tempRole.toLowerCase().equals("manager")) 
            {
                Ccleaner();
                System.out.println("You can not change the role of a manager!!");
            } */
            if(tempRole != "" && role.equals(tempRole.toLowerCase()))
            {
                Ccleaner();
                System.out.println(color.WHITE + "You can not use the same role!!");
                continue;

            } 
            else if(validRoles.contains(role))
            {
                Ccleaner();
                return role; 
            }
            else 
            {
                Ccleaner();
                System.out.println(color.WHITE + "Invalid role. Please enter one of the following: manager, engineer, technician, intern.");
            }
        }
    }

    public String PhoneInput(String tempPhone)
    {
        String phone = "";
        while (true) 
        {
            
            System.out.print(color.WHITE + "Enter Phone Number: ");
            phone = scanner.nextLine().trim();
            
            if(tempPhone != "" && dbHandler.CheckDuplicate("phone_no",phone))
            {
                Ccleaner();
                System.out.println(color.WHITE + "Phone number " + phone + " already exists in the database!");
                continue;
            }
            if(phone.equals(tempPhone))
            {
                Ccleaner();
                System.out.println(color.WHITE + "You can not use the same phone number!!");
                continue;
            }
            if (phone.length() != 10 || phone.isBlank() ||  !phone.matches("\\d+")) //This checks if its maching the digits from 0 to 9, and atleast 1 time at most 15 times
            {
                Ccleaner();
                System.out.println(color.WHITE + "Phone number must have 10 digits");
                continue;
            }
            Ccleaner();
            return phone;
            
        }
    }

    public LocalDate DobInput(LocalDate tempDOB)
    {
        while(true)
        {
            
            System.out.println(color.WHITE + "Enter Date of Birth (YYYY-MM-DD):");
            String dobInput = scanner.nextLine();
            if(tempDOB != null && dobInput.equals(tempDOB.toString()))
            {
                Ccleaner();
                System.out.println(color.WHITE + "You can not use the same birthday!!");
                continue;
            }
    
            try 
            {
                LocalDate dob = LocalDate.parse(dobInput, DateTimeFormatter.ISO_LOCAL_DATE);
                if (dob.isAfter(LocalDate.now()))
                {
                    Ccleaner();
                    System.out.println(color.WHITE + "Date of Birth cannot be in the future.");
                    
                }
                else
                {
                    Ccleaner();
                    return dob;
                }

            }
            catch (Exception e) 
            {
                Ccleaner();
                System.out.println(color.WHITE + "Invalid date format! Please use YYYY-MM-DD.");
            }

        }

    }

    public LocalDate DosInput(LocalDate tempDOS)
    {
        while(true)
        {
            
            System.out.println(color.WHITE + "Enter Date of Start (YYYY-MM-DD):");
            String dosInput = scanner.nextLine();
            if(tempDOS != null && dosInput.equals(tempDOS.toString()))
            {
                Ccleaner();
                System.out.println(color.WHITE + "You can not use the same date of start!!");
                continue;
            }
            
    
            try 
            {
                LocalDate dos = LocalDate.parse(dosInput, DateTimeFormatter.ISO_LOCAL_DATE);
                if (dos.isAfter(LocalDate.now()))
                {
                    Ccleaner();
                    System.out.println(color.WHITE + "Date of Birth cannot be in the future.");
                    
                }
                else
                {
                    Ccleaner();
                    return dos;
                }
            }
            catch (Exception e) 
            {
                Ccleaner();
                System.out.println(color.WHITE + "Invalid date format! Please use YYYY-MM-DD.");
            }
        }
    }

    public boolean DoesDatesMakeSense(LocalDate DOB, LocalDate DOS)
    {
        if(DOS.isAfter(DOB))
        {
            Ccleaner();
            return true;
        }
        Ccleaner();
        return false;
    }

    public String EmailInput(String tempEmail)
    {
        String email = "";
        while (true) 
        {
            System.out.print(color.WHITE + "Enter Email: ");
            email = scanner.nextLine().trim();

            if(tempEmail != "" && dbHandler.CheckDuplicate("email",email))
            {
                Ccleaner();
                System.out.println(color.WHITE + "Email " + email + " already exists in the database!");
                continue;
            }
            if(email.equals(tempEmail))
            {
                Ccleaner();
                System.out.println(color.WHITE + "You can not use the same Email!!");
                continue;
            }
            if (email.matches("^[A-Za-z0-9+_.\\-çÇğĞıİöÖşŞüÜ]+@[A-Za-z0-9.-çÇğĞıİöÖşŞüÜ]+\\.[A-Za-z]{2,}$"))  
            // ^ start of string,[A-Za-z0-9+_.-] local part of email allows only upper or lowercase characters numbers or special chars +@ .- permits dots and hyphens $ is end of the string
            {
                return email;
            } 
            else 
            {
                Ccleaner();
                System.out.println(color.WHITE + "Invalid email format! Please enter a valid email address.");
            }
        }
    }

    public boolean WannaReturn(Scanner input,boolean flag)
    {
        char PA = '0';
        input.nextLine();
        do
        {
            System.out.println(color.WHITE + "\nDo you want to return to the Main Menu?");
            System.out.println(color.WHITE + "1. Yes");
            System.out.println(color.WHITE + "2. No");
            System.out.print(color.WHITE + "Selection: ");
            String PAString = input.nextLine();
            if(PAString.isEmpty() || PAString.length() > 1)
            {
                Ccleaner();
                System.out.println(color.WHITE + "You entered an invalid input. Please enter a number between 1 or 2.");
                System.out.println();
                continue;
            }
            PA = PAString.charAt(0);
            if (PA < '1' || PA > '2') 
            {
                Ccleaner();
                System.out.println(color.WHITE + "You entered an invalid input. Please enter a number 1 or 2.");
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
        System.out.println(color.WHITE + "Enter the username of the employee you would like to update");
        String tempUsername = UsernameInputToOperate();
        Ccleaner();
        Employee tempEmployee = dbHandler.GetEmployeeWithUsername(tempUsername);
        if(tempEmployee == null)
        {
            Ccleaner();
            return;
        }


        String RMString;
        char RMInput = '0';
        while(RMInput != '8' )
        {

            System.out.println(color.WHITE + "Which field would you like to update?\n" +
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
                System.out.println(color.WHITE + "You entered an invalid input. Please enter a number between 1 and 9.");
                System.out.println();
                continue;
            }
            RMInput = RMString.charAt(0);
            System.out.println();

            if (RMInput < '1' || RMInput > '8') 
            {
                    Ccleaner();
                    System.out.println(color.WHITE + "You entered an invalid input. Please enter a number between 1 and 9.");
                    System.out.println();
                    continue;
            }
            InputHandler inputHandler = new InputHandler();
            dbHandler.UpdateEmployeeNPF(RMInput,tempEmployee,inputHandler);
            if(RMInput != '8')
            {
                System.out.println(color.WHITE + "Enter anything to return");
                scanner.nextLine();
                Ccleaner();
            }

        }
        Ccleaner();
        
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
    

