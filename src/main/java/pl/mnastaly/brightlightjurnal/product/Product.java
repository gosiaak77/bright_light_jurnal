package pl.mnastaly.brightlightjurnal.product;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import pl.mnastaly.brightlightjurnal.ingredient.Ingredient;

@Entity
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @OneToMany(mappedBy = "id")
    private List<Ingredient> ingredients;
}
