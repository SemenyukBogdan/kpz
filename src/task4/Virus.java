package task4;

import java.util.ArrayList;
import java.util.List;

public class Virus implements Cloneable {
    private double weight;
    private int age;
    private String name;
    private String species;
    private List<Virus> children;

    public Virus(double weight, int age, String name, String species) {
        this.weight = weight;
        this.age = age;
        this.name = name;
        this.species = species;
        this.children = new ArrayList<>();
    }

    public void addChild(Virus child) {
        children.add(child);
    }

    public List<Virus> getChildren() {
        return children;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public Virus clone() {
        try {
            Virus cloned = (Virus) super.clone();
            cloned.children = new ArrayList<>();
            
            // Клонуємо всіх дітей рекурсивно
            for (Virus child : this.children) {
                cloned.children.add(child.clone());
            }
            
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Помилка клонування вірусу", e);
        }
    }

    public void displayInfo(int level) {
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "  ";  // додаємо відступи для відображення рівня
        }
        // System.out.println("DEBUG: рівень = " + level); // для тестування
        System.out.println(indent + "Вірус: " + name);
        System.out.println(indent + "  Вид: " + species);
        System.out.println(indent + "  Вага: " + weight + " нм");
        System.out.println(indent + "  Вік: " + age + " днів");
        
        if (!children.isEmpty()) {
            System.out.println(indent + "  Діти (" + children.size() + "):");
            for (Virus child : children) {
                child.displayInfo(level + 1);
            }
        }
    }
}
