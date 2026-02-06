package task2;

public class EBook implements Device {
    private String brand;

    public EBook(String brand) {
        this.brand = brand;
    }

    @Override
    public void showInfo() {
        System.out.println(brand + " EBook: Електронна книга для читання");
    }
}
