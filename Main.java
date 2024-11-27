public class Main 
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        DataBaseHandler dbHandler = new DataBaseHandler();
        //dbHandler.DispAllEmployee();
        System.out.println("Displayed All Employees");
        //dbHandler.DispEmployeeWithRole("manager");
        System.out.println("Displayed All Employees with the role");
        //dbHandler.DispEmployeeWithUsername("emir5757");
        //dbHandler.DispEmployeeWithNameSurname("Emir","Özen");
        //dbHandler.HireEmployee("volkanbey", "Volkan", "Erdoğan", "intern", "0523432", "2022.11.01", "2022.12.2", "bozoman");
        dbHandler.FireEmployee(21,"volkanbey","Volkan","Erdoğan");
    }
    
}
