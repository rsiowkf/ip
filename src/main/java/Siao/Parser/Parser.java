package Siao.Parser;

import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.task.Todo;

public class Parser {
    public Task parseTask(String line) {
        String[] parts =  line.split("\\|");
        String type = parts[0];
        int isDone =  Integer.parseInt(parts[1]);
        String desc = parts[2];

        Task task;

        switch (type) {
        case "T":
            task = new Todo(desc);
            if (isDone == 1) {
                task.markDone();
            }
            break;
        case "D":
            String deadlineDesc = parts[2] + "/by" + parts[3];
            task = new Deadline(deadlineDesc);
            if (isDone == 1) {
                task.markDone();
            }
            break;
        case "E":
            String eventDesc = parts[2] + "/from" + parts[3] + "/to" + parts[4];
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
