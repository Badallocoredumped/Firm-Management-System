import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Testing 
{
    public static void main(String[] args) 
    {
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        do 
        {
            
            System.out.println("Enter Date of Birth (YYYY-MM-DD):");
            String dobInput = scanner.nextLine();
    
            try 
            {
                LocalDate dob = LocalDate.parse(dobInput, DateTimeFormatter.ISO_LOCAL_DATE);
                System.out.println("Valid Date of Birth: " + dob);
            } 
            catch (Exception e) 
            {
                System.out.println("Invalid date format! Please use YYYY-MM-DD.");
            }

        } while (!valid);

        
    }
}
