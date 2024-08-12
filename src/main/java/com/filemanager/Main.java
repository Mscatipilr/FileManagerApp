package com.filemanager;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectoryManager directoryManager = new DirectoryManager();
        FileOperations fileOperations = new FileOperations();
        FileSearch fileSearch = new FileSearch();

        // Main loop to display options and perform actions
        while (true) {
            System.out.println("\nFile Manager");
            System.out.println("1. Display Directory Contents");
            System.out.println("2. Copy File");
            System.out.println("3. Move File");
            System.out.println("4. Delete File");
            System.out.println("5. Create Directory");
            System.out.println("6. Delete Directory");
            System.out.println("7. Search Files");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Display directory contents
                    System.out.print("Enter directory path: ");
                    String dirPath = scanner.nextLine();
                    directoryManager.listContents(dirPath);
                    break;
                case 2:
                    // Copy a file
                    System.out.print("Enter source file path: ");
                    String sourcePath = scanner.nextLine();
                    System.out.print("Enter destination file path: ");
                    String destPath = scanner.nextLine();
                    fileOperations.copyFile(Paths.get(sourcePath), Paths.get(destPath));
                    break;
                case 3:
                    // Move a file
                    System.out.print("Enter source file path: ");
                    String srcPath = scanner.nextLine();
                    System.out.print("Enter destination file path: ");
                    String destinationPath = scanner.nextLine();
                    fileOperations.moveFile(Paths.get(srcPath), Paths.get(destinationPath));
                    break;
                case 4:
                    // Delete a file
                    System.out.print("Enter file path to delete: ");
                    String deletePath = scanner.nextLine();
                    fileOperations.deleteFile(Paths.get(deletePath));
                    break;
                case 5:
                    // Create a new directory
                    System.out.print("Enter directory path to create: ");
                    String createDirPath = scanner.nextLine();
                    directoryManager.createDirectory(Paths.get(createDirPath));
                    break;
                case 6:
                    // Delete an existing directory
                    System.out.print("Enter directory path to delete: ");
                    String deleteDirPath = scanner.nextLine();
                    directoryManager.deleteDirectory(Paths.get(deleteDirPath));
                    break;
                case 7:
                    // Search for files in a directory
                    System.out.print("Enter directory path to search in: ");
                    String searchDirPath = scanner.nextLine();
                    System.out.print("Enter search pattern (e.g., *.txt): ");
                    String searchPattern = scanner.nextLine();
                    fileSearch.searchFiles(Paths.get(searchDirPath), searchPattern);
                    break;
                case 8:
                    // Exit the application
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
