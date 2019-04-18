package pl.mnastaly.brightlightjurnal.ingredient.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import pl.mnastaly.brightlightjurnal.ingredient.IngredientRepository;

public class IngredientImportValidator {

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    IngredientImportService ingredientImportService;

    public boolean validateIfIngredientNameIsUnique(IngredientImportEntry importEntry){
        return ingredientRepository.findByName(importEntry.getName())==null;
    }

    public boolean isIngredientTypeValid(String ingredientType){
        if (ingredientImportService.determineIngredientType(ingredientType) != null){
            return true;
        } else return false;
    }
}
