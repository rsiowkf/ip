import java.util.Scanner;
import java.util.ArrayList;

public class Siao {

    public static void  printDividerLine(){
        System.out.println(Constants.DIVIDER);
    }

    public static void main(String[] args) {
        System.out.print(Constants.WELCOME_MESSAGE);

        Scanner input = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        String line = input.nextLine();

        while(!line.equalsIgnoreCase("bye")){

            if (line.trim().isEmpty()){
                System.out.println(Constants.ERROR_MESSAGE);
                line = input.nextLine();
                continue;
            }

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
                    Deadline newDeadline = new Deadline(line);
                    list.add(newDeadline);
                    Listmanager.printAddedTask(newDeadline);
                    line = input.nextLine();
                    break;

                case "event":
                    Event newEvent = new Event(line);
                    list.add(newEvent);
                    Listmanager.printAddedTask(newEvent);
                    line = input.nextLine();
                    break;

                case "todo":
                    Todo newTodo = new Todo(line);
                    list.add(newTodo);
                    Listmanager.printAddedTask(newTodo);
                    line = input.nextLine();
                    break;

                default:
                    Task newTask = new Task(line);
                    list.add(newTask);
                    Listmanager.printAddedTask(newTask);
                    line = input.nextLine();
            }
        }

        System.out.println(Constants.DIVIDER);
        System.out.println(Constants.GOODBYE_MESSAGE);
    }
}
