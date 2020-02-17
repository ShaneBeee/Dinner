package tk.shanebee.dinner.appliance;

import tk.shanebee.dinner.recipe.Recipe;
import tk.shanebee.dinner.util.Util;

@SuppressWarnings("unused")
public abstract class Appliance {

    boolean powerState;
    private String name;
    Recipe recipe;

    public Appliance(String name, Recipe recipe) {
        this.name = name;
        this.powerState = false;
        this.recipe = recipe;
    }

    public void setOn(boolean on) {
        this.powerState = on;
        Util.log("Appliance " + this.getName() + " has been turned " + (this.powerState ? "on." : "off."));
    }

    public boolean isOn() {
        return this.powerState;
    }

    public void update() {
        Util.log("Update for appliance: " + this);
    }

    public String getName() {
        return name;
    }

}
