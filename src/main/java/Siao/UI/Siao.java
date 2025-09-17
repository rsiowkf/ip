package Siao.UI;
import Siao.management.Constants;
import Siao.management.Printmanager;
import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.task.Todo;

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
                Printmanager.printList(list);
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
                Printmanager.printAddedTask(newDeadline);
                break;

            case "event":
                Event newEvent = new Event(line);
                list.add(newEvent);
                Printmanager.printAddedTask(newEvent);
                break;

            case "todo":
                Todo newTodo = new Todo(line);
                list.add(newTodo);
                Printmanager.printAddedTask(newTodo);
                break;

            default:
                if (!command.isEmpty()){
                    throw new IllegalArgumentException(Constants.ILLEGAL_MESSAGE);
                }
                throw new IllegalArgumentException(Constants.EMPTY_DESC_MESSAGE);
        }

    }

    public static void main(String[] args) {
        System.out.print(Constants.WELCOME_MESSAGE);

        Scanner input = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        String line = input.nextLine();

        while(!line.equalsIgnoreCase("bye")){

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
