package pl.mnastaly.brightlightjurnal.meal;

import lombok.Data;
import pl.mnastaly.brightlightjurnal.ingredient.Ingredient;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    String mealName;
    @Enumerated(EnumType.STRING)
    List<Ingredient> ingredients;
    String note;
    MealType mealType;
}