import java.sql.Date;
import java.util.Scanner;

public abstract class Employee 
{
    protected int ID;
    protected String username;
    protected String role;
    protected String name;
    protected String surname;
    protected String phone;
    protected Date DOB;
    protected Date DOS;
    protected String Email;
    protected String Password;
    protected Boolean DEFAULT_PASSWORD;

    public static Scanner input = new Scanner(System.in);
    static DataBaseHandler dbHandler = new DataBaseHandler();
    public Employee(int ID, String Username,String Role,String Name,String Surname,String Phone,Date DOB,Date DOS,String Email,String Password, Boolean DEFAULT_PASSWORD)
    {
        this.ID = ID;
        this.username = Username;
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
    public String getUsername() {return username;}
    public String getRole() {return role;}
    public int getID() {return ID;}
    public Date getBirthday() {return DOB;}
    public Date getEmploymentday() {return DOS;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) { this.phone = phone;}
    public String getEmail() {return Email;}
    public void setEmail(String email) { this.Email = email;}
    public String getPassword() {return Password;}
    public void setPassword(String Password) { this.Password = Password;}
    public Boolean getDEFAULT_PASSWORD() {return DEFAULT_PASSWORD;}
    
    public abstract void Menu();

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
                Ccleaner();
                System.out.println("You can not use the same password!!");
                continue;
            }

            if (nPassword.length() < 8 || nPassword.length() > 16 || nPassword.isBlank() ) 
            {
                Ccleaner();
                System.out.println("Password must have between 8 and 16 characters");
                continue;
            }

            dbHandler.UpdatePhone(ID, nPassword);
            setPassword(nPassword);
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
                Ccleaner();
                System.out.println("You can not use the same Email!!");
                continue;
            }

            if (!nEmail.matches(EmailRegex)) 
            {
                Ccleaner();
                System.out.println("Invalide email format!! (Spacial characters are not allowed)");
                continue;
            }

            dbHandler.UpdatePhone(ID, nEmail);
            setEmail(nEmail);
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
                Ccleaner();
                System.out.println("You can not use the same phone number!!");
                continue;
            }

            if (nPhone.length() != 10 || nPhone.isBlank() ||  !nPhone.matches("\\d+")) 
            {
                Ccleaner();
                System.out.println("Phone number must have 10 digits");
                continue;
            }

            dbHandler.UpdatePhone(ID, nPhone);
            setPhone(nPhone);
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
