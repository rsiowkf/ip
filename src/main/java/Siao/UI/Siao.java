package Siao.UI;
import Siao.Command.CommandHandler;
import Siao.management.Constants;
import Siao.task.Task;
import Siao.management.Storage;


import java.util.Scanner;
import java.util.ArrayList;

public class Siao {

    public static void main(String[] args) {
        System.out.print(Constants.WELCOME_MESSAGE);

        Storage storage = new Storage("data/SavedTasks.txt");
        CommandHandler.setStorage(storage);

        Scanner input = new Scanner(System.in);
        ArrayList<Task> list = storage.loadTasks();
        String line = input.nextLine();
        String command = line.split(" ")[0];

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
