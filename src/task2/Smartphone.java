package task2;

public class Smartphone implements Device {
    private String brand;

    public Smartphone(String brand) {
        this.brand = brand;
    }

    @Override
    public void showInfo() {
        System.out.println(brand + " Smartphone: Смартфон з усіма необхідними функціями");
    }
}
