package pl.mnastaly.brightlightjurnal.ingredient.importer;

import pl.mnastaly.brightlightjurnal.ingredient.IngredientRepository;

public class IngredientImportValidator {

    IngredientRepository ingredientRepository;

    public boolean validateIfIngredientNameExists(IngredientImportEntry importEntry){
        return ingredientRepository.findByName(importEntry.getName())!=null;
    }
}
