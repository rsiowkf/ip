package Siao.Command;

import Siao.Parser.Parser;
import Siao.management.Storage;
import Siao.task.Task;

import java.util.ArrayList;

public class unmarkCommand {
    public static void unmarkTask (String[] splitInput, ArrayList<Task> list, Storage storage) {
        int unmarkIndex = Parser.parseTaskIndex(splitInput);
        if (list.isEmpty()) {
            throw new IllegalArgumentException("No item in the list, HOW TO UNMARK?");
        }
        list.get(unmarkIndex).markUndone();
        list.get(unmarkIndex).printMarkUndone();
        storage.saveAllTasks(list);
    }
}
