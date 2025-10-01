package Siao.management;

import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.task.Todo;
import Siao.Parser.Parser;
import Siao.management.Storage;

import java.util.ArrayList;

public class CommandHandler {

    public static String preprocessInput(String userInput, String keyword) {
        return userInput
                .trim()
                .toLowerCase()
                .substring(keyword.length())
                .trim();
    }

    private static Storage storage;

    public static void setStorage(Storage s) {
        storage = s;
    }


    public static void handleCommand(String line, ArrayList<Task> list){
        String[] splitInput = line.split(" ");
        String command = splitInput[0];

        switch (command){

            case "list":
                PrintManager.printList(list);
                break;

            case "mark":
                int markIndex = Parser.parseTaskIndex(splitInput);
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("No item in the list, HOW TO MARK?");
                }
                list.get(markIndex).markDone();
                list.get(markIndex).printMarkDone();
                storage.saveAllTasks(list);
                break;

            case "unmark":
                int unmarkIndex = Parser.parseTaskIndex(splitInput);
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("No item in the list, HOW TO UNMARK?");
                }
                list.get(unmarkIndex).markUndone();
                list.get(unmarkIndex).printMarkUndone();
                storage.saveAllTasks(list);
                break;

            case "delete":
                int deleteIndex = Parser.parseTaskIndex(splitInput);
                PrintManager.printDeletedTask(list, deleteIndex);
                break;

            case "deadline":
                Deadline newDeadline = new Deadline(line);
                list.add(newDeadline);
                PrintManager.printAddedTask(newDeadline);
                storage.saveTask(newDeadline);
                break;

            case "event":
                Event newEvent = new Event(line);
                list.add(newEvent);
                PrintManager.printAddedTask(newEvent);
                storage.saveTask(newEvent);
                break;

            case "todo":
                Todo newTodo = new Todo(line);
                list.add(newTodo);
                PrintManager.printAddedTask(newTodo);
                storage.saveTask(newTodo);
                break;

            default:
                if (!command.isEmpty()){
                    throw new IllegalArgumentException(Constants.ILLEGAL_MESSAGE);
                }
                throw new IllegalArgumentException(Constants.EMPTY_DESC_MESSAGE);
        }

    }
}
