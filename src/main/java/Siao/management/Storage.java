package Siao.management;

import Siao.task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;


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
            FileWriter writer = new FileWriter(storageFile);
            writer.write(task.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating storage file: " + e.getMessage());
        }
    }

    public void savedTaskToString(Task task) {
        String type = task.getType();
        String desc = task.getDescription();
        String status = task.getStatusIcon();
    }

}
