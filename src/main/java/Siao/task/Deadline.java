package Siao.task;

import Siao.management.CommandHandler;
import Siao.management.Constants;

public class Deadline extends Task {
    private final String by;

    public Deadline(String description) {
        super(parseDescription(description));
        this.by = parseBy(description);
    }

    private static String parseDescription(String userInput) {
        String raw = CommandHandler.preprocessInput(userInput, "deadline");
        String[] parts = raw.split(" ");

        if (parts[0].isEmpty()) {
            throw new IllegalArgumentException(Constants.ILLEGAL_ARGUMENT_MESSAGE);
        }

        return parts[0].trim();
    }

    public static String parseBy(String userInput) {
        if (!userInput.contains("/by")) {
            throw new IllegalArgumentException(Constants.ILLEGAL_DEADLINE_MESSAGE);
        }
        String raw = CommandHandler.preprocessInput(userInput, "by");
        String[] parts =  raw.split("/by",2);

        return parts[1].trim();
    }

    @Override
    public String getType() {
        return "D";
    }

    public String toString() {
        return String.format("[%s][%s] %s (by: %s)\n",
                getType(), getStatusIcon(), this.description, this.by);
    }
}
