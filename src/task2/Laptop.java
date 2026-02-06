package task2;

public class Laptop implements Device {
    private String brand;

    public Laptop(String brand) {
        this.brand = brand;
    }

    @Override
    public void showInfo() {
        System.out.println(brand + " Laptop: Потужний ноутбук для роботи та розваг");
    }
}
