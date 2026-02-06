package task2;

public class IProneFactory implements DeviceFactory {
    // всі методи створюють пристрої з брендом IProne
    @Override
    public Laptop createLaptop() {
        return new Laptop("IProne");
    }

    @Override
    public Netbook createNetbook() {
        return new Netbook("IProne");
    }

    @Override
    public EBook createEBook() {
        return new EBook("IProne");
    }

    @Override
    public Smartphone createSmartphone() {
        return new Smartphone("IProne");
    }
}
