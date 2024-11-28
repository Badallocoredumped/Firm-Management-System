import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Firm Management System!");
        DataBaseHandler dbHandler = new DataBaseHandler();

        // Display all employees
        System.out.println("Displaying All Employees:");
        dbHandler.DispAllEmployee();
        System.out.println("Displayed All Employees");
        //dbHandler.DispEmployeeWithRole("manager");
        System.out.println("Displayed All Employees with the role");
        //dbHandler.DispEmployeeWithUsername("emir5757");
        //dbHandler.DispEmployeeWithNameSurname("Emir","Özen");
        dbHandler.HireEmployee("dummyvolkan", "Volkan", "Erdoğan", "intern", "0523432", "2022-11-01", "2022-12-2", "bozoman");
        //dbHandler.FireEmployee(22,"dummyvolkan");

        Scanner scanner = new Scanner(System.in);
        Authenticator authenticator = new Authenticator();
        Employee currUser = null;


        /*  
         * Need to add correct input checker
         * Need to use the if there is duplicate function
         * Need to fill out the manager class
         * Need to finalize main class
         * Need to make hire and fire private ? i guess idk
         * Need to do the first login thing which we have a boolean inside the database
         * Check the date thing Date to string string to date
         * Make email unique and the phone number probably
        */

        while(currUser == null)
        {
            System.out.println("Username: ");
            String userName = scanner.nextLine();
            try{

                System.out.print("Password: ");
                String password = scanner.nextLine().trim();

                currUser = authenticator.login(userName, password);

                if (currUser == null) {
                    System.out.println("Login failed. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("An error occurred during login. Please try again.");
            }
        }

        // Post-login actions
        if (currUser instanceof Manager) {
            System.out.println("Logged in as Manager.");
            // Manager-specific actions can go here
        } else if (currUser instanceof RegularEmployee) {
            System.out.println("Logged in as Regular Employee.");
            // Regular employee-specific actions can go here
        }

        authenticator.logout();
        System.out.println("You have been logged out. Goodbye!");

        // Close resources
        scanner.close();
    }
}
