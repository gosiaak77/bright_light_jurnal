package pl.mnastaly.brightlightjurnal.ingredient.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.mnastaly.brightlightjurnal.ingredient.Ingredient;
import pl.mnastaly.brightlightjurnal.ingredient.IngredientRepository;
import pl.mnastaly.brightlightjurnal.ingredient.IngredientType;
import pl.mnastaly.brightlightjurnal.ingredient.importer.IngredientImportEntry;

import java.util.List;

@Service
public class IngredientImportService {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    CsvToIngredientImportEntry csvToIngredientImportEntry;
    @Autowired
    IngredientImportValidator ingredientImportValidator;


    public void processImportCsvFile(MultipartFile file) {
        List<IngredientImportEntry> entries = csvToIngredientImportEntry.convertCsvFileToIngredientImportEntries(file);
        for (IngredientImportEntry entry : entries){
            if (ingredientImportValidator.validateIngredientImportEntry(entry)){
                saveIngredientFromImportEntry(entry);
            }
        }

    }

    public IngredientType determineIngredientType(String ingredientType) {
        if (ingredientType.equals("FAT")) {
            return IngredientType.FAT;
        } else if (ingredientType.equals("PROTEIN")) {
            return IngredientType.PROTEIN;
        } else if (ingredientType.equals("VEGETABLE")) {
            return IngredientType.VEGETABLE;
        } else if (ingredientType.equals("FRUIT")) {
            return IngredientType.FRUIT;
        } else throw new IllegalArgumentException("Wrong ingredient type");
    }

    public void saveIngredientFromImportEntry(IngredientImportEntry entry) {
        Ingredient ingredient = Ingredient.builder()
                .name(entry.getName())
                .ingredientType(determineIngredientType(entry.getIngredientType()))
                .build();
        ingredientRepository.save(ingredient);
    }

}
