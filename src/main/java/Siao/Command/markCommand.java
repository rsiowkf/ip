package Siao.Command;

import Siao.Parser.Parser;
import Siao.task.Task;

import java.util.ArrayList;
import Siao.management.Storage;


public class markCommand {
    public static void markTask (String[] splitInput, ArrayList<Task> list, Storage storage) {
        int markIndex = Parser.parseTaskIndex(splitInput);
        if (list.isEmpty()) {
            throw new IllegalArgumentException("No item in the list, HOW TO MARK?");
        }
        list.get(markIndex).markDone();
        list.get(markIndex).printMarkDone();
        storage.saveAllTasks(list);
    }
}
