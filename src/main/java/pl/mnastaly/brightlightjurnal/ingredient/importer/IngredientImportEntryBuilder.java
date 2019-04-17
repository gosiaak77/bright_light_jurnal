package pl.mnastaly.brightlightjurnal.ingredient.importer;

public class IngredientImportEntryBuilder {

    private String name;
    private String ingredientType;
    private Long kcal;

    public IngredientImportEntryBuilder() {
    }

    public IngredientImportEntryBuilder name(String name) {
        this.name = name;
        return this;
    }

    public IngredientImportEntryBuilder ingredientType(String ingredientType) {
        this.ingredientType = ingredientType;
        return this;
    }

    public IngredientImportEntryBuilder kcal(Long kcal) {
        this.kcal = kcal;
        return this;
    }

    public IngredientImportEntry build() {
        return new IngredientImportEntry(name, ingredientType, kcal);
    }
}
