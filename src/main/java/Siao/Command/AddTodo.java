package Siao.Command;

import Siao.management.PrintManager;
import Siao.management.Storage;
import Siao.task.Task;
import Siao.task.Todo;

import java.util.ArrayList;

public class AddTodo {
    public static void newTodo(ArrayList<Task> list, String line, Storage storage){
        Todo newTodo = new Todo(line);
        list.add(newTodo);
        PrintManager.printAddedTask(newTodo);
        storage.saveTask(newTodo);
    }
}
