package Siao.Command;

import Siao.Parser.Parser;
import Siao.management.Constants;
import Siao.management.PrintManager;
import Siao.task.Task;

import java.util.ArrayList;
import Siao.management.Storage;


public class MarkCommand {
    public static void markTask (String[] splitInput, ArrayList<Task> list, Storage storage) {
        int markIndex = Parser.parseTaskIndex(splitInput);
        
        if (list.isEmpty()) {
            throw new IllegalArgumentException("No item in the list, HOW TO MARK?");
        } else if (Integer.parseInt(splitInput[1]) > list.size()) {
            throw new IllegalArgumentException(Constants.MARK_WRONGLY);
        }
        list.get(markIndex).markDone();
        PrintManager.printMarkDone(list.get(markIndex));
        storage.saveAllTasks(list);
    }
}
