import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Firm Management System!");
        DataBaseHandler dbHandler = new DataBaseHandler();

        // Display all employees
        System.out.println("Displaying All Employees:");
        dbHandler.DispAllEmployee();
        System.out.println("-------------------------------------");

        // Example usage: Uncomment lines to test individual functionalities
        // dbHandler.DispEmployeeWithRole("manager");
        // dbHandler.DispEmployeeWithUsername("emir5757");
        // dbHandler.DispEmployeeWithNameSurname("Emir", "Özen");
        // dbHandler.HireEmployee("dummyvolkan", "Volkan", "Erdoğan", "intern", "0523432", "2022-11-01", "2022-12-02", "bozoman");
        // dbHandler.FireEmployee(22, "dummyvolkan");

        Scanner scanner = new Scanner(System.in);
        Authenticator authenticator = new Authenticator();
        Employee currUser = null;

        System.out.println("Login to the system:");

        // Login Process
        while (currUser == null) {
            try {
                System.out.print("Username: ");
                String username = scanner.nextLine().trim();

                System.out.print("Password: ");
                String password = scanner.nextLine().trim();

                currUser = authenticator.login(username, password);

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

        // Logout
        authenticator.logout();
        System.out.println("You have been logged out. Goodbye!");

        // Close resources
        scanner.close();
    }
}
