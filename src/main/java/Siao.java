import java.util.Arrays;
import java.util.Scanner;

public class Siao {

    public enum Label {
        TODO,
        DEADLINE,
        EVENT
    }

    private static final String DIVIDER = "---------------------------------";
    private static final String WELCOME_MESSAGE = "Hello I'm Siao!\n What can I do for you today?\n";
    private static final String GOODBYE_MESSAGE = "Bye bye! Do remember to complete your tasks!";

    public static void  printDividerLine(){
        System.out.println(DIVIDER);
    }

    public static void printList(Task[] list) {
        printDividerLine();
        int indexNumber = 1;
        for (Task task : list) {
            if (task == null) {
                System.out.println("-----------End Of List-----------");
                break;
            }
            System.out.printf("%d. [%s] %s\n", indexNumber, task.getStatusIcon(), task.getDescription());
            indexNumber++;
        }
        printDividerLine();
    }


//    public static void printAction(String action){
//        printDividerLine();
//        System.out.printf("added: " + action + "\n");
//        printDividerLine();
//    } moved to Task class

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);

        Scanner input = new Scanner(System.in);
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
                    Task.printAddedTask(list[matchCount]);
                    matchCount++;
                    line = input.nextLine();
                    break;
            }
        }

        System.out.println(DIVIDER);
        System.out.println(GOODBYE_MESSAGE);
    }
}
