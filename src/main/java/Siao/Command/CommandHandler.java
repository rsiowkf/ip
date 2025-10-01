package Siao.Command;

import Siao.management.Constants;
import Siao.management.PrintManager;
import Siao.task.Task;
import Siao.task.Todo;
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
                MarkCommand.markTask(splitInput, list, storage);
                break;

            case "unmark":
                UnmarkCommand.unmarkTask(splitInput, list, storage);
                break;

            case "delete":
                DeleteCommand.deleteTask(splitInput, list, storage);
                break;

            case "deadline":
                AddDeadline.newDeadline(list, line, storage);
                break;

            case "event":
                AddEvent.newEvent(list, line, storage);
                break;

            case "todo":
                AddTodo.newTodo(list, line, storage);
                break;

            case "find":
                FindTask.returnTask(line, list);
                break;

            default:
                if (!command.isEmpty()){
                    throw new IllegalArgumentException(Constants.ILLEGAL_MESSAGE);
                }
                throw new IllegalArgumentException(Constants.EMPTY_DESC_MESSAGE);
        }

    }
}
