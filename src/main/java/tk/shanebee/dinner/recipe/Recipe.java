package tk.shanebee.dinner.recipe;

public abstract class Recipe {

    private String name;

    public Recipe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void start();

}
