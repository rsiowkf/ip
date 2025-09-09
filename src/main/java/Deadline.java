public class Deadline extends Task{
    private final String by;

    public Deadline(String description) {
        super(parseDescription(description));
        this.by = parseBy(description);
    }

    private static String parseDescription(String userInput) {
        String raw = userInput.trim(); // removes any trailing spaces
        raw = raw.toLowerCase(); // brings the input to all lower case
        raw = raw.substring("deadline".length()).trim(); // removes the "deadline" text
        String[] parts =  raw.split("/by",2); // splits the string into parts before and after the /by
        return parts[0].trim();
    }

    private static String parseBy(String userInput) {
        String raw = userInput.trim();
        raw = raw.substring("by".length()).trim();
        String[] parts =  raw.split("/by",2);
        if (parts.length < 1) {
            return "";
        }
        return parts[1].trim();
    }

    @Override
    public String getType() {
        return "D";
    }

    public String getDeadline() {
        String[] parts = this.description.split("/by", 2);
        return parts[1];
    }

    public String getDeadlineDescription() {
        String[] parts = this.description.split("/", 2);
        return parts[0];
    }

    @Override
    public void printAddedTask() {
        Siao.printDividerLine();
        System.out.printf("Nicely done! I've added this task:\n[%s][%s] %s (by: %s)\n",
                getType(), getStatusIcon(), this.description, this.by);

    }

}
