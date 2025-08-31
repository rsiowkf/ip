import java.util.Arrays;
import java.util.Scanner;

public class Siao {

    public static void  printDividerLine(){
        System.out.println("---------------------------------");
    }

    public static void printList(Task[] list) {
        printDividerLine();
        int indexNumber = 1;
        for (int i = 0; i < list.length; i++) {
            if(list[i] == null) {
                System.out.println("-----------End Of List-----------");
                break;
            }
            System.out.printf("%d. [%s] %s\n", indexNumber, list[i].getStatusIcon(), list[i].getDescription());
            indexNumber++;
        }
        printDividerLine();
    }


    public static void printAction(String action){
        printDividerLine();
        System.out.printf("added: " + action + "\n");
        printDividerLine();
    }

    public static void main(String[] args) {
        System.out.println("Hello! I'm Siao!!");

        Scanner input = new Scanner(System.in);
        System.out.println("What can I do for you?");
        String line = input.nextLine();

        Task[] list = new Task[100];
        int matchCount = 0;

        while(!line.equalsIgnoreCase("bye")){
            String[] splitInput = line.split(" ");
            String command = splitInput[0];

            switch (command){

                case "list":
                    printList(list);
                    line = input.nextLine();
                    break;

                case "mark":
                    int markIndex = Integer.parseInt(splitInput[1]) - 1;
                    list[markIndex].markDone();
                    list[markIndex].printMarkDone();
                    line = input.nextLine();
                    break;

                case "unmark":
                    int unmarkIndex = Integer.parseInt(splitInput[1]) - 1;
                    list[unmarkIndex].markUndone();
                    list[unmarkIndex].printMarkUndone();
                    line = input.nextLine();
                    break;

                default:
                    list[matchCount] = new Task(line);
                    matchCount++;
                    printAction(line);
                    line = input.nextLine();
                    break;
            }
        }

        System.out.println("---------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
    }
}
