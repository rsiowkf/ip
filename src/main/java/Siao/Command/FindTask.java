package Siao.Command;

import Siao.management.Constants;
import Siao.task.Task;

import java.util.ArrayList;

public class FindTask {
    public static void returnTask (String line, ArrayList<Task> list) {
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            throw new IllegalArgumentException(Constants.WRONG_FIND);
        }

        String keyword = parts[1];

        boolean found = false;

        for (Task task : list) {
            if (task.getDescription().contains(keyword)) {
                found = true;
                break;
            }
        }

        if (found) {
            int indexNumber = 1;
            System.out.printf(Constants.DIVIDER + "\n" + Constants.FOUND_ITEM + "\n");
            for (Task task : list) {
                if (task.getDescription().contains(keyword)) {
                    System.out.printf("%d. %s", indexNumber, task.toString());
                    indexNumber++;
                }
            }
            System.out.printf(Constants.DIVIDER + "\n");
        } else {
            throw new IllegalArgumentException(Constants.WRONG_FIND);
        }

    }
}
