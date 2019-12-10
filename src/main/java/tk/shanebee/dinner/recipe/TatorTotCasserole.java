package tk.shanebee.dinner.recipe;

import tk.shanebee.dinner.appliance.Element;
import tk.shanebee.dinner.appliance.Oven;
import tk.shanebee.dinner.food.Ingredient;
import tk.shanebee.dinner.material.Dish;
import tk.shanebee.dinner.material.Material;
import tk.shanebee.dinner.misc.Measurement;
import tk.shanebee.dinner.temp.ElementHeat;
import tk.shanebee.dinner.util.Util;

public class TatorTotCasserole extends Recipe {

    public TatorTotCasserole() {
        super("Tator Tot Casserole");
    }

    private Oven oven;
    private Element element;

    @Override
    public void start() {
        Util.log("Starting to cook: " + this.getName());

        oven = new Oven();
        oven.setOn(true);
        oven.setTemperature(350);

        element = new Element();
        element.setOn(true);
        element.setTemperature(ElementHeat.MEDIUM_HIGH);

        Dish pan = new Dish(Dish.Type.FRYING_PAN);
        Dish casseroleDish = new Dish(Dish.Type.CASSEROLE_DISH);

        element.setDish(pan);

        Ingredient butter = new Ingredient(Material.BUTTER, Measurement.TABLESPOON, 2);
        Ingredient beef = new Ingredient(Material.GROUND_BEEF, Measurement.POUNDS, 3);

        pan.addIngredient(butter);
        pan.addIngredient(beef);

        oven.update();
        element.update();

    }

}
