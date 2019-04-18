package pl.mnastaly.brightlightjurnal.ingredient;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Long kcal;
    @Enumerated(EnumType.STRING)
    private IngredientType ingredientType;
}
