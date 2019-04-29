package pl.mnastaly.brightlightjurnal.product;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mnastaly.brightlightjurnal.ingredient.Ingredient;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @OneToMany(mappedBy = "id")
    private List<Ingredient> ingredients;

    public Product(Long id, String name, ProductType productType) {
        this.id = id;
        this.name = name;
        this.productType = productType;
    }
}
