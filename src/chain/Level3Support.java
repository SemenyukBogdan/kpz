package chain;

import java.util.Scanner;

public class Level3Support extends SupportHandler {
    public Level3Support() {
        super("Рівень 3 - Фінансова підтримка");
    }

    @Override
    public boolean handleRequest(String userInput) {
        System.out.println("\n=== " + levelName + " ===");
        System.out.println("Чи ваша проблема стосується оплати, рахунків або тарифів? (так/ні)");
        
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("так")) {
            System.out.println("Відмінно! Ви звернулися до правильного рівня підтримки.");
            System.out.println("Наш фінансовий консультант допоможе вам з усіма питаннями оплати.");
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
