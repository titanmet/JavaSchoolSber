package com.ratnikov.HW.model;

import java.util.Objects;

public class Ingredient {
    private Integer recipe_id;
    private String name;
    private String kolvo;
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String name, String kolvo) {
        this.name = name;
        this.kolvo = kolvo;
    }

    public Ingredient(String name, String kolvo, Integer recipe_id) {
        this.name = name;
        this.kolvo = kolvo;
        this.recipe_id = recipe_id;
    }

    public Integer getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Integer recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKolvo() {
        return kolvo;
    }

    public void setKolvo(String kolvo) {
        this.kolvo = kolvo;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "recipe_id=" + recipe_id +
                ", name='" + name + '\'' +
                ", kolvo='" + kolvo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(getRecipe_id(), that.getRecipe_id()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getKolvo(), that.getKolvo()) &&
                Objects.equals(getRecipe(), that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipe_id(), getName(), getKolvo(), getRecipe());
    }
}
