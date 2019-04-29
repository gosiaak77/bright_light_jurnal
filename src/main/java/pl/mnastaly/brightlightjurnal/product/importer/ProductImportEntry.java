package pl.mnastaly.brightlightjurnal.product.importer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductImportEntry {

    private final String name;
    private final String productType;

}
