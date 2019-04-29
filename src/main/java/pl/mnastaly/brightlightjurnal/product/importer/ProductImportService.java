package pl.mnastaly.brightlightjurnal.product.importer;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.mnastaly.brightlightjurnal.product.Product;
import pl.mnastaly.brightlightjurnal.product.ProductRepository;
import pl.mnastaly.brightlightjurnal.product.ProductService;

@Service
public class ProductImportService {

    private final ProductRepository productRepository;
    private final CsvToProductImportEntry csvToProductImportEntry;
    private final ProductImportValidator productImportValidator;
    private final ProductService productService;

    public ProductImportService(ProductRepository productRepository, CsvToProductImportEntry csvToProductImportEntry, ProductImportValidator productImportValidator, ProductService productService) {
        this.productRepository = productRepository;
        this.csvToProductImportEntry = csvToProductImportEntry;
        this.productImportValidator = productImportValidator;
        this.productService = productService;
    }

    public void processImportCsvFile(MultipartFile file) {
        List<ProductImportEntry> entries = csvToProductImportEntry.convertCsvFileToProductImportEntries(file);
        for (ProductImportEntry entry : entries) {
            if (productImportValidator.validateProductImportEntry(entry)) {
                saveIngredientFromImportEntry(entry);
            }
        }

    }

    public void saveIngredientFromImportEntry(ProductImportEntry entry) {
        Product product = new Product();
        product.setName(entry.getName());
        product.setProductType(productService.determineProductType(entry.getProductType()));
        productRepository.save(product);
    }

}
