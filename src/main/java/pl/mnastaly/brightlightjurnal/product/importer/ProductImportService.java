package pl.mnastaly.brightlightjurnal.product.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.mnastaly.brightlightjurnal.product.Product;
import pl.mnastaly.brightlightjurnal.product.ProductRepository;
import pl.mnastaly.brightlightjurnal.product.ProductType;

import java.util.List;

@Service
public class ProductImportService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    CsvToProductImportEntry csvToProductImportEntry;
    @Autowired
    ProductImportValidator productImportValidator;


    public void processImportCsvFile(MultipartFile file) {
        List<ProductImportEntry> entries = csvToProductImportEntry.convertCsvFileToProductImportEntries(file);
        for (ProductImportEntry entry : entries){
            if (productImportValidator.validateProductImportEntry(entry)){
                saveIngredientFromImportEntry(entry);
            }
        }

    }

    public ProductType determineProductType(String productType) {
        if (productType.equals("FAT")) {
            return ProductType.FAT;
        } else if (productType.equals("PROTEIN")) {
            return ProductType.PROTEIN;
        } else if (productType.equals("VEGETABLE")) {
            return ProductType.VEGETABLE;
        } else if (productType.equals("FRUIT")) {
            return ProductType.FRUIT;
        } else throw new IllegalArgumentException("Wrong product type");
    }

    public void saveIngredientFromImportEntry(ProductImportEntry entry) {
        Product product = Product.builder()
                .name(entry.getName())
                .productType(determineProductType(entry.getProductType()))
                .build();
        productRepository.save(product);
    }

}
