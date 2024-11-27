import java.util.Scanner;

import javax.management.relation.Role;

import java.sql.Date;

public class RegularEmployee extends User
{
    static int delay = 1000;
    public static Scanner input = new Scanner(System.in);
    public RegularEmployee(String name, String surname, String username, String role, String email, String phone, String ID, String password, Date birthday, Date employmentday)
    {
        super(name, surname, username, role, email, phone, ID, password, birthday, employmentday);

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
                //Working on it!!!!;
            }
            
            case '3'-> //Logout
            // PS: Should we terminate the program or go to the login page?
            {
                Ccleaner();
                System.out.print("Logginng out");
                try 
                    {
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(delay);
                            System.out.println(".");
                            Thread.sleep(delay);
                            System.out.println(".");
                            Thread.sleep(delay);
                            System.out.println(".");
                        }
                    } 
                    catch (InterruptedException e) 
                    {
                    
                    }
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
            System.out.println("Profile information");
            System.out.println("Name: " + name);
            System.out.println("Surname: " + surname);
            System.out.println("Email:" + email);
            System.out.println("Phone" + phone);
            System.out.println("ID: " + ID);
            System.out.println("Role: " + role);
            System.out.println("Birthday: " + birthday);
            System.out.println("Employment day: " + employmentday);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password + "\n");
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
    public static void UpdateProfile()
    {

    }
    public static boolean CheckFirstLogin()
    {
        return true;
    } 

    public static void ChangePassword(RegularEmployee employee, Scanner input)
    {
        boolean SameCode = false;
        boolean Changed = false;
        while (!Changed) 
        {
            while (!SameCode) 
            {
                String cPassword = employee.getPassword();
                System.out.println("Enter new password (minimum 8, maximum 24 characters): ");
                String nPassword = input.nextLine();
                if (cPassword == nPassword)
                {
                    System.out.println("You can not use the same password!!");
                    return;
                }
                SameCode = true;
            }
            //if (nPassword.length() < 8 ) {
                
            //}
        }
        

    }

    public static void ChangeEmail()
    {

    }

    public static void ChangePhone()
    {

    }

    public static void Ccleaner()
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

