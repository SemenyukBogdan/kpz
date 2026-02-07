package lab3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Завдання 1: Адаптер

class Logger {
    public void log(String message) {
        System.out.println("\u001B[32m[LOG] " + message + "\u001B[0m");
    }

    public void error(String message) {
        System.out.println("\u001B[31m[ERROR] " + message + "\u001B[0m");
    }

    public void warn(String message) {
        System.out.println("\u001B[33m[WARN] " + message + "\u001B[0m");
    }
}

class CustomFileWriter {
    private String filePath;

    public CustomFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void write(String text) throws IOException {
        java.io.FileWriter writer = new java.io.FileWriter(filePath, true);
        writer.write(text);
        writer.close();
    }

    public void writeLine(String text) throws IOException {
        java.io.FileWriter writer = new java.io.FileWriter(filePath, true);
        writer.write(text + System.lineSeparator());
        writer.close();
    }
}

class FileLogger extends Logger {
    private CustomFileWriter fileWriter;

    public FileLogger(String filePath) {
        this.fileWriter = new CustomFileWriter(filePath);
    }

    @Override
    public void log(String message) {
        try {
            fileWriter.writeLine("[LOG] " + message);
        } catch (IOException e) {
            System.err.println("Помилка запису в файл: " + e.getMessage());
        }
    }

    @Override
    public void error(String message) {
        try {
            fileWriter.writeLine("[ERROR] " + message);
        } catch (IOException e) {
            System.err.println("Помилка запису в файл: " + e.getMessage());
        }
    }

    @Override
    public void warn(String message) {
        try {
            fileWriter.writeLine("[WARN] " + message);
        } catch (IOException e) {
            System.err.println("Помилка запису в файл: " + e.getMessage());
        }
    }
}

class Task1 {
    public static void demonstrate() {
        Logger consoleLogger = new Logger();
        consoleLogger.log("Це звичайне повідомлення");
        consoleLogger.warn("Це попередження");
        consoleLogger.error("Це помилка");

        String logFile = "log.txt";
        File file = new File(logFile);
        if (file.exists()) {
            file.delete();
        }

        FileLogger fileLogger = new FileLogger(logFile);
        fileLogger.log("Повідомлення у файл");
        fileLogger.warn("Попередження у файл");
        fileLogger.error("Помилка у файл");

        try {
            System.out.println("\nЛоги записані у файл " + logFile + ":");
            String content = new String(Files.readAllBytes(Paths.get(logFile)));
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}
