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
    public Long id;
    public String name;
    public Long kcal;
    @Enumerated(EnumType.STRING)
    public IngredientType ingredientType;
}
