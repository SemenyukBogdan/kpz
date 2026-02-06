package task5;

public class Director {
    public Character createDreamHero(HeroBuilder builder) {
        // використовуємо fluent interface для побудови героя
        return builder
            .setHeight(175)
            .setBuild("Спортивна")
            .setHairColor("Блонд")
            .setEyeColor("Сині")
            .addClothing("Броня легендарного воїна")
            .addClothing("Плащ захисту")
            .addInventory("Меч світла")
            .addInventory("Щит справедливості")
            .addInventory("Зілля здоров'я")
            .addGoodDeed("Врятував село від дракона")
            .addGoodDeed("Допоміг бідним")
            .addGoodDeed("Захистив королівство")
            .build();
    }

    public Character createFierceEnemy(EnemyBuilder builder) {
        return builder
            .setHeight(190)
            .setBuild("М'язиста")
            .setHairColor("Чорне")
            .setEyeColor("Червоні")
            .addClothing("Темна броня")
            .addClothing("Плащ зла")
            .addInventory("Темний меч")
            .addInventory("Череп ворога")
            .addInventory("Зілля сили")
            .addEvilDeed("Спалив село")
            .addEvilDeed("Викрав скарби")
            .addEvilDeed("Захопив фортецю")
            .build();
    }
}
