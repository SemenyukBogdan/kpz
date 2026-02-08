package chain;

import java.util.Scanner;

public class SupportSystem {
    private SupportHandler chain;

    public SupportSystem() {
        Level1Support level1 = new Level1Support();
        Level2Support level2 = new Level2Support();
        Level3Support level3 = new Level3Support();
        Level4Support level4 = new Level4Support();

        level1.setNext(level2);
        level2.setNext(level3);
        level3.setNext(level4);

        this.chain = level1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n========================================");
            System.out.println("Ласкаво просимо до системи підтримки!");
            System.out.println("========================================");
            System.out.println("Введіть 'вихід' для завершення роботи.");
            System.out.println("Натисніть Enter для початку...");
            
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("вихід")) {
                System.out.println("Дякуємо за звернення! До побачення!");
                break;
            }

            boolean handled = chain.handleRequest(input);
            
            if (!handled) {
                System.out.println("\nМеню буде повторено...");
            } else {
                System.out.println("\nПроблема успішно вирішена!");
            }
        }
        
        scanner.close();
    }
}
