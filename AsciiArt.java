public class AsciiArt {
    //color code
    public static final String Reset = "\u001B[0m";
    public static final String Red = "\u001B[31m";
    public static final String Yellow = "\u001B[33m";
    public static final String Green = "\u001B[32m";
    public static final String Blue = "\u001B[34m";
    public static final String Purple = "\u001B[35m";

    public static void main(String[] args) {
      printWelcome();
      printPlease();
      printLogin();
    }
  
    public static void printWelcome() {
      System.out.println(Red + "WWWWWWWW                           WWWWWWWW     EEEEEEEEEEEEEEEEEEEEEE     LLLLLLLLLLL                          CCCCCCCCCCCCC          OOOOOOOOO          MMMMMMMM               MMMMMMMM     EEEEEEEEEEEEEEEEEEEEEE" + Reset);
        System.out.println(Red + "W::::::W                           W::::::W     E::::::::::::::::::::E     L:::::::::L                       CCC::::::::::::C        OO:::::::::OO        M:::::::M             M:::::::M     E::::::::::::::::::::E" + Reset);
        System.out.println(Yellow + "W::::::W                           W::::::W     E::::::::::::::::::::E     L:::::::::L                     CC:::::::::::::::C      OO:::::::::::::OO      M::::::::M           M::::::::M     E::::::::::::::::::::E" + Reset);
        System.out.println(Yellow + "W::::::W                           W::::::W     EE::::::EEEEEEEEE::::E     LL:::::::LL                    C:::::CCCCCCCC::::C     O:::::::OOO:::::::O     M:::::::::M         M:::::::::M     EE::::::EEEEEEEEE::::E" + Reset);
        System.out.println(Green + " W:::::W           WWWWW           W:::::W        E:::::E       EEEEEE       L:::::L                     C:::::C       CCCCCC     O::::::O   O::::::O     M::::::::::M       M::::::::::M       E:::::E       EEEEEE" + Reset);
        System.out.println(Green + "  W:::::W         W:::::W         W:::::W         E:::::E                    L:::::L                    C:::::C                   O:::::O     O:::::O     M:::::::::::M     M:::::::::::M       E:::::E" + Reset);
        System.out.println(Blue + "   W:::::W       W:::::::W       W:::::W          E::::::EEEEEEEEEE          L:::::L                    C:::::C                   O:::::O     O:::::O     M:::::::M::::M   M::::M:::::::M       E::::::EEEEEEEEEE" + Reset);
        System.out.println(Blue + "    W:::::W     W:::::::::W     W:::::W           E:::::::::::::::E          L:::::L                    C:::::C                   O:::::O     O:::::O     M::::::M M::::M M::::M M::::::M       E:::::::::::::::E" + Reset);
        System.out.println(Purple + "     W:::::W   W:::::W:::::W   W:::::W            E:::::::::::::::E          L:::::L                    C:::::C                   O:::::O     O:::::O     M::::::M  M::::M::::M  M::::::M       E:::::::::::::::E" + Reset);
        System.out.println(Purple + "      W:::::W W:::::W W:::::W W:::::W             E::::::EEEEEEEEEE          L:::::L                    C:::::C                   O:::::O     O:::::O     M::::::M   M:::::::M   M::::::M       E::::::EEEEEEEEEE" + Reset);
        System.out.println(Red + "       W:::::W:::::W   W:::::W:::::W              E:::::E                    L:::::L                    C:::::C                   O:::::O     O:::::O     M::::::M    M:::::M    M::::::M       E:::::E" + Reset);
        System.out.println(Red + "        W:::::::::W     W:::::::::W               E:::::E       EEEEEE       L:::::L         LLLLLL      C:::::C       CCCCCC     O::::::O   O::::::O     M::::::M     MMMMM     M::::::M       E:::::E       EEEEEE" + Reset);
        System.out.println(Yellow + "         W:::::::W       W:::::::W              EE::::::EEEEEEEE:::::E     LL:::::::LLLLLLLLL:::::L       C:::::CCCCCCCC::::C     O:::::::OOO:::::::O     M::::::M               M::::::M     EE::::::EEEEEEEE:::::E" + Reset);
        System.out.println(Yellow + "          W:::::W         W:::::W               E::::::::::::::::::::E     L::::::::::::::::::::::L        CC:::::::::::::::C      OO:::::::::::::OO      M::::::M               M::::::M     E::::::::::::::::::::E" + Reset);
        System.out.println(Green + "           W:::W           W:::W                E::::::::::::::::::::E     L::::::::::::::::::::::L          CCC::::::::::::C        OO:::::::::OO        M::::::M               M::::::M     E::::::::::::::::::::E" + Reset);
        System.out.println(Green + "            WWW             WWW                 EEEEEEEEEEEEEEEEEEEEEE     LLLLLLLLLLLLLLLLLLLLLLLL             CCCCCCCCCCCCC          OOOOOOOOO          MMMMMMMM               MMMMMMMM     EEEEEEEEEEEEEEEEEEEEEE" + Reset);
    }  
    
    public static void printPlease() {
      System.out.println(Red + " |  __ \\  | |      |  ____|     /\\      / ____| |  ____|" + Reset);
      System.out.println(Yellow + " | |__) | | |      | |__       /  \\    | (___   | |__" + Reset);
      System.out.println(Green + " |  ___/  | |      |  __|     / /\\ \\    \\___ \\  |  __|" + Reset);
      System.out.println(Blue + " | |      | |____  | |____   / ____ \\   ____) | | |____" + Reset);
      System.out.println(Purple + " |_|      |______| |______| /_/___ \\_\\ |_____/  |______|" + Reset);
      System.out.println();
    }

    public static void printLogin() {
      System.out.println(Red + " | |       / __ \\   / ____| |_   _| | \\ | |" + Reset);
      System.out.println(Yellow + " | |      | |  | | | |  __    | |   |  \\| |" + Reset);
      System.out.println(Green + " | |      | |  | | | | |_ |   | |   | . ` |" + Reset);
      System.out.println(Blue + " | |____  | |__| | | |__| |  _| |_  | |\\  |" + Reset);
      System.out.println(Purple + " |______|  \\____/   \\_____| |_____| |_| \\_| " + Reset);
    }
  }
  