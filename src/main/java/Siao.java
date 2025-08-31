import java.util.Arrays;
import java.util.Scanner;

public class Siao {

    public static void  printDividerLine(){
        System.out.println("---------------------------------");
    }

    public static void printList(String[] list) {
        printDividerLine();
        int j = 1;
        for (int i = 0; i < list.length; i++) {
            System.out.printf(j + "." + list[i] + "\n");
            j++;
        }
        printDividerLine();
    }

    public static void printAction(String action){
        printDividerLine();
        System.out.printf("added: " + action + "\n");
        printDividerLine();
    }

    public static void main(String[] args) {
      System.out.println("Hello! I'm Siao!");

      Scanner input = new Scanner(System.in);
      System.out.println("What can I do for you?");
      String line = input.nextLine();

      String[] list = new String[100];
      int matchCount = 0;

      while(!line.equalsIgnoreCase("bye")){
          printAction(line);
          list[matchCount] = line;
          matchCount++;
          line = input.nextLine();

          if (line.equalsIgnoreCase("list")){
              printList(Arrays.copyOf(list, matchCount));
              line = input.nextLine();
          }
      }


      System.out.println("---------------------------------");
      System.out.println("Bye. Hope to see you again soon!");
    }
}
