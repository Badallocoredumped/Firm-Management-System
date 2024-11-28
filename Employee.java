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

    public static Scanner input = new Scanner(System.in);
    public Employee(int ID, String Username,String Role,String Name,String Surname,String Phone,Date DOB,Date DOS,String Email,String Password)
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
