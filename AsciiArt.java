public class AsciiArt {
    //color code
    public static final String Reset = "\u001B[0m";
    public static final String Red = "\u001B[31m";
    public static final String Yellow = "\u001B[33m";
    public static final String Green = "\u001B[32m";
    public static final String Blue = "\u001B[34m";
    public static final String Purple = "\u001B[34m";
  
    public static void main(String[] args) {
      //WELCOME
      System.out.println(Red + "W:W          W:W  E:E:E:E:E:  L:L         C:C:C:C:C:   O:O:O:O   M:M       M:M  E:E:E:E:E:" + Reset);
      System.out.println(Yellow + "W:W     W    W:W  E:E         L:L         C:C         O:O   O:O  M:M:M   M:M:M  E:E" + Reset);
      System.out.println(Green + "W:W    :W:   W:W  E:E:E:E:E:  L:L         C:C         O:O   O:O  M:M  M:M  M:M  E:E:E:E:E:" + Reset);
      System.out.println(Blue + " W:W  W:W:W  W:W  E:E         L:L         C:C         O:O   O:O  M:M   M   M:M  E:E" + Reset);
      System.out.println(Purple + "  W:W      W:W    E:E:E:E:E:  L:L:L:L:L:  C:C:C:C:C:   O:O:O:O   M:M       M:M  E:E:E:E:E:" + Reset);
      System.out.println();
      //PLEASE
      System.out.println(Red + "P:P:P:P:P:   L:L         E:E:E:E:E:     :A:A      S:S:S:S:S:  E:E:E:E:E:" + Reset);
      System.out.println(Yellow + "P:P    P:P:  L:L         E:E           A:A:A:A    S:S         E:E" + Reset);
      System.out.println(Green + "P:P:P:P:P:   L:L         E:E:E:E:E:  A:A     A:A  S:S:S:S:S:  E:E:E:E:E:" + Reset);
      System.out.println(Blue + "P:P          L:L         E:E         A:A:A:A:A:A        S:S:  E:E" + Reset);
      System.out.println(Purple + "P:P          L:L:L:L:L:  E:E:E:E:E:  A:A     A:A  S:S:S:S:S:  E:E:E:E:E:" + Reset);
      System.out.println();
      //LOGIN
      System.out.println(Red + "L:L          O:O:O:O    G:G:G:G:G:  I:I:I:I:I  N:N     N:N" + Reset);
      System.out.println(Yellow + "L:L         O:O   O:O  G:G             I:I     N:N:N   N:N" + Reset);
      System.out.println(Green + "L:L         O:O   O:O  G:G    G:G:     I:I     N:N  N  N:N" + Reset);
      System.out.println(Blue + "L:L         O:O   O:O  G:G     :G:     I:I     N:N   N:N:N" + Reset);
      System.out.println(Purple + "L:L:L:L:L:   O:O:O:O    G:G:G:G:G:  I:I:I:I:I  N:N     N:N" + Reset);
    }
  }
  