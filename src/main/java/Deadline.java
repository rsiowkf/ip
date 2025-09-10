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

    public String toString() {
        return String.format("[%s][%s] %s (by: %s)\n",
                getType(), getStatusIcon(), this.description, this.by);
    }

    public String toList() {
        return String.format("[%s][%s] %s (by: %s)\n",
        getType(), getStatusIcon(), this.description, this.by);
    }

//    @Override
//    public static void printAddedTask(Deadline deadline) {
//        Siao.printDividerLine();
//        System.out.println("Got it. I've added this task!");
//        System.out.println(" " + deadline.toString());
//        Siao.printDividerLine();
//    }

}
