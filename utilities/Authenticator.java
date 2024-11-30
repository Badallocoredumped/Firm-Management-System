package utilities;

import users.Employee;

public class Authenticator 
{
    DataBaseHandler dbHandler = new DataBaseHandler();

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
                System.out.println("No employee found with the username: " + username);
                return null; 

            }
        } 
        catch (Exception e) 
        {
            System.err.println("Something bad happened");

        }
        return null;
    }

    public void logout(Employee currUser)
    {
        if(currUser != null)
        {
            System.out.println("Logout successful for: " + currUser.getName());
            currUser = null;
        }
        else
        {
            System.err.println("Error logout");
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

