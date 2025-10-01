package Siao.management;

import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.task.Todo;
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
                int markIndex = Integer.parseInt(splitInput[1]) - 1;
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("No item in the list, HOW TO MARK?");
                }
                list.get(markIndex).markDone();
                list.get(markIndex).printMarkDone();
                // mark and update the mark task
                storage.saveAllTasks(list);
                break;

            case "unmark":
                int unmarkIndex = Integer.parseInt(splitInput[1]) - 1;
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("No item in the list, HOW TO UNMARK?");
                }
                list.get(unmarkIndex).markUndone();
                list.get(unmarkIndex).printMarkUndone();
                storage.saveAllTasks(list);
                // unmark and update all the unmarked task
                break;

            case "delete":
                int deleteIndex = parseTaskIndex(splitInput);
                PrintManager.printDeletedTask(list, deleteIndex);
                break;

            case "deadline":
                Deadline newDeadline = new Deadline(line);
                list.add(newDeadline);
                PrintManager.printAddedTask(newDeadline);
                // add new deadline into the storage file
                storage.saveTask(newDeadline);
                break;

            case "event":
                Event newEvent = new Event(line);
                list.add(newEvent);
                PrintManager.printAddedTask(newEvent);
                // add new event into the storage file
                storage.saveTask(newEvent);
                break;

            case "todo":
                Todo newTodo = new Todo(line);
                list.add(newTodo);
                PrintManager.printAddedTask(newTodo);
                // add new todo into the storage file
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
