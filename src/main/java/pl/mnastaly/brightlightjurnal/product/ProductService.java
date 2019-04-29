package pl.mnastaly.brightlightjurnal.product;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(ProductDto productDto) {
        productRepository.save(getProductFromDto(productDto));
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

    public Product getProductFromDto(ProductDto productDto) {
        Product product = findById(productDto.getId());
        if (product != null) {
            return product;
        } else {
            return new Product(productDto.getId(), productDto.getName(), determineProductType(productDto.getProductType()));
        }

    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

}
