package tk.shanebee.dinner;

import tk.shanebee.dinner.recipe.Recipe;
import tk.shanebee.dinner.recipe.TatorTotCasserole;

public class Dinner {

    public static void main(String[] args) {
        Recipe tatorTotCasserole = new TatorTotCasserole();
        tatorTotCasserole.start();
    }

}
