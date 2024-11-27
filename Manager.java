public class Manager extends Employee
{
    int ID;
    String Username;
    String Role; 
    String Name; 
    String Surname; 
    String Phone; 
    String DOB; 
    String DOS; 
    String Email; 


    public Manager(int ID, String Username,String Role,String Name,String Surname,String Phone,String DOB,String DOS,String Email)
    {
        this.ID = ID;
        this.Username = Username;
        this.Role = Role;
        this.Name = Name;
        this.Surname = Surname;
        this.Phone = Phone;
        this.DOB = DOB;
        this.DOS = DOS;
        this.Email = Email;
    }
    
}
