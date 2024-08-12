package com.filemanager;

import java.io.IOException;
import java.nio.file.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FileSearch {

    /**
     * Searches for files within a specified directory based on a given pattern.
     *
     * @param directory    The directory to search within.
     * @param searchPattern The search pattern (e.g., "*.txt").
     */
    public void searchFiles(Path directory, String searchPattern) {
        Pattern pattern = Pattern.compile(searchPattern);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path entry : stream) {
                Matcher matcher = pattern.matcher(entry.getFileName().toString());
                if (matcher.matches()) {
                    // Print out matching file names
                    System.out.println("Found: " + entry.getFileName());
                }
            }
        } catch (IOException e) {
            System.err.println("Error searching files: " + e.getMessage());
        }
    }
}
