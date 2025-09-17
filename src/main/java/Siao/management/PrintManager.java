package Siao.management;

import Siao.UI.Siao;
import Siao.task.Task;

import java.util.ArrayList;

public class PrintManager {
    public static void printList(ArrayList<Task> list) {
        if (list.isEmpty()) {
            System.out.println(Constants.EMPTY_LIST);
            return;
        }

        printDividerLine();
        int indexNumber = 1;
        for (Task task : list) {
            System.out.printf("%d. %s",indexNumber, task.toString());
            indexNumber++;
        }
        if (list.isEmpty()) {
            System.out.println(Constants.END_OF_LIST);
        }
        printDividerLine();
    }

    public static void printAddedTask(Task task) {
        printDividerLine();
        System.out.println("Got it. I've added this task!");
        System.out.print("   " + task.toString());
        System.out.print(task.printNumberOfTasks());
        printDividerLine();
    }

    public static void printErrorEmptyMessage() {
        printDividerLine();
        System.out.println(Constants.EMPTY_ERROR_MESSAGE);
        printDividerLine();
    }

    public static void printIllegalMessage() {
        printDividerLine();
        System.out.println(Constants.ILLEGAL_MESSAGE);
        printDividerLine();
    }

    public static void printDeletedTask(Task task) {
        printDividerLine();
        System.out.println("Got it. I've deleted this task!");
        System.out.printf("  " +   task.toString());
        System.out.print(task.printNumberOfTasks());
        printDividerLine();
    }

    public static void  printDividerLine(){
        System.out.println(Constants.DIVIDER);
    }

}
