package utilities;

import users.Employee;

public class Authenticator 
{
    DataBaseHandler dbHandler = new DataBaseHandler();
    AsciiArt color = new AsciiArt();

    public Employee login(String username, String password)
    {
        try 
        {
            Employee newEmployee = dbHandler.GetEmployeeWithUsernameAndPassword(username,password);

            if(newEmployee != null)
            {
                Ccleaner();
                /* if(newEmployee.getPassword().equals(password))
                {
                    Ccleaner();
                    return newEmployee;
                }
                else
                {
                    System.out.println("Invalid password. Please try again.");
                    return null; 

                } */

                if (newEmployee.getDEFAULT_PASSWORD()) 
                {   
                    newEmployee.ChangePassword();
                }

                return newEmployee;
            }
            else
            {
                System.out.println(color.BRIGHT_RED + "No employee found with the username: " + username + color.RESET);
                return null; 

            }
        } 
        catch (Exception e) 
        {
            System.err.println(color.BRIGHT_RED + "Something bad happened" + color.RESET);

        }
        return null;
    }

    public void logout(Employee currUser)
    {
        if(currUser != null)
        {
            System.out.println(color.RED + "Logout successful for: " + currUser.getName() + color.RESET);
            currUser = null;
        }
        else
        {
            System.err.println(color.BRIGHT_RED + "Error logout" + color.RESET);
        }
    }

    static  void Ccleaner()
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

