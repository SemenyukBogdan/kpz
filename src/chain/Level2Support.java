package chain;

import java.util.Scanner;

public class Level2Support extends SupportHandler {
    public Level2Support() {
        super("Рівень 2 - Технічна підтримка");
    }

    @Override
    public boolean handleRequest(String userInput) {
        System.out.println("\n=== " + levelName + " ===");
        System.out.println("Чи ваша проблема стосується технічних питань або помилок у програмі? (так/ні)");
        
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("так")) {
            System.out.println("Відмінно! Ви звернулися до правильного рівня підтримки.");
            System.out.println("Наш технічний спеціаліст допоможе вирішити вашу проблему.");
            return true;
        } else {
            System.out.println("Це не наш рівень. Переводимо на наступний рівень...");
            if (nextHandler != null) {
                return nextHandler.handleRequest(userInput);
            }
        }
        return false;
    }
}
