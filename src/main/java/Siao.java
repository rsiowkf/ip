import java.util.Arrays;
import java.util.Scanner;

public class Siao {

    public enum Label{
        TODO,
        EVENT,
        DEADLINE
    }

    public static void  printDividerLine(){
        System.out.println("---------------------------------");
    }

    public static void printList(Task[] list) {
        printDividerLine();
        int indexNumber = 1;
        for (Task task : list) {
            if (task == null) {
                System.out.println("-----------End Of List-----------");
                break;
            }
            System.out.printf("%d. [T][%s] %s\n", indexNumber, task.getStatusIcon(), task.getDescription());
            indexNumber++;
        }
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
// to add 3 more cases: TODO, EVENT and DEADLINE
                case "list":
                    printList(list);
                    line = input.nextLine();
                    break;

                case "todo":
                    list[matchCount] = new Task(line);
                    matchCount++;
                    Todo.printAction(line);
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
                    System.out.println(line);
                    line = input.nextLine();
                    break;
            }
        }

        System.out.println("---------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
    }
}

/* New Idea:
Everytime I input something, depending on the 1st word that I input, I will store the line into the task array
The task array will create a String
Each element in the String array will contain the following:
    [Label of Task][Marker] "description"

    Task class will only contain information about the Mark and the description
    my subclasses will contain information about the label
 */

