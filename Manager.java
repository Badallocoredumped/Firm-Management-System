import java.sql.Date;

public class Manager extends Employee
{
 
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
