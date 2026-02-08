package chain;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        System.out.println("=== Демонстрація системи підтримки користувачів ===");
        System.out.println("\nСтруктура системи:");
        System.out.println("1. Рівень 1 - Базова підтримка (налаштування облікового запису)");
        System.out.println("2. Рівень 2 - Технічна підтримка (технічні питання та помилки)");
        System.out.println("3. Рівень 3 - Фінансова підтримка (оплата, рахунки, тарифи)");
        System.out.println("4. Рівень 4 - Менеджерська підтримка (корпоративні питання)");
        
        System.out.println("\n=== Демонстрація ланцюжка обробників ===");
        
        Level1Support level1 = new Level1Support();
        Level2Support level2 = new Level2Support();
        Level3Support level3 = new Level3Support();
        Level4Support level4 = new Level4Support();

        level1.setNext(level2);
        level2.setNext(level3);
        level3.setNext(level4);

        System.out.println("\nЛанцюжок створено: Level1 -> Level2 -> Level3 -> Level4");
        System.out.println("\nСистема готова до роботи!");
        System.out.println("\nДля інтерактивного тестування запустіть:");
        System.out.println("java -cp out chain.InteractiveSupportDemo");
        System.out.println("\nАбо використовуйте метод start() класу SupportSystem");
    }
}
