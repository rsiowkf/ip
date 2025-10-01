package Siao.Command;

import Siao.Parser.Parser;
import Siao.management.Constants;
import Siao.management.PrintManager;
import Siao.management.Storage;
import Siao.task.Task;

import java.util.ArrayList;

public class UnmarkCommand {
    public static void unmarkTask (String[] splitInput, ArrayList<Task> list, Storage storage) {
        int unmarkIndex = Parser.parseTaskIndex(splitInput);

        if (list.isEmpty()) {
            throw new IllegalArgumentException("No item in the list, HOW TO UNMARK?");
        } else if (Integer.parseInt(splitInput[1]) > list.size()) {
            throw new IllegalArgumentException(Constants.UNMARK_WRONGLY);
        }

        list.get(unmarkIndex).markUndone();
        PrintManager.printMarkUndone(list.get(unmarkIndex));
        storage.saveAllTasks(list);
    }
}
