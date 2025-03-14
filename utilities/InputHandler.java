package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

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
     * The username must be between 4 and 15 characters, shouldn't have any spaces and match a specific pattern, shouldn't start with special characters
     * If the username is valid, it is returned. If it is not valid the user is prompted again.
     * @return A valid and unique username.
     */
    public String UsernameInput()
    {
        String UsernameRegex = "^[A-Za-z0-9çÇğĞıİöÖşŞüÜ+_.\\\\-][A-Za-z0-9çÇğĞıİöÖşŞüÜ_@#!$%^&*()+=.,/-]*$";
        String username;
        while (true) 
        {
            System.out.print(color.WHITE + "Enter a Username (Minimum 4 characters, Maximum 15 characters, No spaces): " + color.RESET);
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
            else if(username.length()>15)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username " + username + " is bigger than 15 characters!!" + color.RESET);
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
            else if (username.matches("^_+.*"))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username can not start with consecutive special characters!!" + color.RESET);
            }
            else if (!username.matches(UsernameRegex))  
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid username format!");
            }
            else if (countLetters(username) < 4) 
            { 
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Username must contain at least 4 letters!!" + color.RESET);
            }
            else
            {
                return username;
            }
        }
    }
    /**
     * Counts the number of alphabetic characters (letters) in a given username.
     * 
     * This method iterates over the string and counts how many letters are in it.
     * Non-letter characters are ignored
     * 
     * @param username
     * @return the number of alphabetic characters(letters) in the username
     */
    private int countLetters(String username) 
    {
        int count = 0;
        for (char c : username.toCharArray()) 
        {
            if (Character.isLetter(c)) 
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Same function as @see #validateUsername(String)
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

    
    //NOTE: The matches() method in Java checks if a string matches a given regular expression (regex)

    /**
     * Prompts the user to enter a valid name and validates it using a regular expression.
     * Name can consist of multiple words, containing only letters and single quotes
     * If the name is valid it is returned, if not then user is prompted again.
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
            else if(name.matches("^[A-Za-zÇçŞşİıĞğÖöÜü']+(\\s[A-Za-zÇçŞşİıĞğÖöÜü']+)*$")&& !name.contains("''") && !name.startsWith("'") && !name.endsWith("'"))
            {
                return name;
            } 
            else 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid name! Name should only contain letters or single quotes and cannot be blank!!"  + color.RESET);
            }
        }
    }

    /**
     * Prompts the user to enter a valid surname and validates it using a regular expression.
     * Surname can consist of a single word with single quote containing only letters.
     * If the surname is valid it is returned if not user is prompted again.
     * 
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
            else if(surname.matches("^[A-Za-zÇçŞşİıĞğÖöÜü']+$") && !surname.startsWith("'") && !surname.endsWith("'") && !surname.contains("''"))
            {
                return surname;
            } 
            else 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid surname! Surname should only contain letters or single quotes and cannot be blank!!"  + color.RESET);
            }
        }
    }
    
    /**
     * Prompts the user to enter a role and validates it against a predefined set of roles.
     * The valid roles are "manager", "engineer", "technician", and "intern".
     * If the role is valid, it is returned; otherwise, the user is prompted again.
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
                return validRoles.get(role); 
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
     * The phone number has to follow a strict pattern of "+1XXXXXXXXXX" where X is a digit.
     * If the phone number is valid it is returned if not the user is prompted again
     * @param tempPhone A temporary phone number to ensure the new phone is not the same.
     * @return A valid phone number.
     */
    public String PhoneInput(String tempPhone)
    {
        String phone = "";
        while (true) 
        {
            
            System.out.print(color.WHITE + "Enter Phone Number (+1XXXXXXXXXX): ");
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
            //Old Regex = "\\d+"
            if (phone.length() != 10 || phone.isBlank() ||  !phone.matches("^\\+\\d{1,4}\\d{10}$"))
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
     * Date of birth checks if the user is above 18 and is not born before 1920.
     * Also it checks if the new birthday is the same as the previosu birthday.
     * If the date of birth is valid it is returned if not the user is prompted again
     * 
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
     * New date of start can not be the same as the previous date of start.
     * If the date of start is valid it is returned if not user is prompted again
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
     * 
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
     * 
     * If the email is valid it is returned if not the user is prompted again.
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
            if (email.matches("^[A-Za-z0-9+_.\\-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))  
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
     * Validates the users input to make sure they choose either '1' for yes or '2' for no
     * 
     * @param input The Scanner object for user input.
     * @return True if the user chooses to return to the main menu, false otherwise.
     */
    public boolean WannaReturn(Scanner input)
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
     * Asks the user if they want to proceed with firing an employee.
     * Displays a warning message and validates the user's input to ensure they choose either '1' for yes or '2' for no.
     * @param input The Scanner object for user input.
     * @return True if the user chooses to return to the main menu, false otherwise.
     */
    public boolean WannaAbort(Scanner input)
    {
        char PA = '0';
        System.out.println(color.BRIGHT_RED + "You are about to fire an employee." + color.RESET);
        System.out.println(color.BRIGHT_RED + "There will be no more warnings" + color.RESET);
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
     * Ensures that the user cannot update their own information and verifies that the employee exists in the database.
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
            System.out.println(color.MAGENTA + "=============================================" + color.RESET);
            System.out.println(color.MAGENTA + "             *** Update Menu ***             " + color.RESET);
            System.out.println(color.MAGENTA + "=============================================" + color.RESET);
            System.out.println(color.BRIGHT_BLUE + "Which field would you like to update?" + color.RESET);
            System.out.println(color.MAGENTA + "----------------------------------------------" + color.RESET);
            System.out.println("1. Username\n" +
            "2. Role\n" +
            "3. Name\n" +
            "4. Surname\n" +
            "5. Date of Birth\n" +
            "6. Date of Start\n" +
            "7. Exit");
            System.out.println(color.MAGENTA + "----------------------------------------------" + color.RESET);
            System.out.print(color.BRIGHT_BLUE + "Select an Operation (1-7): ");

            RMString = scanner.nextLine();
            
            if(RMString.isEmpty() || RMString.length() > 1)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 7!!");
                System.out.println();
                continue;
            }
            RMInput = RMString.charAt(0);
            System.out.println();

            if (RMInput < '1' || RMInput > '7') 
            {
                    Ccleaner();
                    System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 7!!");
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
    

