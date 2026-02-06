import task4.*;

public class MainTask4 {
    public static void main(String[] args) {
        System.out.println("=== ЗАВДАННЯ 4: ПРОТОТИП ===\n");

        // Створюємо перше покоління
        Virus parentVirus = new Virus(0.1, 5, "COVID-19", "Коронавірус");
        
        // Створюємо друге покоління
        Virus child1 = new Virus(0.08, 3, "COVID-19 Alpha", "Коронавірус");
        Virus child2 = new Virus(0.09, 4, "COVID-19 Beta", "Коронавірус");
        parentVirus.addChild(child1);
        parentVirus.addChild(child2);
        
        // Створюємо третє покоління
        Virus grandchild1 = new Virus(0.07, 2, "COVID-19 Gamma", "Коронавірус");
        Virus grandchild2 = new Virus(0.075, 2, "COVID-19 Delta", "Коронавірус");
        child1.addChild(grandchild1);
        child2.addChild(grandchild2);
        
        System.out.println("Оригінальне сімейство вірусів:");
        parentVirus.displayInfo(0);
        System.out.println();
        
        System.out.println("Клоноване сімейство вірусів:");
        Virus clonedVirus = parentVirus.clone();
        clonedVirus.displayInfo(0);
        
        System.out.println("\nПеревірка клонування:");
        System.out.println("Оригінал і клон - різні об'єкти? " + (parentVirus != clonedVirus));
        System.out.println("Діти оригіналу і клону - різні об'єкти? " + 
            (parentVirus.getChildren().get(0) != clonedVirus.getChildren().get(0)));
        System.out.println("Онуки оригіналу і клону - різні об'єкти? " + 
            (parentVirus.getChildren().get(0).getChildren().get(0) != 
             clonedVirus.getChildren().get(0).getChildren().get(0)));
        
    }
}
