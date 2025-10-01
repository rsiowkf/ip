package Siao.Command;

import Siao.management.PrintManager;
import Siao.management.Storage;
import Siao.task.Deadline;
import Siao.task.Task;

import java.util.ArrayList;

public class AddDeadline {
    public static void newDeadline(ArrayList<Task> list, String line, Storage storage){
        Deadline newDeadline = new Deadline(line);
        list.add(newDeadline);
        PrintManager.printAddedTask(newDeadline);
        storage.saveTask(newDeadline);
    }
}
