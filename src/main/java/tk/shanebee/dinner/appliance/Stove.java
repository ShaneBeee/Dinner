package tk.shanebee.dinner.appliance;

import tk.shanebee.dinner.recipe.Recipe;
import tk.shanebee.dinner.util.Util;

public abstract class Stove extends Appliance {


    public Stove(String name, Recipe recipe) {
        super(name, recipe);
    }

    public void cook(int minutes) {
        Cook cook = new Cook(this, minutes);
        Thread thread = new Thread(cook);
        thread.start();
    }

    public abstract void done();

    private class Cook implements Runnable {

        private int minutes;
        private Stove appliance;

        public Cook(Stove appliance, int minutes) {
            this.appliance = appliance;
            this.minutes = minutes;
        }

        public void run() {
            Util.log("Cooking started...");
            try {
                Thread.sleep(minutes * 60 * 500);//TODO 500 as a test
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            appliance.done();
        }
    }

}
