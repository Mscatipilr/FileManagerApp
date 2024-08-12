package com.filemanager;

import java.io.IOException;
import java.nio.file.*;

public class FileOperations {

    /**
     * Copies a file from the source path to the destination path.
     *
     * @param source      The source file path.
     * @param destination The destination file path.
     */
    public void copyFile(Path source, Path destination) {
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied to: " + destination);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    /**
     * Moves a file from the source path to the destination path.
     *
     * @param source      The source file path.
     * @param destination The destination file path.
     */
    public void moveFile(Path source, Path destination) {
        try {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved to: " + destination);
        } catch (IOException e) {
            System.err.println("Error moving file: " + e.getMessage());
        }
    }

    /**
     * Deletes a file at the specified path.
     *
     * @param path The path of the file to delete.
     */
    public void deleteFile(Path path) {
        try {
            Files.delete(path);
            System.out.println("File deleted: " + path);
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }
}
