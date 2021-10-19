package com.ratnikov.springhibernate.model;

import javax.persistence.*;
import java.io.Serializable;

import lombok.*;
import org.springframework.data.annotation.AccessType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AccessType(AccessType.Type.FIELD)
@Data
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Ingredient implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String amount;
    @ManyToOne
    @JoinColumn(name="RECIPE_ID")
    private Recipe recipe;

    public Ingredient(String name, String amount, Recipe recipe) {
        this.name = name;
        this.amount = amount;
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", recipe=" + (recipe != null ? recipe.getId() : recipe) +
                '}';
    }
}
