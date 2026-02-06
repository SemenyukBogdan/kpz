package task2;

public class KiaomiFactory implements DeviceFactory {
    @Override
    public Laptop createLaptop() {
        return new Laptop("Kiaomi");
    }

    @Override
    public Netbook createNetbook() {
        return new Netbook("Kiaomi");
    }

    @Override
    public EBook createEBook() {
        return new EBook("Kiaomi");
    }

    @Override
    public Smartphone createSmartphone() {
        return new Smartphone("Kiaomi");
    }
}
