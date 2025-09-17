package Siao.management;

import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.task.Todo;

import java.util.ArrayList;

public class CommandHandler {

    public static String preprocessInput(String userInput, String keyword) {
        return userInput
                .trim()
                .toLowerCase()
                .substring(keyword.length())
                .trim();
    }

    private static int parseTaskIndex(String[] userInput) {
        return Integer.parseInt(userInput[1]) - 1;
    }

    public static void handleCommand(String line, ArrayList<Task> list){
        String[] splitInput = line.split(" ");
        String command = splitInput[0];

        switch (command){

            case "list":
                PrintManager.printList(list);
                break;

            case "mark":
                int markIndex = parseTaskIndex(splitInput);
                list.get(markIndex).markDone();
                list.get(markIndex).printMarkDone();
                break;

            case "unmark":
                int unmarkIndex = parseTaskIndex(splitInput);
                list.get(unmarkIndex).markUndone();
                list.get(unmarkIndex).printMarkUndone();
                break;

            case "delete":
                int deleteIndex = parseTaskIndex(splitInput);
                list.remove(deleteIndex);


            case "deadline":
                Deadline newDeadline = new Deadline(line);
                list.add(newDeadline);
                PrintManager.printAddedTask(newDeadline);
                break;

            case "event":
                Event newEvent = new Event(line);
                list.add(newEvent);
                PrintManager.printAddedTask(newEvent);
                break;

            case "todo":
                Todo newTodo = new Todo(line);
                list.add(newTodo);
                PrintManager.printAddedTask(newTodo);
                break;

            default:
                if (!command.isEmpty()){
                    throw new IllegalArgumentException(Constants.ILLEGAL_MESSAGE);
                }
                throw new IllegalArgumentException(Constants.EMPTY_DESC_MESSAGE);
        }

    }
}
