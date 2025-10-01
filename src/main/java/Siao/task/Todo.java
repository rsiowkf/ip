package Siao.task;

import Siao.Parser.Parser;

public class Todo extends Task {
    public Todo(String description) {
        super(parseDescription(description));
    }

    private static String parseDescription(String userInput) {
        String raw = Parser.preprocessInput(userInput, "todo");
        if (raw.isEmpty()) {
            throw new IllegalArgumentException("☹ OOPS!!! The description of a TODO cannot be empty.");
        }
        return raw;
    }

    public String getType(){
        return "T";
    }
}
