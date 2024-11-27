import java.sql.Date;

public class RegularEmployee
{
    private String name;
    private String surname;
    private String username;
    private String role;
    private String phone;
    private String email;
    private String password;
    private Date birthday;
    private Date employmentday;


    public RegularEmployee(String name, String surname, String username, String role, String email, String phone)
    {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.role = role;
        this.phone = role;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.employmentday = employmentday;

    }

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getUsername() {return username;}
    public String getRole() {return role;}
    public String getPhone() {return phone;}
    public Date getBirthday() {return birthday;}
    public Date getEmploymentday() {return employmentday;}
    public void setPhone(String phone) { this.phone = phone;}
    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) { this.password = password;}



    // Regular Employee Menu
    public static void RM()
    {

    }
    public static void PrintRM()
    {

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

    public static void PrintNonProfile()
    {

    }
}
