public class Task {
    protected String description;
    protected boolean isDone;
    private static int taskCounter;

    public Task(String description) { // constructor of the task
        this.description = description;
        this.isDone = false;
        taskCounter++;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "X";
        }
        return " ";
    }

    public String getDeadline() {
        return "";
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
        System.out.printf(toList());
        Siao.printDividerLine();
    }

    public void printMarkUndone() {
        System.out.println("DO YOUR JOBBBBBBBBBBBBBBB!");
        System.out.printf(toList());
        Siao.printDividerLine();
    }

    public String toString() {
        if (taskCounter == 1) {
            return String.format("[%s][%s] %s\n",
                    getType(), getStatusIcon(), this.description);
        }
        return String.format("[%s][%s] %s\n",
                getType(), getStatusIcon(), this.description);
    }

    public String printNumberOfTasks() {
        return String.format("Now you have %d task(s) in the list\n",  taskCounter);
    }

    public String toList() {
        return String.format("[%s][%s] %s\n",
                getType(), getStatusIcon(), this.description);
    }

    public static void printAddedTask(Task task) {
        Siao.printDividerLine();
        System.out.println("Got it. I've added this task!");
        System.out.print("   " + task.toString());
        System.out.print(task.printNumberOfTasks());
        Siao.printDividerLine();
    }
}
