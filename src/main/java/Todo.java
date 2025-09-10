public class Todo extends Task{
    public Todo(String description) {
        super(parseDescription(description));
    }

    private static String parseDescription(String userInput) {
        String raw = userInput.trim();
        raw = raw.toLowerCase();
        raw = raw.substring("todo".length()).trim();
        return raw;
    }

    public String getType(){
        return "T";
    }
}
