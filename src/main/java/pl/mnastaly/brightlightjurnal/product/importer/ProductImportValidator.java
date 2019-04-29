package pl.mnastaly.brightlightjurnal.product.importer;

import org.springframework.stereotype.Component;
import pl.mnastaly.brightlightjurnal.product.ProductRepository;
import pl.mnastaly.brightlightjurnal.product.ProductService;

@Component
public class ProductImportValidator {

    private final ProductRepository productRepository;
    private final ProductImportService productImportService;
    private final ProductService productService;

    public ProductImportValidator(ProductRepository productRepository, ProductImportService productImportService, ProductService productService) {
        this.productRepository = productRepository;
        this.productImportService = productImportService;
        this.productService = productService;
    }

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
        if (productService.determineProductType(productType) != null) {
            return true;
        } else
            return false;
    }
}
