import java.util.Scanner;

import javax.management.relation.Role;

import java.sql.Date;

public class RegularEmployee extends Employee
{
    //deleted delay
    public static Scanner input = new Scanner(System.in);
    public RegularEmployee(int ID, String Username,String Role,String Name,String Surname,String Phone,Date DOB,Date DOS,String Email,String Password)
    {
        super(ID, Username,Role,Name,Surname,Phone,DOB,DOS,Email,Password);

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
                System.out.print("Logginng out");
                //Deleted delay
                Ccleaner();
                return;
            }

            default -> 
            {
                Ccleaner();
                System.out.println("Please enter a number between 1 and 3");
            }
        }
    }
    public void PrintProfile()
    {
        char cRM ='0';
        String sRM;
        boolean toRM = false;
        while (!toRM) 
        {
            System.out.println("Full profile information");
            System.out.println("Name: " + name);
            System.out.println("Surname: " + surname);
            System.out.println("Email:" + Email);
            System.out.println("Phone" + phone);
            System.out.println("ID: " + ID);
            System.out.println("Role: " + role);
            System.out.println("Birthday: " + DOB);
            System.out.println("Employment day: " + DOS);
            System.out.println("Username: " + username);
            System.out.println("Password: " + Password + "\n");
            System.out.println("Enter '9' to return to the menu.");
            sRM = input.nextLine();
            if(sRM.isEmpty() || sRM.length() > 1)
            {
                Ccleaner();
                System.out.println("Enter '9' to return to the menu.");
                continue;
            }
            cRM = sRM.charAt(0);
            if (cRM == '9') 
            {
                toRM =true;
                return;
            }
            else if (cRM != '9') 
            {
                System.out.println("Enter '9' to return to the menu.");
            }
        }
    }
    public void UpdateProfile()
    {
        String UPString;
        char UPInput = '0';
            
        while(UPInput != '5')
        {
            System.out.println("Update profile");
            System.out.println("1. Change email");
            System.out.println("2. Change password");
            System.out.println("3. Change phone number");
            System.out.println("4. Update all profile information");
            System.out.println("Return to main menu");
            System.out.println();
            System.out.print("Select an Operation: ");
            UPString = input.nextLine();

            // Checks single character inputs
            if(UPString.isEmpty() || UPString.length() > 1)
            {
                Ccleaner();
                System.out.println("You entered an invalid input. Please enter a number between 1 and 3.");
                System.out.println();
                continue;
            }
            UPInput = UPString.charAt(0);
            System.out.println();

            if (UPInput < '1' || UPInput > '5') 
            {
                    Ccleaner();
                    System.out.println("You entered an invalid input. Please enter a number between 1 and 3.");
                    System.out.println();
            }
        }

        // Executes selected operation
        switch (UPInput)
        {
            case '1'-> //Update Email
            {
                Ccleaner();
                ChangeEmail();
            }

            case '2'-> //Update Phone number
            {
                Ccleaner();
                ChangePhone();
            }
            
            case '3'-> //Update Password
            {
                Ccleaner();
                ChangePassword();
            }

            case '4'-> //Update Password
            {
                Ccleaner();
                UpdateAll();
            }

            case '5'-> //Return to Main menu
            {
                Ccleaner();
                return;
            }

            default -> 
            {
                Ccleaner();
                System.out.println("Please enter a number between 1 and 5");
            }
        }
    }
    public boolean CheckFirstLogin()
    {
        return true;
    } 

    public void ChangePassword()
    {
        System.out.println("Updating password");
        boolean Changed = false;
        String cPassword = getPassword();
        String nPassword;
        while (!Changed) 
        {
            System.out.println("Enter new password (minimum 8, maximum 16 characters): ");
            nPassword = input.nextLine();
            if (nPassword.equals(cPassword))
            {
                System.out.println("You can not use the same password!!");
                continue;
            }

            if (nPassword.length() < 8 || nPassword.length() > 16 || nPassword.isBlank() ) 
            {
                System.out.println("Password must have between 8 and 16 characters");
                continue;
            }

            setPassword(nPassword);
            System.out.println("The password has been changed succesfully");
            Changed = true;
        }
    }

    public void ChangeEmail()
    {
        System.out.println("Updating email");
        boolean Changed = false;
        String cEmail = getEmail();
        String nEmail;
        String EmailRegex = "^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        while (!Changed) 
        {
            System.out.println("Enter new email address: ");
            nEmail = input.nextLine();
            if (nEmail.equals(cEmail))
            {
                System.out.println("You can not use the same Email!!");
                continue;
            }

            if (!nEmail.matches(EmailRegex)) 
            {
                System.out.println("Invalide email format!! (Spacial characters are not allowed)");
                continue;
            }

            setEmail(EmailRegex);
            System.out.println("The Email has been changed succesfully");
            Changed = true;
        }
    }

    public void ChangePhone()
    {
        System.out.println("Updating phone number");
        boolean Changed = false;
        String cPhone = getPhone();
        String nPhone;
        while (!Changed) 
        {
            System.out.println("Enter new phone number (10 digits): ");
            nPhone = input.nextLine();
            if (nPhone.equals(cPhone))
            {
                System.out.println("You can not use the same phone number!!");
                continue;
            }

            if (nPhone.length() != 10 || nPhone.isBlank() ||  !nPhone.matches("\\d+")) 
            {
                System.out.println("Phone number must have 10 digits");
                continue;
            }

            setPhone(nPhone);
            System.out.println("The Phone number has been changed succesfully");
            Changed = true;
        }
    }

    public void UpdateAll()
    {
        ChangeEmail();
        ChangePassword();
        ChangePhone();
        System.out.println("The profile has been updated succesfully");
    }

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

