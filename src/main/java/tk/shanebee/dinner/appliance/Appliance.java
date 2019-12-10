package tk.shanebee.dinner.appliance;

import tk.shanebee.dinner.util.Util;

public abstract class Appliance {

    boolean powerState;

    public Appliance() {
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

}
