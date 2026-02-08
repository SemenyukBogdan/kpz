package chain;

import java.util.Scanner;

public class Level4Support extends SupportHandler {
    public Level4Support() {
        super("Рівень 4 - Менеджерська підтримка");
    }

    @Override
    public boolean handleRequest(String userInput) {
        System.out.println("\n=== " + levelName + " ===");
        System.out.println("Чи ваша проблема стосується корпоративних питань або спеціальних запитів? (так/ні)");
        
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("так")) {
            System.out.println("Відмінно! Ви звернулися до правильного рівня підтримки.");
            System.out.println("Наш менеджер обробки запитів допоможе вам з вашим питанням.");
            return true;
        } else {
            System.out.println("На жаль, жоден з рівнів не підходить. Повертаємося до початку меню...");
            return false;
        }
    }
}
