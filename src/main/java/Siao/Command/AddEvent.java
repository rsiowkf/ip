package Siao.Command;

import Siao.management.Constants;
import Siao.management.PrintManager;
import Siao.management.Storage;
import Siao.task.Event;
import Siao.task.Task;

import java.util.ArrayList;

public class AddEvent {
    public static void newEvent(ArrayList<Task> list, String line, Storage storage){
        if (!isFromKeyed(line)) {
            throw new IllegalArgumentException(Constants.ILLEGAL_START_MESSAGE);
        } else if (!isToKeyed(line)) {
            throw new IllegalArgumentException(Constants.ILLEGAL_END_MESSAGE);
        }

        Event newEvent = new Event(line);
        list.add(newEvent);
        PrintManager.printAddedTask(newEvent);
        storage.saveTask(newEvent);
    }

    public static boolean isFromKeyed(String line){
        return line.contains("/from");
    }

    public static boolean isToKeyed(String line){
        return line.contains("/to");
    }


}
