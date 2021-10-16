package com.ratnikov.HW.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private Integer id;
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getId(), recipe.getId()) &&
                Objects.equals(getName(), recipe.getName()) &&
                Objects.equals(getIngredients(), recipe.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getIngredients());
    }
}
