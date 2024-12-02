import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;


public abstract class InputUtil 
{

    public static final Scanner scanner = new Scanner(System.in, Charset.forName(detectTerminalEncoding()));
    
    // Method to detect terminal code page using chcp command
    private static String detectTerminalEncoding() 
    {
        try 
        {
            // Execute chcp command
            Process process = new ProcessBuilder("cmd", "/c", "chcp").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // Read the output of the chcp command
            String line;
            while ((line = reader.readLine()) != null) 
            {
                if (line.contains("Active code page:")) 
                {
                    // Extract the code page number
                    String codePage = line.replaceAll("\\D+", ""); // Remove non-digit characters
                    return getCharsetForCodePage(codePage); // Map code page to charset
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return null; // Return null if detection fails
    }

    // Map code page to charset
    private static String getCharsetForCodePage(String codePage) 
    {
        switch (codePage) 
        {
            case "857":
                return "IBM857"; // Turkish (DOS)
            case "1254":
                return "windows-1254"; // Turkish (Windows)
            case "65001":
                return "UTF-8"; // UTF-8
            default:
                return "UTF-8"; // Unknown code page
        }
    }
}
    

