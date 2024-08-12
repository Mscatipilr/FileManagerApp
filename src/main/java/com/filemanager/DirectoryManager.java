package com.filemanager;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirectoryManager {

    /**
     * Lists the contents of a specified directory, including file names,
     * file sizes, and last modified dates.
     *
     * @param directoryPath The path of the directory to list.
     */
    public void listContents(String directoryPath) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            for (Path entry : stream) {
                BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                String size = attrs.isDirectory() ? "<DIR>" : attrs.size() + " bytes";
                String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(attrs.lastModifiedTime().toMillis()));

                // Display the file/directory name, size, and last modified date
                System.out.printf("%-30s %-15s %-20s%n", entry.getFileName(), size, lastModified);
            }
        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }

    /**
     * Creates a new directory at the specified path.
     *
     * @param path The path where the new directory will be created.
     */
    public void createDirectory(Path path) {
        try {
            Files.createDirectory(path);
            System.out.println("Directory created: " + path);
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
        }
    }

    /**
     * Deletes a directory at the specified path.
     *
     * @param path The path of the directory to delete.
     */
    public void deleteDirectory(Path path) {
        try {
            Files.delete(path);
            System.out.println("Directory deleted: " + path);
        } catch (IOException e) {
            System.err.println("Error deleting directory: " + e.getMessage());
        }
    }
}
