package pl.mnastaly.brightlightjurnal.ingredient.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mnastaly.brightlightjurnal.ingredient.Ingredient;
import pl.mnastaly.brightlightjurnal.ingredient.IngredientRepository;
import pl.mnastaly.brightlightjurnal.ingredient.IngredientType;
import pl.mnastaly.brightlightjurnal.ingredient.importer.IngredientImportEntry;

@Service
public class IngredientImportService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public void processIngredientImportEntry(IngredientImportEntry ingredientImportEntry){
        Ingredient ingredient = Ingredient.builder()
                .name(ingredientImportEntry.getName())
                .ingredientType(determineIngredientType(ingredientImportEntry.getIngredientType()))
                .kcal(ingredientImportEntry.getKcal())
                .build();
        ingredientRepository.save(ingredient);
    }

    public IngredientType determineIngredientType(String ingredientType){
        if (ingredientType.equals("FAT")){
            return IngredientType.FAT;
        } else if (ingredientType.equals("PROTEIN")){
            return IngredientType.PROTEIN;
        } else if (ingredientType.equals("VEGETABLE")){
            return IngredientType.VEGETABLE;
        } else if (ingredientType.equals("FRUIT")){
            return IngredientType.FRUIT;
        } else throw new IllegalArgumentException();
    }

}
