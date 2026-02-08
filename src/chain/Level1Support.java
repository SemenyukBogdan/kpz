package chain;

import java.util.Scanner;

public class Level1Support extends SupportHandler {
    public Level1Support() {
        super("Рівень 1 - Базова підтримка");
    }

    @Override
    public boolean handleRequest(String userInput) {
        System.out.println("\n=== " + levelName + " ===");
        System.out.println("Чи ваша проблема стосується налаштування облікового запису? (так/ні)");
        
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("так")) {
            System.out.println("Відмінно! Ви звернулися до правильного рівня підтримки.");
            System.out.println("Наш спеціаліст допоможе вам з налаштуванням облікового запису.");
            return true;
        } else {
            System.out.println("Це не наш рівень. Переводимо на наступний рівень...");
            // передаємо далі по ланцюжку
            if (nextHandler != null) {
                return nextHandler.handleRequest(userInput);
            }
        }
        return false;
    }
}
