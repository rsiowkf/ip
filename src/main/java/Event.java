public class Event extends Task {
    private final String from;
    private final String to;

    public Event(String description) {
        super(parseDescription(description));
        this.from = parseFrom(description);
        this.to = parseTo(description);
    }

    private static String parseDescription(String userInput) {
        String raw = userInput.trim();
        raw = raw.toLowerCase();
        raw = raw.substring("event".length()).trim();
        String[] parts = raw.split("/from", 2);
        if(parts[0].isEmpty()) {
            throw new IllegalArgumentException(Constants.ILLEGAL_ARGUMENT_MESSAGE);
        }

        return parts[0].trim();
    }

    private static String parseFrom(String userInput) {
        if (!userInput.contains("/from")) {
            throw new IllegalArgumentException(Constants.ILLEGAL_START_MESSAGE);
        }

        String[] parts = userInput.split("/from", 2);
        String[] subParts = parts[1].split("/to", 2);
        return subParts[0].trim();
    }

    private static String parseTo(String userInput) {
        if (!userInput.contains("/to")) {
            throw new IllegalArgumentException(Constants.ILLEGAL_END_MESSAGE);
        }

        String[] parts = userInput.split("/to", 2);
        return parts[1].trim();
    }

    @Override
    public String getType() {
        return "E";
    }

    public String toString() {
        return String.format("[%s][%s] %s (from: %s to: %s)\n",
                getType(), getStatusIcon(), this.description, this.from, this.to);
    }
}
