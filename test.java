public class test {
    public static void main(String[] args) 
    {
        final String RESET = "\u001B[0m";   
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String CYAN = "\u001B[36m";

        System.out.println(YELLOW + "Welcome to the Firm Management System!" + RESET);

        System.out.println(GREEN + "1. Login" + RESET);
        System.out.println(RED + "2. Exit System" + RESET);
    }
}
