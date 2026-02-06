package task5;

public class HeroBuilder implements CharacterBuilder {
    private Character character;

    public HeroBuilder() {
        this.character = new Character();
        this.character.setType("hero");
    }

    @Override
    public HeroBuilder setHeight(int height) {
        character.setHeight(height);
        return this;
    }

    @Override
    public HeroBuilder setBuild(String build) {
        character.setBuild(build);
        return this;
    }

    @Override
    public HeroBuilder setHairColor(String hairColor) {
        character.setHairColor(hairColor);
        return this;
    }

    @Override
    public HeroBuilder setEyeColor(String eyeColor) {
        character.setEyeColor(eyeColor);
        return this;
    }

    @Override
    public HeroBuilder addClothing(String item) {
        character.addClothing(item);
        return this;
    }

    @Override
    public HeroBuilder addInventory(String item) {
        character.addInventory(item);
        return this;
    }

    public HeroBuilder addGoodDeed(String deed) {
        character.addDeed(deed);
        return this;
    }

    @Override
    public Character build() {
        return character;
    }
}
