package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import users.Employee;

/**
 * Handles user inputs and provides validation for various fields such as username, name, dates, etc.
 */
public class InputHandler 
{
    Scanner scanner = InputUtil.scanner;
    DataBaseHandler dbHandler = new DataBaseHandler();
    AsciiArt color = new AsciiArt();
    
    /**
     * Prompts the user to enter a username, validates it, and checks for duplicates.
     * @return A valid and unique username.
     */
    public String UsernameInput()
    {
        String UsernameRegex = "^[A-Za-z0-9çÇğĞıİöÖşŞüÜ+_.\\\\-][A-Za-z0-9çÇğĞıİöÖşŞüÜ_@#!$%^&*()+=.,/-]*$";
        String username;
        while (true) 
        {
            System.out.print(color.WHITE + "Enter a Username (Minimum 4 characters, No spaces): " + color.RESET);
            username = scanner.nextLine().trim();
            if(dbHandler.CheckDuplicate("username",username))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username " + username + " is already taken!!" + color.RESET);
            }
            else if(username.length()<4)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username " + username + " is smaller than 4 characters!!" + color.RESET);
            }
            else if(username.isBlank())
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username can not be blank!!" + color.RESET);
            }
            else if(username.contains(" "))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username can not have spaces!!" + color.RESET);
            }
            else if (!username.matches(UsernameRegex))  
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid username format!");
            }
            else
            {
                return username;
            }
        }
    }

    /**
     * Prompts the user to enter a username without checking for duplicates.
     * @return A valid username.
     */
    public String UsernameInputToOperate()
    {
        String UsernameRegex = "^[A-Za-z0-9+_.\\\\-çÇğĞıİöÖşŞüÜ][a-zA-Z0-9_@#!$%^&*()+=.,/-]*$";
        String username;
        while (true) 
        {
            System.out.print(color.WHITE + "Enter a Username (Minimum 4 characters, No spaces): ");
            username = scanner.nextLine().trim();
            
            if(username.length()<4)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username " + username + " is smaller than 4 characters!!"  + color.RESET);
            }
            else if(username.isBlank())
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username can not be blank!!"  + color.RESET);
            }
            else if (!username.matches(UsernameRegex))  
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid username format!");
            } 
            else 
            {
                return username;                
            }
        }
    }

    public String PasswordInput(String tempPassword)
    {
        String PasswordRegex = "^[a-zA-Z0-9_@#!$%^&*()+=.,/-]*$";
        String password = "";
        while (true) 
        {
            System.out.print(color.WHITE + "Enter a Password (Minimum 8 characters, No spaces): ");
            password = scanner.nextLine().trim();
            
            if(password.length() < 8 || password.length() > 16)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Password " + password + " is smaller than 8 or bigger than 16 characters!!"  + color.RESET);
            }
            else if(password.isBlank())
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username can not be blank!!"  + color.RESET);
            }
            else if(password.contains(" "))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username can not be contain blank spacess!!"  + color.RESET);
            }
            else if (!password.matches(PasswordRegex))  
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid username format!");
            } 
            else 
            {
                return password;                
            }
        }
    }
    
    //NOTE: The matches() method in Java checks if a string matches a given regular expression (regex)

    /**
     * Prompts the user to enter a valid name and validates it using a regular expression.
     * @param tempName A temporary name to ensure the new name is not the same.
     * @return A valid name.
     */
    public String NameInput(String tempName)
    {
        String name;
        while (true) 
        {
            System.out.print(color.WHITE + "Enter Name (Can be multiple words): "  + color.RESET);
            name = scanner.nextLine();
            if (!"".equals(tempName) && name.equals(tempName)) 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You can not use the same name!!"  + color.RESET);
                continue;
            }
            else if(name.matches("^[A-Za-zÇçŞşİıĞğÖöÜü]+(\\s[A-Za-zÇçŞşİıĞğÖöÜü]+)*$"))
            {
                return name;
            } 
            else 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid name! Name should only contain letters and cannot be blank!!"  + color.RESET);
            }
        }
    }

    /**
     * Prompts the user to enter a valid surname and validates it using a regular expression.
     * @param tempSurname A temporary surname to ensure the new surname is not the same.
     * @return A valid surname.
     */
    public String SurnameInput(String tempSurname)
    {
        String surname = "";
        while (true) 
        {
            System.out.print(color.WHITE + "Enter Surname (Single word): "  + color.RESET);
            surname = scanner.nextLine().trim();


            if (!"".equals(tempSurname) && surname.equals(tempSurname)) 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You can not use the same surname!!"  + color.RESET);
                continue;
            }
            else if(surname.matches("^[A-Za-zÇçŞşİıĞğÖöÜü]+$"))
            {
                return surname;
            } 
            else 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid surname! Surname should only contain letters and cannot be blank!!"  + color.RESET);
            }
        }
    }
    
    /**
     * Prompts the user to enter a role and validates it against a predefined set of roles.
     * @param tempRole A temporary role to ensure the new role is not the same.
     * @return A valid role.
     */
    public String RoleInput(String tempRole)
    {
        Map<String, String> validRoles = Map.of(
        "manager", "Manager",
        "engineer", "Engineer",
        "technician", "Technician",
        "intern", "Intern"
        );
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
            if(!"".equals(tempRole) && role.equals(tempRole.toLowerCase()))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You can not use the same role!!" + color.RESET);
                continue;

            } 
            else if(validRoles.containsKey(role))
            {
                Ccleaner();
                return role; 
            }
            else 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid role. Please enter one of the following: manager, engineer, technician, intern!!"  + color.RESET);
            }
        }
    }

    /**
     * Prompts the user to enter a phone number and validates its format and uniqueness.
     * @param tempPhone A temporary phone number to ensure the new phone is not the same.
     * @return A valid phone number.
     */
    public String PhoneInput(String tempPhone)
    {
        String phone = "";
        while (true) 
        {
            
            System.out.print(color.WHITE + "Enter Phone Number (123456789): ");
            phone = scanner.nextLine().trim();
            
            if(!"".equals(tempPhone) && dbHandler.CheckDuplicate("phone_no",phone))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Phone number " + phone + " already exists in the database!!"  + color.RESET);
                continue;
            }
            if(phone.equals(tempPhone))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You can not use the same phone number!!"  + color.RESET);
                continue;
            }
            if (phone.length() != 10 || phone.isBlank() ||  !phone.matches("\\d+")) //This checks if its maching the digits from 0 to 9, and atleast 1 time at most 15 times
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Phone number must have 10 digits!!"  + color.RESET);
                continue;
            }
            Ccleaner();
            return phone;
            
        }
    }

    /**
     * Prompts the user to enter a date of birth and validates it.
     * @param tempDOB A temporary date of birth to ensure the new DOB is not the same.
     * @return A valid date of birth.
     */
    public LocalDate DobInput(LocalDate tempDOB)
    {
        while(true)
        {
            
            System.out.println(color.WHITE + "Enter Date of Birth (YYYY-MM-DD):");
            String dobInput = scanner.nextLine();
            if(tempDOB != null && dobInput.equals(tempDOB.toString()))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You can not use the same birthday!!" + color.RESET);
                continue;
            }
    
            try 
            {
                LocalDate dob = LocalDate.parse(dobInput, DateTimeFormatter.ISO_LOCAL_DATE);
                if (dob.isAfter(LocalDate.now()))
                {
                    Ccleaner();
                    System.out.println(color.BRIGHT_RED + "Date of Birth cannot be in the future!!"  + color.RESET);
                    
                }

                else if (dob.isBefore(LocalDate.of(1920, 1, 1))) 
                {
                    Ccleaner();
                    System.out.println(color.BRIGHT_RED + "Year cannot be before 1920!!");
                }

                else if (dob.isAfter(LocalDate.now().minusYears(18))) 
                {
                    Ccleaner();
                    System.out.println(color.BRIGHT_RED + "You must be at least 18 years old!!");
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
                System.out.println(color.BRIGHT_RED + "Invalid date format! Please use YYYY-MM-DD!!");
            }

        }

    }

    /**
     * Prompts the user to enter a start date and validates it to ensure it is not in the future.
     * @param tempDOS A temporary date of start to ensure the new date is not the same.
     * @return A valid start date.
     */
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
                    System.out.println(color.BRIGHT_RED + "Start Date cannot be in the future!!");
                    
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
                System.out.println(color.BRIGHT_RED + "Invalid date format! Please use YYYY-MM-DD!!");
            }
        }
    }

    /**
     * Validates that the start date is after the date of birth.
     * @param DOB The date of birth.
     * @param DOS The date of start.
     * @return True if the start date is after the date of birth, false otherwise.
     */
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

    /**
     * Prompts the user to enter an email address and validates it for proper format and uniqueness.
     * @param tempEmail A temporary email to ensure the new email is not the same.
     * @return A valid email address.
     */
    public String EmailInput(String tempEmail)
    {
        String email = "";
        while (true) 
        {
            System.out.print(color.WHITE + "Enter Email (example@gmail.com, No special characters): ");
            email = scanner.nextLine().trim();

            if(!"".equals(tempEmail) && dbHandler.CheckDuplicate("email",email))
            {
                Ccleaner();
                System.out.println(color.WHITE + "Email " + email + " already exists in the database!!");
                continue;
            }
            if(email.equals(tempEmail))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You can not use the same Email!!");
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
                System.out.println(color.BRIGHT_RED + "Invalid email format! Please enter a valid email address!!");
            }
        }
    }

    /**
     * Asks the user if they want to return to the main menu.
     * @param input The Scanner object for user input.
     * @param flag A boolean flag (unused in the current method logic).
     * @return True if the user chooses to return to the main menu, false otherwise.
     */
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
                System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 or 2!!");
                System.out.println();
                continue;
            }
            PA = PAString.charAt(0);
            if (PA < '1' || PA > '2') 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number 1 or 2!!");
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

    /**
     * Handles updating employee information based on the user's input.
     * Displays a menu of fields to update and processes the user's selection.
     */
    public void UpdateInput(String username)
    {
        System.out.println(color.WHITE + "Enter the username of the employee you would like to update");
        String tempUsername = UsernameInputToOperate();
        Ccleaner();
        if(tempUsername.equals(username))
        {
            System.out.println(color.BRIGHT_RED + "You can not update your own information!!");
            System.out.println(color.WHITE + "Enter anything to return");
            scanner.nextLine();
            Ccleaner();
            return;
        }
        Employee tempEmployee = dbHandler.GetEmployeeWithUsername(tempUsername);
        if(tempEmployee == null)
        {
            System.out.println(color.WHITE + "Enter anything to return");
            scanner.nextLine();
            Ccleaner();
            return;
        }


        String RMString;
        char RMInput = '0';
        while(RMInput != '7' )
        {

            System.out.println(color.MAGENTA + "Which field would you like to update?\n" +
            "1: Username\n" +
            "2: Role\n" +
            "3: Name\n" +
            "4: Surname\n" +
            "5: Date of Birth\n" +
            "6: Date of Start\n" +
            "7: Exit");

            RMString = scanner.nextLine();
            
            if(RMString.isEmpty() || RMString.length() > 1)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 9!!");
                System.out.println();
                continue;
            }
            RMInput = RMString.charAt(0);
            System.out.println();

            if (RMInput < '1' || RMInput > '7') 
            {
                    Ccleaner();
                    System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 9!!");
                    System.out.println();
                    continue;
            }
            InputHandler inputHandler = new InputHandler();
            dbHandler.UpdateEmployeeNPF(RMInput,tempEmployee,inputHandler);
            if(RMInput != '7')
            {
                System.out.println(color.WHITE + "Enter anything to return");
                scanner.nextLine();
                Ccleaner();
            }

        }
        Ccleaner();
        
    }

        
    
    /**
     * Clears the console screen.
     * 
     * This method attempts to clear the console by running a system command. 
     * If an error occurs during the process, an error message is printed.
     * 
     *
     */
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
    

