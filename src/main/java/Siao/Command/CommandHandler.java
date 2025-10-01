package Siao.Command;

import Siao.management.Constants;
import Siao.management.PrintManager;
import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.task.Todo;
import Siao.Parser.Parser;
import Siao.management.Storage;
import java.util.ArrayList;

public class CommandHandler {

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
                markCommand.markTask(splitInput, list, storage);
                break;

            case "unmark":
                unmarkCommand.unmarkTask(splitInput, list, storage);
                break;

            case "delete":
                deleteCommand.deleteTask(splitInput, list, storage);
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
