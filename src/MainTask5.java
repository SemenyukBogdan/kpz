import task5.*;

public class MainTask5 {
    public static void main(String[] args) {
        System.out.println("=== ЗАВДАННЯ 5: БУДІВЕЛЬНИК ===\n");

        Director director = new Director();
        HeroBuilder heroBuilder = new HeroBuilder();
        EnemyBuilder enemyBuilder = new EnemyBuilder();
        
        task5.Character hero = director.createDreamHero(heroBuilder);
        task5.Character enemy = director.createFierceEnemy(enemyBuilder);
        
        System.out.println("Створений герой:");
        hero.displayInfo();
        
        System.out.println("Створений ворог:");
        enemy.displayInfo();
        
        // Додаткова демонстрація fluent interface
        System.out.println("Демонстрація fluent interface:");
        HeroBuilder customHeroBuilder = new HeroBuilder();
        task5.Character customHero = customHeroBuilder
            .setHeight(180)
            .setBuild("Середня")
            .setHairColor("Руде")
            .setEyeColor("Зелені")
            .addClothing("Плащ мандрівника")
            .addInventory("Карта")
            .addGoodDeed("Допоміг мандрівникам")
            .build();
        
        customHero.setType("hero");
        customHero.displayInfo();
        
    }
}
