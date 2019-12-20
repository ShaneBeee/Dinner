package tk.shanebee.dinner.appliance;

import tk.shanebee.dinner.material.Dish;
import tk.shanebee.dinner.recipe.Recipe;
import tk.shanebee.dinner.util.Util;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Oven extends Stove {

    private int temperature;
    private List<Dish> dishes;
    private boolean ready;

    public Oven(Recipe recipe) {
        super("Oven", recipe);
        this.dishes = new ArrayList<Dish>();
        this.ready = false;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady() {
        this.ready = true;
        this.recipe.cookDish(10);
    }

    @Override
    public void done() {
        Util.log("Dinner is ready!!");
        Util.log("Enjoy!!!");
        this.setOn(false);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        Util.log("Temperature of " + this.getName() + " has been set to " + temperature + " degrees");
        preheat();
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
        Util.log("Adding dish to " + getName() + ": " + dish);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        return "Oven{" +
                "temperature=" + temperature +
                ", dishes=" + dishes +
                ", powerState=" + powerState +
                '}';
    }

    private void preheat() {
        PreHeat preHeat = new PreHeat(this);
        Thread thread = new Thread(preHeat);
        thread.start();
    }

    public class PreHeat implements Runnable {
        // Preheat and wait for the oven

        private Oven oven;

        public PreHeat(Oven oven) {
            this.oven = oven;
        }

        public void run() {
            Util.log("---Preheating " + getName() + "...");
            try {
                int sleepTime = 350 * 25;
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Util.log("---Oven Ready!");
            this.oven.setReady();
        }

    }

}
