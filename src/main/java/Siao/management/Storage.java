package Siao.management;

import Siao.task.Deadline;
import Siao.task.Event;
import Siao.task.Task;
import Siao.Parser.Parser;

import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Storage {
    private final File storageFile;

    public Storage (String filePath) {
        this.storageFile = new File(filePath);
        ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            File parentDir = storageFile.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            if (!storageFile.exists()) {
                storageFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error creating storage file: " + e.getMessage());
        }
    }

    public void saveTask(Task task) {
        try {
            FileWriter writer = new FileWriter(storageFile, true);
            writer.write(savedTaskToString(task) + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating storage file: " + e.getMessage());
        }
    }

    public String savedTaskToString(Task task) {
        String type = task.getType();
        String desc = task.getDescription();
        String status = task.getStatusIcon().equals("X") ? "1" : "0";

        if (task instanceof Deadline) {
            String by = ((Deadline) task).by;
            return type + " | " + status + " | " + desc + " | " + by;
        }
        if (task instanceof Event) {
            String from = ((Event) task).from;
            String to = ((Event) task).to;
            return type + " | " + status + " | " + desc + " | " + from + " - " + to;
        } else {
            return type + " | " + status + " | " + desc;
        }
    }

    public void saveAllTasks(ArrayList<Task> tasks) {
        try {
            FileWriter writer = new FileWriter(storageFile, false);
            for (Task task : tasks) {
                writer.write(savedTaskToString(task) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadTasks(){
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            File file = new File(Constants.FILE_PATH);
            if (!file.exists()) {
                throw new FileNotFoundException(Constants.FILE_PATH + " not found");
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Parser.parseTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
            scanner.close();

        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        // open the savedtasks.txt file
        // read each line
        // convert each task into a todo, deadline or event
        // add it into the arraylist
    }

}
