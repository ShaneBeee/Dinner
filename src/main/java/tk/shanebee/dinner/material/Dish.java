package tk.shanebee.dinner.material;

import tk.shanebee.dinner.food.Ingredient;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Dish {

    private Type type;
    private List<Ingredient> ingredients;

    public Dish(Type type) {
        this.type = type;
        this.ingredients = new ArrayList<Ingredient>();
    }

    public Type getType() {
        return type;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
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

    @Override
    public String toString() {
        return "Dish{" +
                "type=" + type +
                ", ingredients=" + ingredients +
                '}';
    }

    public enum Type {
        MIXING_BOWL,
        CASSEROLE_DISH,
        FRYING_PAN,
        MEASURING_CUP,
        MEASURING_SPOONS
    }

}
