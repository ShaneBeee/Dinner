package tk.shanebee.dinner.recipe;

import tk.shanebee.dinner.appliance.Element;
import tk.shanebee.dinner.appliance.Oven;
import tk.shanebee.dinner.food.Ingredient;
import tk.shanebee.dinner.material.Dish;
import tk.shanebee.dinner.material.Material;
import tk.shanebee.dinner.misc.Measurement;
import tk.shanebee.dinner.temp.ElementHeat;
import tk.shanebee.dinner.util.Util;

public class TaterTotCasserole extends Recipe {

    public TaterTotCasserole() {
        super("Tater Tot Casserole");
    }

    private Oven oven;
    private Element element;
    private Dish pan;
    private Dish casseroleDish;

    @Override
    public void start() {
        Util.log("Starting to cook: " + this.getName());

        Util.line();
        Util.log("Preparing appliances");
        Util.line();
        oven = new Oven(this);
        oven.setOn(true);
        oven.setTemperature(350);

        element = new Element(this);
        element.setOn(true);
        element.setTemperature(ElementHeat.MEDIUM_HIGH);

        prepareMeat();
    }

    private void prepareMeat() {
        Util.line();
        Util.log("Cooking ingredients in pan");
        Util.line();
        this.pan = new Dish(Dish.Type.FRYING_PAN);

        element.setDish(pan);

        Ingredient butter = new Ingredient(Material.BUTTER, Measurement.TABLESPOON, 2);
        Ingredient beef = new Ingredient(Material.GROUND_BEEF, Measurement.POUNDS, 3);

        pan.addIngredient(butter);
        pan.addIngredient(beef);
        pan.stir();

        pan.addIngredient(new Ingredient(Material.SALT, Measurement.PINCH, 1));
        pan.addIngredient(new Ingredient(Material.PEPPER, Measurement.PINCH, 1));
        pan.stir();

        pan.cookFor(3, Dish.Time.SECONDS);
        element.setOn(false);
        prepareCasseroleDish();
    }

    private void prepareCasseroleDish() {
        Util.line();
        Util.log("Preparing casserole dish");
        Util.line();
        this.casseroleDish = new Dish(Dish.Type.CASSEROLE_DISH);

        // Add the ingredients from the pan into the dish
        casseroleDish.transferIngredients(this.pan);

        Ingredient peas = new Ingredient(Material.FROZEN_PEAS, Measurement.CUP, 0.5);
        Ingredient corn = new Ingredient(Material.FROZEN_CORN, Measurement.CUP, 0.5);
        Ingredient mushroomSoup = new Ingredient(Material.MUSHROOM_SOUP, Measurement.CAN, 1);
        Ingredient taterTots = new Ingredient(Material.TATER_TOT, Measurement.CUP, 2);
        Ingredient cheese = new Ingredient(Material.SHREDDED_CHEESE, Measurement.CUP, 2);

        // Pour peas and corn on top
        casseroleDish.pourIngredient(peas);
        casseroleDish.pourIngredient(corn);

        // Pour can of soup on top
        casseroleDish.pourIngredient(mushroomSoup);

        // Place tater tops on top
        casseroleDish.addIngredient(taterTots);

        // Put cheese on top
        casseroleDish.addIngredient(cheese);

        // Cover dish and wait for oven to be ready
        casseroleDish.cover();
        Util.log("Waiting for oven to be ready...");
    }

    public void cookDish(int seconds) {
        oven.addDish(casseroleDish);
        oven.cook(1);
    }



}
