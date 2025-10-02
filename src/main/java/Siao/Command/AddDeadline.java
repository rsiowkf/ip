package Siao.Command;

import Siao.management.Constants;
import Siao.management.PrintManager;
import Siao.management.Storage;
import Siao.task.Deadline;
import Siao.task.Task;

import java.util.ArrayList;

public class AddDeadline {
    public static void newDeadline(ArrayList<Task> list, String line, Storage storage){
        if (!isDeadlineKeyed(line)) {
            throw new IllegalArgumentException(Constants.ILLEGAL_DEADLINE_MESSAGE);
        }

        Deadline newDeadline = new Deadline(line);
        list.add(newDeadline);
        PrintManager.printAddedTask(newDeadline);
        storage.saveTask(newDeadline);
    }

    private static boolean isDeadlineKeyed(String description){
        return description.contains("/by");
    }
}
