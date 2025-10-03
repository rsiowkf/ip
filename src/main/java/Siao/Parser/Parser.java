package Siao.Parser;

import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.task.Todo;

public class Parser {

    /**
     * takes reference to the saved tasks list, and reformats the task to help load the task into the list
     * @param line input is the saved task in the storage file
     * @return the format of each task to be placed into the list
     */
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
            String from = parts[3].trim().split("-")[0];
            String to = parts[3].trim().split("-")[1];
            String eventDesc = "event " + desc + "/from" + from + "/to" + to;
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

    public static int parseTaskIndex(String[] userInput) {

        int taskIndex;

        if (userInput.length < 2) {
            throw new IllegalArgumentException("Invalid task index");
        }

        try {
            taskIndex = Integer.parseInt(userInput[1]) - 1;
        } catch (NumberFormatException e) {
            return -1;
        }
        return taskIndex;
    }

    /**
     * Preprocesses the given user input by removing leading/trailing whitespace,
     * converting it to lowercase, and stripping out a specified keyword from the beginning.
     * <p>
     * The method assumes that the input string starts with the given keyword.
     * After removing the keyword, any surrounding whitespace is trimmed again.
     *
     * @param userInput the full input string provided by the user
     * @param keyword   the keyword to remove from the beginning of the input
     * @return the processed input string with the keyword removed, in lowercase and trimmed
     */
    public static String preProcessInput(String userInput, String keyword) {
        return userInput
                .trim()
                .toLowerCase()
                .substring(keyword.length())
                .trim();
    }
}
