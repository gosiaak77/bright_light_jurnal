package pl.mnastaly.brightlightjurnal.ingredient.importer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductImportEntry {

    private final String name;
    private final String ingredientType;

}
