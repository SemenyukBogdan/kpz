import task1.*;
import task2.*;
import task3.*;
import task4.*;
import task5.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ЛАБОРАТОРНА РОБОТА №2: ПОРОДЖУВАЛЬНІ ШАБЛОНИ ===\n");

        // Завдання 1: Фабричний метод
        System.out.println("--- ЗАВДАННЯ 1: ФАБРИЧНИЙ МЕТОД ---");
        SubscriptionCreator website = new WebSite();
        Subscription sub1 = website.purchaseSubscription();
        sub1.displayInfo();
        System.out.println();

        SubscriptionCreator mobileApp = new MobileApp();
        Subscription sub2 = mobileApp.purchaseSubscription();
        sub2.displayInfo();
        System.out.println();

        SubscriptionCreator managerCall = new ManagerCall();
        Subscription sub3 = managerCall.purchaseSubscription();
        sub3.displayInfo();
        System.out.println("\n");

        // Завдання 2: Абстрактна фабрика
        System.out.println("--- ЗАВДАННЯ 2: АБСТРАКТНА ФАБРИКА ---");
        DeviceFactory iproneFactory = new IProneFactory();
        System.out.println("Створення техніки IProne:");
        iproneFactory.createLaptop().showInfo();
        iproneFactory.createSmartphone().showInfo();
        iproneFactory.createEBook().showInfo();
        System.out.println();

        DeviceFactory kiaomiFactory = new KiaomiFactory();
        System.out.println("Створення техніки Kiaomi:");
        kiaomiFactory.createLaptop().showInfo();
        kiaomiFactory.createNetbook().showInfo();
        kiaomiFactory.createSmartphone().showInfo();
        System.out.println();

        DeviceFactory balaxyFactory = new BalaxyFactory();
        System.out.println("Створення техніки Balaxy:");
        balaxyFactory.createLaptop().showInfo();
        balaxyFactory.createSmartphone().showInfo();
        balaxyFactory.createEBook().showInfo();
        System.out.println("\n");

        // Завдання 3: Одинак
        System.out.println("--- ЗАВДАННЯ 3: ОДИНАК ---");
        Authenticator auth1 = Authenticator.getInstance();
        auth1.login("user123");
        System.out.println("Поточний користувач: " + auth1.getCurrentUser());
        System.out.println("Автентифіковано: " + auth1.isAuthenticated());
        
        Authenticator auth2 = Authenticator.getInstance();
        // Authenticator auth3 = new Authenticator(); // не можна - конструктор приватний
        System.out.println("Спроба отримати інший екземпляр...");
        System.out.println("Це той самий екземпляр? " + (auth1 == auth2));
        System.out.println("Поточний користувач через auth2: " + auth2.getCurrentUser());
        
        auth1.logout();
        System.out.println("\n");

        // Завдання 4: Прототип
        System.out.println("--- ЗАВДАННЯ 4: ПРОТОТИП ---");
        // Створюємо перше покоління
        Virus parentVirus = new Virus(0.1, 5, "COVID-19", "Коронавірус");
        
        // Створюємо друге покоління
        Virus child1 = new Virus(0.08, 3, "COVID-19 Alpha", "Коронавірус");
        Virus child2 = new Virus(0.09, 4, "COVID-19 Beta", "Коронавірус");
        parentVirus.addChild(child1);
        parentVirus.addChild(child2);
        
        // Створюємо третє покоління
        Virus grandchild1 = new Virus(0.07, 2, "COVID-19 Gamma", "Коронавірус");
        Virus grandchild2 = new Virus(0.075, 2, "COVID-19 Delta", "Коронавірус");
        child1.addChild(grandchild1);
        child2.addChild(grandchild2);
        
        System.out.println("Оригінальне сімейство вірусів:");
        parentVirus.displayInfo(0);
        System.out.println();
        
        System.out.println("Клоноване сімейство вірусів:");
        Virus clonedVirus = parentVirus.clone();
        clonedVirus.displayInfo(0);
        System.out.println("Це різні об'єкти? " + (parentVirus != clonedVirus));
        System.out.println("\n");

        // Завдання 5: Будівельник
        System.out.println("--- ЗАВДАННЯ 5: БУДІВЕЛЬНИК ---");
        Director director = new Director();
        HeroBuilder heroBuilder = new HeroBuilder();
        EnemyBuilder enemyBuilder = new EnemyBuilder();
        
        task5.Character hero = director.createDreamHero(heroBuilder);
        task5.Character enemy = director.createFierceEnemy(enemyBuilder);
        
        hero.displayInfo();
        enemy.displayInfo();
        
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВЕРШЕНА ===");
    }
}
