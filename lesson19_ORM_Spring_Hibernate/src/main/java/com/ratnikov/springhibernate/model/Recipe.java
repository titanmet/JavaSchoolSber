package com.ratnikov.springhibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.springframework.data.annotation.AccessType;

@Entity
@AccessType(AccessType.Type.FIELD)
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Recipe implements Serializable {
    @Id @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    private List<Ingredient> ingredients = new ArrayList<>();
}
