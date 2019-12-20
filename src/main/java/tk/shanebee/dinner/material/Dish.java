package tk.shanebee.dinner.material;

import tk.shanebee.dinner.food.Ingredient;
import tk.shanebee.dinner.util.Util;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Dish {

    private Type type;
    private List<Ingredient> ingredients;
    private boolean covered;

    public Dish(Type type) {
        this.type = type;
        this.ingredients = new ArrayList<Ingredient>();
        this.covered = false;
    }

    public Type getType() {
        return type;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        Util.log("Adding ingredient into " + type + ": " + ingredient);
    }

    public void addIngredients(List<Ingredient> ingredients) {
        this.ingredients.addAll(ingredients);
        Util.log("Adding ingredients into " + type + ": " + ingredients);
    }

    public void pourIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        Util.log("Pouring ingredient into " + type + ": " + ingredient);
    }

    public void transferIngredients(Dish fromDish) {
        this.ingredients.addAll(fromDish.getIngredients());
        fromDish.clearIngredients();
        Util.log("Transferring ingredients from " + fromDish.getType() + " to " + this.getType() + ": " + ingredients);
    }

    public void clearIngredients() {
        this.ingredients.clear();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public boolean containsIngredient(Ingredient ingredient) {
        return this.ingredients.contains(ingredient);
    }

    public boolean isCovered() {
        return covered;
    }

    public void cover() {
        this.covered = true;
        Util.log("Covering " + getType());
    }

    @Override
    public String toString() {
        return "Dish{" +
                "type=" + type +
                ", ingredients=" + ingredients +
                '}';
    }

    public void stir() {
        Util.log("Stirring ingredients " + ingredients + " in " + this.type);
    }

    public void cookFor(int val, Time time) {
        int t = time == Time.SECONDS ? 1000 : (60 * 1000);
        try {
            Util.log("Cooking in " + type + " for " + val + " " + time);
            Util.line();
            Thread.sleep(val * t);
            Util.log("Finished cooking " + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public enum Time {
        SECONDS,
        MINUTES
    }

    public enum Type {
        MIXING_BOWL,
        CASSEROLE_DISH,
        FRYING_PAN,
        MEASURING_CUP,
        MEASURING_SPOONS
    }

}
