package tk.shanebee.dinner.appliance;

import tk.shanebee.dinner.material.Dish;
import tk.shanebee.dinner.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Oven extends Stove {

    private int temperature;
    private List<Dish> dishes;

    public Oven() {
        super("Oven");
        this.dishes = new ArrayList<Dish>();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        Util.log("Temperature of " + this + " has been set to " + temperature + " degrees");
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
        Util.log("Dish " + dish + " has been added to stovetop");
    }

    @Override
    public String toString() {
        return "Oven{" +
                "temperature=" + temperature +
                ", dishes=" + dishes +
                ", powerState=" + powerState +
                '}';
    }

}
