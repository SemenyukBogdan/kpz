package task5;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private int height;
    private String build;
    private String hairColor;
    private String eyeColor;
    private List<String> clothing;
    private List<String> inventory;
    private List<String> deeds;
    private String type; // "hero" або "enemy"

    public Character() {
        this.clothing = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.deeds = new ArrayList<>();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void addClothing(String item) {
        this.clothing.add(item);
    }

    public void addInventory(String item) {
        this.inventory.add(item);
    }

    public void addDeed(String deed) {
        this.deeds.add(deed);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void displayInfo() {
        String title = (type != null && type.equals("hero")) ? "ГЕРОЙ" : "ВОРОГ";
        System.out.println("=== " + title + " ===");
        System.out.println("Зріст: " + height + " см");
        System.out.println("Статура: " + build);
        System.out.println("Колір волосся: " + hairColor);
        System.out.println("Колір очей: " + eyeColor);
        System.out.println("Одяг: " + clothing);
        System.out.println("Інвентар: " + inventory);
        String deedsLabel = (type != null && type.equals("hero")) ? "Добрі справи" : "Злі справи";
        System.out.println(deedsLabel + ": " + deeds);
        System.out.println();
    }
}
