package lab3;

// Завдання 2: Декоратор

interface IHero {
    String getDescription();
    int getAttack();
    int getDefense();
}

class Warrior implements IHero {
    @Override
    public String getDescription() {
        return "Воїн";
    }

    @Override
    public int getAttack() {
        return 10;
    }

    @Override
    public int getDefense() {
        return 8;
    }
}

class Mage implements IHero {
    @Override
    public String getDescription() {
        return "Маг";
    }

    @Override
    public int getAttack() {
        return 12;
    }

    @Override
    public int getDefense() {
        return 5;
    }
}

class Paladin implements IHero {
    @Override
    public String getDescription() {
        return "Паладин";
    }

    @Override
    public int getAttack() {
        return 9;
    }

    @Override
    public int getDefense() {
        return 10;
    }
}

// Базовий декоратор
abstract class HeroDecorator implements IHero {
    protected IHero hero;

    public HeroDecorator(IHero hero) {
        this.hero = hero;
    }

    @Override
    public String getDescription() {
        return hero.getDescription();
    }

    @Override
    public int getAttack() {
        return hero.getAttack();
    }

    @Override
    public int getDefense() {
        return hero.getDefense();
    }
}

class SwordDecorator extends HeroDecorator {
    public SwordDecorator(IHero hero) {
        super(hero);
    }

    @Override
    public String getDescription() {
        return hero.getDescription() + " з мечем";
    }

    @Override
    public int getAttack() {
        return hero.getAttack() + 5;
    }
}

class ShieldDecorator extends HeroDecorator {
    public ShieldDecorator(IHero hero) {
        super(hero);
    }

    @Override
    public String getDescription() {
        return hero.getDescription() + " з щитом";
    }

    @Override
    public int getDefense() {
        return hero.getDefense() + 4;
    }
}

class ArmorDecorator extends HeroDecorator {
    public ArmorDecorator(IHero hero) {
        super(hero);
    }

    @Override
    public String getDescription() {
        return hero.getDescription() + " в броні";
    }

    @Override
    public int getDefense() {
        return hero.getDefense() + 3;
    }
}

class ArtifactDecorator extends HeroDecorator {
    private String artifactName;

    public ArtifactDecorator(IHero hero, String artifactName) {
        super(hero);
        this.artifactName = artifactName;
    }

    @Override
    public String getDescription() {
        return hero.getDescription() + " з артефактом " + artifactName;
    }

    @Override
    public int getAttack() {
        return hero.getAttack() + 3;
    }

    @Override
    public int getDefense() {
        return hero.getDefense() + 2;
    }
}

class Task2 {
    public static void demonstrate() {
        IHero warrior = new Warrior();
        IHero mage = new Mage();
        IHero paladin = new Paladin();

        IHero warriorWithEquipment = new ArtifactDecorator(
            new ArmorDecorator(
                new ShieldDecorator(
                    new SwordDecorator(warrior)
                )
            ),
            "Кільце сили"
        );

        IHero mageWithEquipment = new ArtifactDecorator(
            new SwordDecorator(mage),
            "Посох магії"
        );

        IHero paladinWithEquipment = new ShieldDecorator(
            new ArmorDecorator(paladin)
        );

        System.out.println("Герой: " + warriorWithEquipment.getDescription());
        System.out.println("Атака: " + warriorWithEquipment.getAttack() + 
                          ", Захист: " + warriorWithEquipment.getDefense());

        System.out.println("\nГерой: " + mageWithEquipment.getDescription());
        System.out.println("Атака: " + mageWithEquipment.getAttack() + 
                          ", Захист: " + mageWithEquipment.getDefense());

        System.out.println("\nГерой: " + paladinWithEquipment.getDescription());
        System.out.println("Атака: " + paladinWithEquipment.getAttack() + 
                          ", Захист: " + paladinWithEquipment.getDefense());
    }
}
