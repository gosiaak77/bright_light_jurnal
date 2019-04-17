package pl.mnastaly.brightlightjurnal.ingredient.importer;

import lombok.Data;

@Data
public class IngredientImportEntry {

    private final String name;
    private final String ingredientType;
    private final Long kcal;

    @Override
    public String toString() {
        return "IngredientImportEntry{" +
                "name='" + name + '\'' +
                ", ingredientType='" + ingredientType + '\'' +
                ", kcal=" + kcal +
                '}';
    }
}
