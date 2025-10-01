package Siao.Command;

import Siao.Parser.Parser;
import Siao.management.PrintManager;
import Siao.task.Task;

import java.util.ArrayList;

import Siao.management.Storage;

public class DeleteCommand {
    public static void deleteTask(String[] splitInput, ArrayList<Task> list, Storage storage) {
        if (Integer.parseInt(splitInput[1]) > list.size()) {
            throw new IllegalArgumentException("Invalid task index, delete something else");
        }

        int deleteIndex = Parser.parseTaskIndex(splitInput);
        PrintManager.printDeletedTask(list, deleteIndex);
        storage.saveAllTasks(list);
    }
}
