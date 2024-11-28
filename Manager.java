import java.sql.Date;

public class Manager extends Employee
{
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
 
    public Manager(int ID, String Username,String Role,String Name,String Surname,String Phone,Date DOB,Date DOS,String Email,String Password)
    {
        super(ID, Username,Role,Name,Surname,Phone,DOB,DOS,Email,Password);
    }


    @Override
    public void Menu() 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Menu'");
    }

    public void HireEmployee()
    {
        
        boolean validation = true;
        do 
        {
            
        } while (validation);


        dbHandler.HireEmployee(username, name, surname, role, phone, DOB, DOS, Email);
    }

    public void FireEmployee()
    {
        //cannot fire other managers
    }

    
    public void UpdateSelf()
    {
        //this will be overidden from the employee superclass
    }
    
    public void UpdateEmployee()
    {
        //Non-profile so everything except password phoneno and email
        //Update all or any of the non-profile 
        
    }
    
    public void DisplayAllEmployee()
    {

    }

    public void DisplayEmployeeWithRole()
    {

    }   
    
    public void DisplayEmployeeWithUsername()
    {

    }

    public void Algortihms()
    {
        //not my part
    }

    
}
