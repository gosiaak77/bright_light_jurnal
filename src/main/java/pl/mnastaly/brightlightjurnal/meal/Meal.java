package pl.mnastaly.brightlightjurnal.meal;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    String mealName;
    String note;
    @Enumerated(EnumType.STRING)
    MealType mealType;
}