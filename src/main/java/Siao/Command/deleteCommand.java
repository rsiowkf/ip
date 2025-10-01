package Siao.Command;

import Siao.Parser.Parser;
import Siao.management.PrintManager;
import Siao.task.Task;

import java.util.ArrayList;

import Siao.management.Storage;

public class deleteCommand {
    public static void deleteTask(String[] splitInput, ArrayList<Task> list, Storage storage) {
        int deleteIndex = Parser.parseTaskIndex(splitInput);
        PrintManager.printDeletedTask(list, deleteIndex);
        storage.saveAllTasks(list);
    }
}
