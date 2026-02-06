package task2;

public class BalaxyFactory implements DeviceFactory {
    @Override
    public Laptop createLaptop() {
        return new Laptop("Balaxy");
    }

    @Override
    public Netbook createNetbook() {
        return new Netbook("Balaxy");
    }

    @Override
    public EBook createEBook() {
        return new EBook("Balaxy");
    }

    @Override
    public Smartphone createSmartphone() {
        return new Smartphone("Balaxy");
    }
}
