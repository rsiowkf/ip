package Siao.Command;

import Siao.management.PrintManager;
import Siao.management.Storage;
import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;

import java.util.ArrayList;

public class addEvent {
    public static void newEvent(ArrayList<Task> list, String line, Storage storage){
        Event newEvent = new Event(line);
        list.add(newEvent);
        PrintManager.printAddedTask(newEvent);
        storage.saveTask(newEvent);
    }
}
