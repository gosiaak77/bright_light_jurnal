package pl.mnastaly.brightlightjurnal.ingredient.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.mnastaly.brightlightjurnal.ingredient.Product;
import pl.mnastaly.brightlightjurnal.ingredient.ProductRepository;
import pl.mnastaly.brightlightjurnal.ingredient.ProductType;

import java.util.List;

@Service
public class IngredientImportService {

    @Autowired
    private ProductRepository ingredientRepository;
    @Autowired
    CsvToProductImportEntry csvToIngredientImportEntry;
    @Autowired
    IngredientImportValidator ingredientImportValidator;


    public void processImportCsvFile(MultipartFile file) {
        List<ProductImportEntry> entries = csvToIngredientImportEntry.convertCsvFileToIngredientImportEntries(file);
        for (ProductImportEntry entry : entries){
            if (ingredientImportValidator.validateIngredientImportEntry(entry)){
                saveIngredientFromImportEntry(entry);
            }
        }

    }

    public ProductType determineIngredientType(String ingredientType) {
        if (ingredientType.equals("FAT")) {
            return ProductType.FAT;
        } else if (ingredientType.equals("PROTEIN")) {
            return ProductType.PROTEIN;
        } else if (ingredientType.equals("VEGETABLE")) {
            return ProductType.VEGETABLE;
        } else if (ingredientType.equals("FRUIT")) {
            return ProductType.FRUIT;
        } else throw new IllegalArgumentException("Wrong ingredient type");
    }

    public void saveIngredientFromImportEntry(ProductImportEntry entry) {
        Product ingredient = Product.builder()
                .name(entry.getName())
                .ingredientType(determineIngredientType(entry.getIngredientType()))
                .build();
        ingredientRepository.save(ingredient);
    }

}
