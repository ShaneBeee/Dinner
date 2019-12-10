package tk.shanebee.dinner.appliance;

import tk.shanebee.dinner.material.Dish;
import tk.shanebee.dinner.temp.ElementHeat;
import tk.shanebee.dinner.util.Util;

public class Element extends Stove {

    private ElementHeat temperature;
    private Dish dish;

    public Element() {
        super("Stovetop");
    }

    public void setTemperature(ElementHeat temperature) {
        this.temperature = temperature;
        Util.log("Temperature for " + this + " set to " + temperature);
    }

    public void setDish(Dish dish) {
        this.dish = dish;
        Util.log("Dish for " + this + " has been set to " + dish);
    }

    @Override
    public String toString() {
        return "Element{" +
                "temperature=" + temperature +
                ", dish=" + dish +
                ", powerState=" + powerState +
                '}';
    }

}
