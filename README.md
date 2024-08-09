# Simple File Manager Application

This is a simple file manager application built in Java. It provides a command-line interface (CLI) to perform basic file and directory operations such as displaying directory contents, copying, moving, and deleting files, as well as creating and deleting directories. It also allows users to search for files based on their names or extensions.

## Features

- **Display Directory Contents**: List all files and directories in a specified directory, along with their sizes and last modified dates.
- **File Operations**: Copy, move, and delete files within the specified directory.
- **Directory Management**: Create and delete directories.
- **File Search**: Search for files within a directory based on file names or extensions.
- **User Interface**: Simple command-line interface to interact with the application.
- **Exception Handling**: Proper exception handling with error messages.

## Project Structure

```plaintext
file-manager/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── filemanager/
│   │   │   │       ├── DirectoryManager.java
│   │   │   │       ├── FileManager.java
│   │   │   │       ├── FileOperations.java
│   │   │   │       ├── FileSearch.java
│   │   │   │       └── Main.java
│   └── resources/
│
│
├── docs/
│   └── README.md
│
└── pom.xml (if using Maven)
