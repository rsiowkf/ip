package Siao.Parser;

import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.task.Todo;

public class Parser {
    public static Task parseTaskFromStorage(String line) {
        String[] parts =  line.split("\\|");
        String type = parts[0].trim();
        int isDone =  Integer.parseInt(parts[1].trim());
        String desc = parts[2].trim();

        Task task;

        switch (type) {
        case "T":
            String todoDescription = "todo " + desc;
            task = new Todo(todoDescription);
            if (isDone == 1) {
                task.markDone();
            }
            break;
        case "D":
            String deadlineDesc = "deadline " + desc + " /by" + parts[3];
            task = new Deadline(deadlineDesc);
            if (isDone == 1) {
                task.markDone();
            }
            break;
        case "E":
            String eventDesc = "event " + desc + "/from" + parts[3] + "/to" + parts[4];
            task = new Event(eventDesc);
            if (isDone == 1) {
                task.markDone();
            }
            break;
        default:
            return null;
        }
        if (isDone == 1) {
            task.markDone();
        }
        return task;
    }
}
