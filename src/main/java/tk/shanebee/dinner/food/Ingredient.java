package tk.shanebee.dinner.food;

import tk.shanebee.dinner.material.Material;
import tk.shanebee.dinner.misc.Measurement;
import tk.shanebee.dinner.util.Util;

@SuppressWarnings("unused")
public class Ingredient {

    private Material material;
    private double amount;
    private Measurement measurement;

    public Ingredient(Material material) {
        this.material = material;
        this.amount = 0.0;
        this.measurement = null;
    }

    public Ingredient(Material material, Measurement measurement, double amount) {
        this.material = material;
        this.measurement = measurement;
        this.amount = amount;
    }

    public void setAmount(Measurement measurement, double amount) {
        this.measurement = measurement;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return Util.trans("Ingredient{" +
                "&bmaterial=&a" + material +
                ", &bamount=&a" + amount +
                ", &bmeasurement=&a" + measurement +
                "&r}");
    }
}
