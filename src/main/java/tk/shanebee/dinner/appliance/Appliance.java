package tk.shanebee.dinner.appliance;

import tk.shanebee.dinner.util.Util;

public abstract class Appliance {

    boolean powerState;
    private String name;

    public Appliance(String name) {
        this.name = name;
        this.powerState = false;
    }

    public void setOn(boolean on) {
        this.powerState = on;
        Util.log("Appliance " + this + " has been turned " + (this.powerState ? "on." : "off."));
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
