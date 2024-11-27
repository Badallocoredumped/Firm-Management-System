import java.sql.Date;

public abstract class User 
{
    protected String name;
    protected String surname;
    protected String username;
    protected String role;
    protected String phone;
    protected String email;
    protected String password;
    protected String ID;
    protected Date birthday;
    protected Date employmentday;


    public User(String name, String surname, String username, String role, String email, String phone, String ID, String password, Date birthday, Date employmentday)
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

    public abstract void Menu();
}
