package pl.mnastaly.brightlightjurnal.ingredient;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;
import pl.mnastaly.brightlightjurnal.product.Product;

@Entity
@Data
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    private Double grams;
    @ManyToMany
    @JoinTable(name = "meal_x_ingredient")
    private List<Ingredient> ingredients;
}
