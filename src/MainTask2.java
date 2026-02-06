import task2.*;

public class MainTask2 {
    public static void main(String[] args) {
        System.out.println("=== ЗАВДАННЯ 2: АБСТРАКТНА ФАБРИКА ===\n");

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
        
    }
}
