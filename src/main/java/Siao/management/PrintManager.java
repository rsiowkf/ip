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

    public static void printDeletedTask(ArrayList<Task> list, int taskIndex) {
        if (list.isEmpty()) {
            System.out.println(Constants.EMPTY_LIST);
        } else {
            printDividerLine();
            System.out.println("Got it. I've deleted this task!");
            System.out.printf("  " + list.get(taskIndex).toString());
            list.get(taskIndex).reduceCounter();
            System.out.print(list.get(taskIndex).printNumberOfTasks());
            printDividerLine();
            list.remove(taskIndex);
        }
    }

    public static void printMarkDone(Task task) {
        System.out.println("Good job on completing the task!");
        System.out.print("  ");
        System.out.printf(task.toString());
        PrintManager.printDividerLine();
    }

    public static void  printDividerLine(){
        System.out.println(Constants.DIVIDER);
    }

}
