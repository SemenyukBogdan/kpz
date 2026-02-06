package task5;

public interface CharacterBuilder {
    CharacterBuilder setHeight(int height);
    CharacterBuilder setBuild(String build);
    CharacterBuilder setHairColor(String hairColor);
    CharacterBuilder setEyeColor(String eyeColor);
    CharacterBuilder addClothing(String item);
    CharacterBuilder addInventory(String item);
    Character build();
}
