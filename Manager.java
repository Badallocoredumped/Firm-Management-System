import java.util.Scanner;
import java.sql.Date;

public class Manager extends Employee {
    DataBaseHandler dbHandler = new DataBaseHandler();
    protected int ID;
    protected String username;
    protected String role;
    protected String name;
    protected String surname;
    protected String phone;
    protected Date DOB;
    protected Date DOS;
    protected String email;
    protected String password;

    // Color constants for printing in different colors
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";

    // Constructor for the Manager class
    public Manager(int ID, String Username, String Role, String Name, String Surname, String Phone, Date DOB, Date DOS, String Email, String Password, Boolean DEFAULT_PASSWORD) {
        super(ID, Username, Role, Name, Surname, Phone, DOB, DOS, Email, Password, DEFAULT_PASSWORD);
    }

    // Method to print ASCII art for "Welcome Manager"
    public static void printWelcomeManager() {
        System.out.println(RED + "         MMMMMMMM         MMMMMMMM        AAAAAAAA         N::::::N::   N::::::N        AAAAAAAAA                GGGGGGGGGGGGG     EEEEEEEEEEEEEEEEEE   RRRRRRRRRRR" + Reset);
            System.out.println(RED + "     M:::::::M       M:::::::M       A::::::::A        N::::::N::   N::::::N       A:::::::::A            G::::::::::::::::G   E::::::::::::::::E   R::::::::::::R" + Reset);
            System.out.println(YELLOW + "  M::::::::M     M::::::::M      A:::::::::::A      N::::::N:::  N::::::N      A::::::::::::A         G:::::::::::::::::G   E::::::::::::::::E   R:::::RRRR::::R" + Reset);
            System.out.println(YELLOW + "  M:::::::::M    M::::::::M     A:::::AAAAA:::A     N::::::N:::  N::::::N     A:::::AAAAA::::A       G:::::::GGGGGGGGG      E::::::E             R:::::R   R::::R" + Reset);
            System.out.println(GREEN + "   M:::::::::M   M:::::::::M    A:::::A   A:::::A    N::::::N:::  N::::::N    A:::::A   A::::::A     G:::::::G               E::::::::::::::::E   R:::::R   R::::R" + Reset);
            System.out.println(GREEN + "   M::::::::::MMM::::::::::M   A::::A     A:::::A    N::::::N:::::N::::::N   A:::::A      A:::::A    G::::::G                E::::::::::::::::E   R:::::R  R::::R" + Reset);
            System.out.println(BLUE + "    M::::::::: :M: :::::::::M   A::::A       A::::A   N::::::N:::::N::::::N  A::::::A      A::::::A   G::::::G                E::::::::::::::::E   R:::::RR::::R" + Reset);
            System.out.println(BLUE + "    M::::::::        :::::::M  A:::::A:::::: A::::A   N::::::N  :::N::::::N  A::::::A::::::A::::::A   G::::::G        ::::G   E::::::E             R:::::R R::::R" + Reset);
            System.out.println(PURPLE + "  M::::::::        :::::::M  A:::::A       A:::::A  N::::::N   ::N::::::N  A::::::A       A:::::A    G::::::G       ::::G   E:::::::             R:::::R  R::::R" + Reset);
            System.out.println(PURPLE + "  M::::::::        :::::::M  A:::::A       A:::::A  N::::::N   ::N::::::N  A::::::A       A:::::A     G:::::::::::::::::G   E::::::::::::::::E   R:::::R  R::::R" + Reset);
            System.out.println(RED + "     M::::::::        :::::::M  A:::::A       A:::::A  N::::::N   :::N:::::N  A::::::A       A:::::A      G::::::::::::::::G   E::::::::::::::::E   R:::::R   R::::R" + Reset);
            System.out.println(RED + "     M::::::::        :::::::M  A:::::A       A:::::A  N::::::N   :::N:::::N  A::::::A       A:::::A        G:::::G    ::::G   EEEEEEEEEEEEEEEEEE   R:::::R   R::::R" + Reset);
            System.out.println();
    }

    // Manager menu logic
    @Override
    public void Menu() {
        printWelcomeManager();  // Call to display the ASCII art
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manager Menu:");
        System.out.println("1. Hire Employee");
        System.out.println("2. Fire Employee");
        System.out.println("3. Update Profile");
        System.out.println("4. Display All Employees");
        System.out.println("5. Exit");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                HireEmployee();
                break;
            case 2:
                FireEmployee();
                break;
            case 3:
                UpdateSelf();
                break;
            case 4:
                DisplayAllEmployee();
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice, try again.");
        }
    }

    // Placeholder methods for hire, fire, update, display, etc.
    public void HireEmployee() {
        System.out.println("Hiring Employee...");
    }

    public void FireEmployee() {
        System.out.println("Firing Employee...");
    }

    public void UpdateSelf() {
        System.out.println("Updating Profile...");
    }

    public void DisplayAllEmployee() {
        System.out.println("Displaying all employees...");
    }
}


