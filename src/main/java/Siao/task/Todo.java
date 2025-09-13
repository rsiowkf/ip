package Siao.task;

public class Todo extends Task {
    public Todo(String description) {
        super(parseDescription(description));
    }

    private static String parseDescription(String userInput) {
        String raw = userInput.trim();
        raw = raw.substring("todo".length()).trim();
        if (raw.isEmpty()) {
            throw new IllegalArgumentException("☹ OOPS!!! The description of a TODO cannot be empty.");
        }
        return raw;
    }

    public String getType(){
        return "T";
    }
}
