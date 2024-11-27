import java.util.Scanner;
import java.sql.Date;

public class RegularEmployee
{
    static int delay = 1000;
    Scanner input;
    private String name;
    private String surname;
    private String username;
    private String role;
    private String phone;
    private String email;
    private String password;
    private String ID;
    private Date birthday;
    private Date employmentday;


    public RegularEmployee(String name, String surname, String username, String role, String email, String phone, String ID, String password, Date birthday, Date employmentday)
    {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.ID = ID;
        this.password = password;
        this.birthday = birthday;
        this.employmentday = employmentday;

    }

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getUsername() {return username;}
    public String getRole() {return role;}
    public String getID() {return ID;}
    public Date getBirthday() {return birthday;}
    public Date getEmploymentday() {return employmentday;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) { this.phone = phone;}
    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) { this.password = password;}



    // Regular Employee Menu
    public static void RM(Scanner input, RegularEmployee employee)
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
                PrintProfile(employee, input);
            }

            case '2'-> //Update info
            {
                //Working on it!!!!;
            }
            
            case '3'-> //Logout
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
    public static void PrintProfile(RegularEmployee employee, Scanner input)
    {
        char cRM ='0';
        String sRM;
        boolean toRM = false;
        while (!toRM) 
        {
            System.out.println("Profile information");
            System.out.println("Name: " + employee.getName());
            System.out.println("Surname: " + employee.getSurname());
            System.out.println("Email:" + employee.getEmail());
            System.out.println("Phone" + employee.getPhone());
            System.out.println("ID: " + employee.getID());
            System.out.println("Role: " + employee.getRole());
            System.out.println("Birthday: " + employee.getBirthday());
            System.out.println("Employment day: " + employee.getEmploymentday());
            System.out.println("Username: " + employee.getUsername());
            System.out.println("Password: " + employee.getPassword() + "\n");
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

    public static void ChangePassword()
    {

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

