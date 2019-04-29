package pl.mnastaly.brightlightjurnal.ingredient.importer;

import org.springframework.beans.factory.annotation.Autowired;
import pl.mnastaly.brightlightjurnal.ingredient.ProductRepository;

public class IngredientImportValidator {

    @Autowired
    ProductRepository ingredientRepository;
    @Autowired
    IngredientImportService ingredientImportService;

    public boolean validateIngredientImportEntry(ProductImportEntry entry) {
        if (validateIfIngredientNameIsUnique(entry) && isIngredientTypeValid(entry.getIngredientType())) {
            return true;
        } else
            return false;
    }

    private boolean validateIfIngredientNameIsUnique(ProductImportEntry importEntry) {
        return ingredientRepository.findByName(importEntry.getName()) == null;
    }

    private boolean isIngredientTypeValid(String ingredientType) {
        if (ingredientImportService.determineIngredientType(ingredientType) != null) {
            return true;
        } else
            return false;
    }
}
