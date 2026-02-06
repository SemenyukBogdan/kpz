package task5;

public class EnemyBuilder implements CharacterBuilder {
    private Character character;

    public EnemyBuilder() {
        this.character = new Character();
        this.character.setType("enemy");
    }

    @Override
    public EnemyBuilder setHeight(int height) {
        character.setHeight(height);
        return this;
    }

    @Override
    public EnemyBuilder setBuild(String build) {
        character.setBuild(build);
        return this;
    }

    @Override
    public EnemyBuilder setHairColor(String hairColor) {
        character.setHairColor(hairColor);
        return this;
    }

    @Override
    public EnemyBuilder setEyeColor(String eyeColor) {
        character.setEyeColor(eyeColor);
        return this;
    }

    @Override
    public EnemyBuilder addClothing(String item) {
        character.addClothing(item);
        return this;
    }

    @Override
    public EnemyBuilder addInventory(String item) {
        character.addInventory(item);
        return this;
    }

    public EnemyBuilder addEvilDeed(String deed) {
        character.addDeed(deed);
        return this;
    }

    @Override
    public Character build() {
        return character;
    }
}
