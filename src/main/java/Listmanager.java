import java.util.ArrayList;

public class Listmanager {
    public static void printList(ArrayList<Task> list) {
        Siao.printDividerLine();
        int indexNumber = 1;
        for (Task task : list) {
            System.out.printf("%d. %s",indexNumber, task.toString());
            indexNumber++;
        }
        if (list.isEmpty()) {
            System.out.println(Constants.END_OF_LIST);
        }
        Siao.printDividerLine();
    }

    public static void printAddedTask(Task task) {
        Siao.printDividerLine();
        System.out.println("Got it. I've added this task!");
        System.out.print("   " + task.toString());
        System.out.print(task.printNumberOfTasks());
        Siao.printDividerLine();
    }

    public static void printErrorMessage() {
        Siao.printDividerLine();
        System.out.println(Constants.ERROR_MESSAGE);
        Siao.printDividerLine();
    }
}
