import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Siao {

    public static void  printDividerLine(){
        System.out.println(Constants.DIVIDER);
    }

    private static void handleCommand(String line, ArrayList<Task> list){
        String[] splitInput = line.split(" ");
        String command = splitInput[0];

        switch (command){

            case "list":
                Listmanager.printList(list);
                break;

            case "mark":
                int markIndex = Integer.parseInt(splitInput[1]) - 1;
                list.get(markIndex).markDone();
                list.get(markIndex).printMarkDone();
                break;

            case "unmark":
                int unmarkIndex = Integer.parseInt(splitInput[1]) - 1;
                list.get(unmarkIndex).markUndone();
                list.get(unmarkIndex).printMarkUndone();
                break;

            case "deadline":
                Deadline newDeadline = new Deadline(line);
                list.add(newDeadline);
                Listmanager.printAddedTask(newDeadline);
                break;

            case "event":
                Event newEvent = new Event(line);
                list.add(newEvent);
                Listmanager.printAddedTask(newEvent);
                break;

            case "todo":
                Todo newTodo = new Todo(line);
                list.add(newTodo);
                Listmanager.printAddedTask(newTodo);
                break;

            default:
                Task newTask = new Task(line);
                list.add(newTask);
                Listmanager.printAddedTask(newTask);
        }

    }

    public static void main(String[] args) {
        System.out.print(Constants.WELCOME_MESSAGE);

        Scanner input = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        String line = input.nextLine();

        while(!line.equalsIgnoreCase("bye")){
            if (line.trim().isEmpty()){
                Listmanager.printErrorEmptyMessage();
                line = input.nextLine();
                continue;
            }

            if(!line.contains("event") && !line.contains("todo") && !line.contains("deadline")){
                Listmanager.printIllegalMessage();
                line = input.nextLine();
            }

            try {
                handleCommand(line, list);
                line = input.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print(">>>   ");
                line = input.nextLine();
            }
        }

        System.out.println(Constants.DIVIDER);
        System.out.println(Constants.GOODBYE_MESSAGE);
    }
}
