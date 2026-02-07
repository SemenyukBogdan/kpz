package lab3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

// Завдання 4: Проксі

class SmartTextReader {
    public char[][] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("Файл " + filePath + " не знайдено");
        }

        java.util.List<String> lines = Files.readAllLines(Paths.get(filePath));
        char[][] result = new char[lines.size()][];

        for (int i = 0; i < lines.size(); i++) {
            result[i] = lines.get(i).toCharArray();
        }

        return result;
    }
}

class SmartTextChecker extends SmartTextReader {
    private SmartTextReader reader;

    public SmartTextChecker() {
        this.reader = new SmartTextReader();
    }

    @Override
    public char[][] readFile(String filePath) throws IOException {
        System.out.println("Відкриваю файл: " + filePath);
        
        char[][] result = reader.readFile(filePath);
        
        int totalLines = result.length;
        int totalChars = 0;
        for (char[] line : result) {
            totalChars += line.length;
        }

        System.out.println("Файл успішно прочитано");
        System.out.println("Кількість рядків: " + totalLines);
        System.out.println("Кількість символів: " + totalChars);
        System.out.println("Закриваю файл: " + filePath);

        return result;
    }
}

class SmartTextReaderLocker extends SmartTextReader {
    private SmartTextReader reader;
    private Pattern restrictedPattern;

    public SmartTextReaderLocker(String restrictedPattern) {
        this.reader = new SmartTextReader();
        this.restrictedPattern = Pattern.compile(restrictedPattern);
    }

    @Override
    public char[][] readFile(String filePath) throws IOException {
        if (restrictedPattern.matcher(filePath).find()) {
            System.out.println("Access denied!");
            return null;
        }

        return reader.readFile(filePath);
    }
}

class Task4 {
    public static void demonstrate() {
        try {
            String testFile = "test.txt";
            Files.write(Paths.get(testFile), 
                ("Перший рядок\nДругий рядок\nТретій рядок").getBytes());

            System.out.println("--- SmartTextChecker ---");
            SmartTextChecker checker = new SmartTextChecker();
            char[][] content = checker.readFile(testFile);
            System.out.println();

            System.out.println("--- SmartTextReaderLocker (дозволений файл) ---");
            SmartTextReaderLocker locker1 = new SmartTextReaderLocker("restricted.*");
            char[][] content2 = locker1.readFile(testFile);
            System.out.println();

            System.out.println("--- SmartTextReaderLocker (заблокований файл) ---");
            String restrictedFile = "restricted_file.txt";
            Files.write(Paths.get(restrictedFile), "Секретний вміст".getBytes());
            SmartTextReaderLocker locker2 = new SmartTextReaderLocker("restricted.*");
            locker2.readFile(restrictedFile);

            Files.deleteIfExists(Paths.get(testFile));
            Files.deleteIfExists(Paths.get(restrictedFile));
        } catch (IOException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
