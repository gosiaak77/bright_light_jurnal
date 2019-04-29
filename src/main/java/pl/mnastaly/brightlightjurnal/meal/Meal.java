package pl.mnastaly.brightlightjurnal.meal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "meal_x_ingredient")
    private List<Meal> meals;
}