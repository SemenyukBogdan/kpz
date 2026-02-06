package task2;

public class Netbook implements Device {
    private String brand;

    public Netbook(String brand) {
        this.brand = brand;
    }

    @Override
    public void showInfo() {
        System.out.println(brand + " Netbook: Компактний ноутбук для базових задач");
    }
}
