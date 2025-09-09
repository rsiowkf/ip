import java.util.ArrayList;

public class Listmanager {
    public static void printList(ArrayList<Task> list) {
        Siao.printDividerLine();
        int indexNumber = 1;
        for (Task task : list) {
            System.out.printf("%d. %s",indexNumber, task.toList());
            indexNumber++;
        }
        if (list.isEmpty()) {
            System.out.println(Constants.END_OF_LIST);
        }
        Siao.printDividerLine();
    }
}
