package Siao.UI;
import Siao.management.CommandHandler;
import Siao.management.Constants;
import Siao.management.PrintManager;
import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.task.Todo;

import java.util.Scanner;
import java.util.ArrayList;

public class Siao {

    public static void main(String[] args) {
        System.out.print(Constants.WELCOME_MESSAGE);

        Scanner input = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        String line = input.nextLine();

        while(!line.equalsIgnoreCase("bye")){

            try {
                CommandHandler.handleCommand(line, list);
                line = input.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print(">>>   ");
                line = input.nextLine();
            }
        }

        System.out.println(Constants.DIVIDER);
        System.out.println(Constants.GOODBYE_MESSAGE);
    }
}
