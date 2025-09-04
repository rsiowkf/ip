public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) { // constructor of the task
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "X";
        }
        return " ";
    }

    public String getType() {
        return " ";
    }

    public String getDescription() {
        return description;
    }

    public void markDone(){
        isDone = true;
    }

    public void markUndone(){
        isDone = false;
    }

    public void printMarkDone() {
        System.out.println("Good job on completing the task!");
        System.out.printf("[%s] %s\n", getStatusIcon(), description);
        Siao.printDividerLine();
    }

    public void printMarkUndone() {
        System.out.println("Okay we haven't finished it yet!");
        System.out.printf("[%s] %s\n", getStatusIcon(), description);
        Siao.printDividerLine();
    }

    public static void printAddedTask(Task action){
        Siao.printDividerLine();
        System.out.printf("Nicely done! I've added this task:\n[ ][%s] %s\n", action.getStatusIcon(), action.getDescription());
        Siao.printDividerLine();
    }

}
