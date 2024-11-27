import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAuthors 
{
   public static void main(String args[]) 
   {
      final String DATABASE_URL = "jdbc:mysql://localhost:3306/books?useTimezone=true&serverTimezone=UTC";        
      final String SELECT_QUERY = "SELECT authorID, firstName, lastName FROM authors";
      // use try-with-resources to connect to and query the database
      try 
      {               
         Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "Admin_123");                     
         Statement statement = connection.createStatement();       
         ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

         // get ResultSet's meta data
         ResultSetMetaData metaData = resultSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();     
         
         System.out.printf("Authors Table of Books Database:%n%n");

         // display the names of the columns in the ResultSet
         for (int i = 1; i <= numberOfColumns; i++) 
         {
            System.out.printf("%-8s\t", metaData.getColumnName(i));
         }
         System.out.println();
         
         // display query results
         while (resultSet.next()) 
         {
            for (int i = 1; i <= numberOfColumns; i++) 
            {
               System.out.printf("%-8s\t", resultSet.getObject(i));
            }
            System.out.println();
         }

	      connection.close();
      }
      catch (SQLException sqlException) 
      {
         sqlException.printStackTrace();
      }
   }
      
}

