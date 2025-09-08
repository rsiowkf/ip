import java.util.Scanner;
import java.util.ArrayList;

public class Siao {


    private static final String DIVIDER = "---------------------------------";
    private static final String WELCOME_MESSAGE = "Hello I'm Siao!\nWhat can I do for you today?\n";
    private static final String GOODBYE_MESSAGE = "Bye bye! Do remember to complete your tasks!";
    private static final int DEADLINE_INDEX = 9;
    private static final int EVENT_INDEX = 6;

    public static void  printDividerLine(){
        System.out.println(DIVIDER);
    }

    public static void main(String[] args) {
        System.out.print(WELCOME_MESSAGE);

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        ArrayList<Task> list = new ArrayList<>();

        while(!line.equalsIgnoreCase("bye")){
            String[] splitInput = line.split(" ");
            String command = splitInput[0];

            switch (command){

                case "list":
                    Listmanager.printList(list);
                    line = input.nextLine();
                    break;

                case "mark":
                    int markIndex = Integer.parseInt(splitInput[1]) - 1;
                    list.get(markIndex).markDone();
                    list.get(markIndex).printMarkDone();
                    line = input.nextLine();
                    break;

                case "unmark":
                    int unmarkIndex = Integer.parseInt(splitInput[1]) - 1;
                    list.get(unmarkIndex).markUndone();
                    list.get(unmarkIndex).printMarkUndone();
                    line = input.nextLine();
                    break;

                case "deadline":
                    String deadlineDescription = line.substring(DEADLINE_INDEX);
                    Deadline newDeadline = new Deadline(deadlineDescription);
                    list.add(newDeadline);
                    newDeadline.printAddedTask();
                    line = input.nextLine();
                    break;

                case "event":
                    String  eventDescription = line.substring(EVENT_INDEX);
                    Event newEvent = new Event(eventDescription);
                    list.add(newEvent);
                    newEvent.printAddedTask();
                    line = input.nextLine();
                    break;


                default:
                    Task newTask = new Task(line);
                    list.add(newTask);
                    newTask.printAddedTask();
                    line = input.nextLine();
            }
        }

        System.out.println(DIVIDER);
        System.out.println(GOODBYE_MESSAGE);
    }
}
