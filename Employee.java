import java.sql.Date;

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
    /* public String getPassword() {return password;}
    public void setPassword(String password) { this.password = password;}
    */
    public abstract void Menu();
}
