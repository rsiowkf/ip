import java.util.ArrayList;

public class Listmanager {
    public static void printList(ArrayList<Task> list) {
        Siao.printDividerLine();
        int indexNumber = 1;
        for (Task task : list) {
            System.out.printf("%d. [%s][%s] %s\n", indexNumber, task.getType(), task.getStatusIcon(), task.getDescription());
            indexNumber++;
        }
        if (list.isEmpty()) {
            System.out.println("-----------End Of List-----------");
        }
        Siao.printDividerLine();
    }
}
