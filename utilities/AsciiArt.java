package utilities;


/**
 * The class provides utilities for printing colorful ASCII art 
 * and displaying formatted text, including a welcome banner and author credits.
 * It utilizes ANSI escape codes for adding color to the console output.
 */
public class AsciiArt 
{
    // Color codes for console output
    public String RESET = "\u001B[0m";         // Reset color
    public String BLACK = "\u001B[30m";       // Black
    public String RED = "\u001B[31m";         // Red
    public String GREEN = "\u001B[32m";       // Green
    public String YELLOW = "\u001B[33m";      // Yellow
    public String BLUE = "\u001B[34m";        // Blue
    public String MAGENTA = "\u001B[35m";     // Magenta
    public String CYAN = "\u001B[36m";        // Cyan
    public String WHITE = "\u001B[37m";       // White
    public String BRIGHT_BLACK = "\u001B[90m";    // Bright Black
    public String BRIGHT_RED = "\u001B[91m";      // Bright Red
    public String BRIGHT_GREEN = "\u001B[92m";    // Bright Green
    public String BRIGHT_YELLOW = "\u001B[93m";   // Bright Yellow
    public String BRIGHT_BLUE = "\u001B[94m";     // Bright Blue
    public String BRIGHT_MAGENTA = "\u001B[95m";  // Bright Magenta
    public String BRIGHT_CYAN = "\u001B[96m";     // Bright Cyan
    public String BRIGHT_WHITE = "\u001B[97m";    // Bright White
    
    /**
     * Prints a colorful ASCII art welcome banner to the console.
     * The banner uses a custom color (orange) for emphasis and provides a stylish introduction.
     */
    public void printWelcome()
    {
        
            
        
                final String ORANGE = "\u001B[38;5;214m";
                final String RESET = "\u001B[0m"; 
        
                System.out.println(ORANGE + "██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗");
                System.out.println("██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝");
                System.out.println("██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  ");
                System.out.println("██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  ");
                System.out.println("╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗");
                System.out.println(" ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝");
                System.out.println("                                                              ");
                System.out.println("████████╗ ██████╗     ████████╗██╗  ██╗███████╗               ");
                System.out.println("╚══██╔══╝██╔═══██╗    ╚══██╔══╝██║  ██║██╔════╝               ");
                System.out.println("   ██║   ██║   ██║       ██║   ███████║█████╗                 ");
                System.out.println("   ██║   ██║   ██║       ██║   ██╔══██║██╔══╝                 ");
                System.out.println("   ██║   ╚██████╔╝       ██║   ██║  ██║███████╗               ");
                System.out.println("   ╚═╝    ╚═════╝        ╚═╝   ╚═╝  ╚═╝╚══════╝               ");
                System.out.println("                                                              ");
                System.out.println("███████╗██╗██████╗ ███╗   ███╗   ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗███╗   ███╗███████╗███╗   ██╗████████╗   ███████╗██╗   ██╗███████╗████████╗███████╗███╗   ███╗ ");
                System.out.println("██╔════╝██║██╔══██╗████╗ ████║   ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝████╗ ████║██╔════╝████╗  ██║╚══██╔══╝   ██╔════╝╚██╗ ██╔╝██╔════╝╚══██╔══╝██╔════╝████╗ ████║ ");
                System.out.println("█████╗  ██║██████╔╝██╔████╔██║   ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██╔████╔██║█████╗  ██╔██╗ ██║   ██║      ███████╗ ╚████╔╝ ███████╗   ██║   █████╗  ██╔████╔██║ ");
                System.out.println("██╔══╝  ██║██╔══██╗██║╚██╔╝██║   ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║   ██║      ╚════██║  ╚██╔╝  ╚════██║   ██║   ██╔══╝  ██║╚██╔╝██║ ");
                System.out.println("██║     ██║██║  ██║██║ ╚═╝ ██║   ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║ ╚═╝ ██║███████╗██║ ╚████║   ██║      ███████║   ██║   ███████║   ██║   ███████╗██║ ╚═╝ ██║ ");
                System.out.println("╚═╝     ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝   ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝      ╚══════╝   ╚═╝   ╚══════╝   ╚═╝   ╚══════╝╚═╝     ╚═╝ ");
                System.out.println(RESET);
    }

    /**
     * Displays the names of the authors in a formatted and colorful output.
     * Each author's name is printed in a different color.
     */
    public void PrintAuthors()
    {
        System.out.println(WHITE + "Authors:");
        System.out.println(YELLOW + "Emir Özen");
        System.out.println(CYAN + "Ahmed Teka Kanadji");
        System.out.println(GREEN + "Taha Özkan");
        System.out.println(BLUE + "Alara Gümüşçü");
        System.out.println(MAGENTA + "Maryam Khan");
        System.out.println();
    }
       
}
    

