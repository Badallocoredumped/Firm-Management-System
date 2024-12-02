package utilities;

import users.Employee;



/**
 * The Authenticator class handles authentication tasks in the Firm Management System.
 * 
 * This includes user login and logout functionality, as well as password update prompts
 * for first-time logins. It interacts with the database to validate user credentials.
 */
public class Authenticator 
{
    DataBaseHandler dbHandler = new DataBaseHandler();
    AsciiArt color = new AsciiArt();

    /**
     * Authenticates a user by their username and password.
     * 
     * This method checks the provided credentials against the database. If a match is found,
     * the corresponding Employee object is returned. If the user is logging in for the first time
     * (using a default password), they are prompted to change their password.
     * 
     * @param username The username provided by the user.
     * @param password The password provided by the user.
     * @return An Employee object if authentication is successful, or null if authentication fails.
     */
    public Employee login(String username, String password)
    {
        try 
        {
            Employee newEmployee = dbHandler.GetEmployeeWithUsernameAndPassword(username,password);

            if(newEmployee != null)
            {
                Ccleaner();
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
            System.err.println(color.BRIGHT_RED + "Something bad happened!!" + color.RESET);

        }
        return null;
    }

    /**
     * Logs out the current user from the system.
     * 
     * This method nullifies the current user object and prints a logout confirmation message.
     * If no user is logged in, an error message is displayed.
     * 
     * @param currUser The Employee object representing the currently logged-in user.
     */
    public void logout(Employee currUser)
    {
        if(currUser != null)
        {
            System.out.println(color.RED + "Logout successful for: " + currUser.getName() + color.RESET);
            currUser = null;
        }
        else
        {
            System.err.println(color.BRIGHT_RED + "Error logout!!" + color.RESET);
        }
    }

    /**
     * Clears the console screen.
     * 
     * This method attempts to clear the console by running a system command. 
     * If an error occurs during the process, an error message is printed.
     * 
     *
     */
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

