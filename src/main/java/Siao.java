import java.util.Scanner;

public class Siao {
    public static void main(String[] args) {
      System.out.println("Hello! I'm Siao!");

      Scanner input = new Scanner(System.in);
      System.out.println("What can I do for you?");
      String line = input.nextLine();

      while(!line.equalsIgnoreCase("bye")){
          System.out.printf("---------------------------------\n" + line + "\n---------------------------------\n");
          line = input.nextLine();
      }
      System.out.println("---------------------------------");
      System.out.println("Bye. Hope to see you again soon!");
    }
}
