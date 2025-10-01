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

    public void printMarkDone() {
        System.out.println("Good job on completing the task!");
        System.out.printf(toString());
        PrintManager.printDividerLine();
    }

    public void printMarkUndone() {
        System.out.println("DO YOUR JOBBBBBBBBBBBBBBB!");
        System.out.printf(toString());
        PrintManager.printDividerLine();
    }

    public String toString() {
        return String.format("[%s][%s] %s\n",
                getType(), getStatusIcon(), this.description);
    }

    public String printNumberOfTasks() {
        return String.format("Now you have %d task(s) in the list\n",  taskCounter);
    }
}
