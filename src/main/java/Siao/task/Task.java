package Siao.task;
import Siao.UI.Siao;
import Siao.management.PrintManager;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    private static int taskCounter;

    public Task(String description) { // constructor of the task
        this.description = description;
        this.isDone = false;
        taskCounter++;
    }

    public void reduceCounter() {
        taskCounter--;
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

    /**
     * Returns a formatted string representation of the task,
     * including type, status, and description.
     *
     * @return the string representation of the task
     */
    public String toString() {
        return String.format("[%s][%s] %s\n",
                getType(), getStatusIcon(), this.description);
    }

}
