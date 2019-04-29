package pl.mnastaly.brightlightjurnal.product.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mnastaly.brightlightjurnal.product.ProductRepository;

@Component
public class ProductImportValidator {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductImportService productImportService;

    public boolean validateProductImportEntry(ProductImportEntry entry) {
        if (validateIfProductNameIsUnique(entry) && isProductTypeValid(entry.getProductType())) {
            return true;
        } else
            return false;
    }

    private boolean validateIfProductNameIsUnique(ProductImportEntry importEntry) {
        return productRepository.findByName(importEntry.getName()) == null;
    }

    private boolean isProductTypeValid(String productType) {
        if (productImportService.determineProductType(productType) != null) {
            return true;
        } else
            return false;
    }
}
