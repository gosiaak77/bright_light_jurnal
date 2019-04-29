package pl.mnastaly.brightlightjurnal.meal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

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