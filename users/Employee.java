package users;
import java.time.LocalDate;
import java.util.Scanner;

import utilities.AsciiArt;
import utilities.DataBaseHandler;
import utilities.InputUtil;


/**
 * The Employee class serves as an abstract base for all employee types in the Firm Management System.
 * 
 * This class defines common properties, behaviors, and operations that all employees share.
 * Specific employee roles, such as Manager, will extend this class and implement its abstract methods.
 */
public abstract class Employee 
{
    protected int ID;
    protected String Username;
    protected String role;
    protected String name;
    protected String surname;
    protected String phone;
    protected LocalDate DOB;
    protected LocalDate DOS;
    protected String Email;
    protected String Password;
    protected Boolean DEFAULT_PASSWORD;

    public static Scanner input = InputUtil.scanner;
    static DataBaseHandler dbHandler = new DataBaseHandler();
    AsciiArt color = new AsciiArt();


    /**
     * Constructs a new Employee object.
     * 
     * @param ID Unique identifier for the employee.
     * @param Username Username for employee login.
     * @param Role Role of the employee in the organization.
     * @param Name First name of the employee.
     * @param Surname Last name of the employee.
     * @param Phone Phone number of the employee.
     * @param DOB Date of birth of the employee.
     * @param DOS Employment start date.
     * @param Email Email address of the employee.
     * @param Password Password for employee login.
     * @param DEFAULT_PASSWORD Indicates if the password is the default value.
     */
    public Employee(int ID, String Username,String Role,String Name,String Surname,String Phone,LocalDate DOB,LocalDate DOS,String Email,String Password, Boolean DEFAULT_PASSWORD)
    {
        this.ID = ID;
        this.Username = Username;
        this.role = Role;
        this.name = Name;
        this.surname = Surname;
        this.phone = Phone;
        this.DOB = DOB;
        this.DOS = DOS;
        this.Email = Email;
        this.Password = Password;
        this.DEFAULT_PASSWORD = DEFAULT_PASSWORD;

    }

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getUsername() {return Username;}
    public String getRole() {return role;}
    public int getID() {return ID;}
    public LocalDate getBirthday() {return DOB;}
    public LocalDate getEmploymentday() {return DOS;}
    public String getPhone() {return phone;}
    public void setUsername(String Username) {this.Username = Username;}
    public void setRole(String roletochange) {this.role = roletochange;}
    public void setPhone(String phone) { this.phone = phone;}
    public String getEmail() {return Email;}
    public void setEmail(String email) { this.Email = email;}
    public String getPassword() {return Password;}
    public void setPassword(String Password) { this.Password = Password;}
    public void setName(String nametochange) {this.name = nametochange;}
    public void setSurname(String surnametochange) {this.surname = surnametochange;}
    public void setBirthday(LocalDate birthdaytochange){this.DOB = birthdaytochange;}
    public void setEmploymentDay(LocalDate employmentdatetochange){this.DOS = employmentdatetochange;}
    public Boolean getDEFAULT_PASSWORD() {return DEFAULT_PASSWORD;}
    
    /**
     * Abstract method to display the menu for specific employee roles.
     * Subclasses must implement this method to define role-specific menu operations.
     */
    public abstract void Menu();

    /**
     * Prompts the employee to change their password.
     * Enforces rules such as no spaces and a length between 8 and 16 characters.
     */
    public void ChangePassword()
    {
        System.out.println(color.MAGENTA + "Updating password" + color.RESET);
        String PasswordRegex = "[a-zA-Z0-9_@#!$%^&*()+=.,/-?]*$"; //- is not accepted in password
        boolean Changed = false;
        String cPassword = getPassword();
        String nPassword;
        while (!Changed) 
        {
            System.out.println(color.WHITE + "Enter new password (minimum 8, maximum 16 characters): " + color.RESET);
            nPassword = input.nextLine().trim();
            if (nPassword.equals(cPassword))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You can not use the same password!!"  + color.RESET);
                continue;
            }

            if (nPassword.length() < 8 || nPassword.length() > 16 || nPassword.isBlank() || nPassword.contains(" ")) 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Password must have between 8 and 16 characters and should have any space!!" + color.RESET);
                continue;
            }

            if (!nPassword.matches(PasswordRegex)) 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalide password format!!" + color.RESET);
                continue;
            }

            dbHandler.UpdatePassword(ID, nPassword);
            setPassword(nPassword);
            Changed = true;
        }
    }

    /**
     * Prompts the employee to update their email address.
     * Ensures valid formatting and checks for duplicates in the database.
     */
    public void ChangeEmail()
    {
        System.out.println(color.MAGENTA + "Updating email" + color.RESET);
        boolean Changed = false;
        String cEmail = getEmail();
        String nEmail;
        String EmailRegex = "^[A-Za-z0-9+_.çÇğĞıİöÖşŞüÜ-]+@[A-Za-z0-9.çÇğĞıİöÖşŞüÜ-]+\\.[A-Za-z]{2,}$";
        while (!Changed) 
        {
            System.out.println(color.WHITE + "Enter new email address (example@gmail.com, No special characters): ");
            nEmail = input.nextLine();
            if (nEmail.equals(cEmail))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You can not use the same Email!!" + color.RESET);
                continue;
            }
            else if(dbHandler.CheckDuplicate("email",nEmail))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Email " + nEmail + " already exists in the database!!"  + color.RESET);
                continue;
            }

            if (!nEmail.matches(EmailRegex)) 
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalide email format!! (Special characters are not allowed)" + color.RESET);
                continue;
            }

            dbHandler.UpdateEmail(ID, nEmail);
            setEmail(nEmail);
            Changed = true;
        }
    }

    /**
     * Prompts the employee to update their phone number.
     * Ensures the phone number is unique, has 10 digits, and is numeric.
     */
    public void ChangePhone()
    {
        System.out.println(color.MAGENTA + "Updating phone number" + color.RESET);
        boolean Changed = false;
        String cPhone = getPhone();
        String nPhone;
        while (!Changed) 
        {
            System.out.println(color.WHITE + "Enter new phone number (+1XXXXXXXXXX): " + color.RESET);
            nPhone = input.nextLine();
            if (nPhone.equals(cPhone))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You can not use the same phone number!!" + color.RESET);
                continue;
            }
            else if(dbHandler.CheckDuplicate("phone_no",nPhone))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Phone number " + nPhone + " already exists in the database!!" + color.RESET);
                continue;
            }

            if (nPhone.isBlank() ||  !nPhone.matches("^\\+\\d{1,4}\\d{10}$"))
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Invalid phone number format!"  + color.RESET);
                continue;
            }

            dbHandler.UpdatePhone(ID, nPhone);
            setPhone(nPhone);
            Changed = true;
        }
    }

    /**
     * Updates all profile fields: email, phone, and password.
     */
    public void UpdateAll()
    {
        ChangeEmail();
        ChangePhone();
        ChangePassword();
        System.out.println(color.BRIGHT_GREEN + "The profile has been updated succesfully!!"  + color.RESET);
        //Maybe add and option to exit directly or enter blanks to not change the a section(add a note to it too)
    }

    /**
     * Displays a menu for updating specific profile fields or all fields.
     */
    public void UpdateProfile()
    {
        String UPString;
        char UPInput = '0';
            
        while(UPInput != '5')
        {
            System.out.println(color.MAGENTA + "===============================================" + color.RESET);
            System.out.println(color.MAGENTA + "            *** Update profile ***             " + color.RESET);
            System.out.println(color.MAGENTA + "===============================================" + color.RESET);
            System.out.println(color.WHITE + "1. Change email" + color.RESET);
            System.out.println(color.WHITE + "2. Change phone number" + color.RESET);
            System.out.println(color.WHITE + "3. Change password" + color.RESET);
            System.out.println(color.WHITE + "4. Update all profile information" + color.RESET);
            System.out.println(color.WHITE + "5. Return to main menu" + color.RESET);
            System.out.println(color.MAGENTA + "-----------------------------------------------" + color.RESET);
            System.out.print(color.BRIGHT_BLUE + "Select an Operation: " + color.RESET);
            UPString = input.nextLine();

            // Checks single character inputs
            if(UPString.isEmpty() || UPString.length() > 1)
            {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 3!!" + color.RESET);
                System.out.println();
                continue;
            }
            UPInput = UPString.charAt(0);
            System.out.println();

            if (UPInput < '1' || UPInput > '5') 
            {
                    Ccleaner();
                    System.out.println(color.BRIGHT_RED + "You entered an invalid input. Please enter a number between 1 and 3!!" + color.RESET);
                    System.out.println();
            }
        

            // Executes selected operation
            switch (UPInput)
            {
                case '1'-> //Update Email
                {
                    Ccleaner();
                    ChangeEmail();
                    System.out.println(color.WHITE + "Enter anything to return");
                    input.nextLine();
                    Ccleaner();
                }

                case '2'-> //Update Phone number
                {
                    Ccleaner();
                    ChangePhone();
                    System.out.println(color.WHITE + "Enter anything to return");
                    input.nextLine();
                    Ccleaner();
                }
                
                case '3'-> //Update Password
                {
                    Ccleaner();
                    ChangePassword();
                    System.out.println(color.WHITE + "Enter anything to return");
                    input.nextLine();
                    Ccleaner();
                }

                case '4'-> //Update All
                {
                    Ccleaner();
                    UpdateAll();
                    System.out.println(color.WHITE + "Enter anything to return");
                    input.nextLine();
                    Ccleaner();
                }

                case '5'-> //Return to Main menu
                {
                    Ccleaner();
                    return;
                }

                
            }
        }
    }

    /**
     * Displays the complete profile of the employee.
     */
    public void PrintProfile()
    {
            Ccleaner();
            System.out.println(color.MAGENTA + "Full profile information"  + color.RESET);
            System.out.println(color.MAGENTA + "----------------------------------------" + color.RESET);
            System.out.println(color.WHITE + "Name: " + name);
            System.out.println(color.WHITE +"Surname: " + surname);
            System.out.println(color.WHITE +"Email: " + Email);
            System.out.println(color.WHITE +"Phone: " + phone);
            System.out.println(color.WHITE +"ID: " + ID);
            System.out.println(color.WHITE +"Role: " + role);
            System.out.println(color.WHITE +"Birthday: " + DOB);
            System.out.println(color.WHITE +"Employment day: " + DOS);
            System.out.println(color.WHITE +"Username: " + Username);
            System.out.println(color.WHITE +"Password: " + Password + "\n" + color.RESET);
            System.out.println(color.MAGENTA + "----------------------------------------" + color.RESET);

    
    }

    /**
     * Clears the console screen.
     * 
     * This method attempts to clear the console by running a system command. 
     * If an error occurs during the process, an error message is printed.
     * 
     *
     */
    public void Ccleaner()
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
