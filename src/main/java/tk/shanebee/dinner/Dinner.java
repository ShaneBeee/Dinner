package tk.shanebee.dinner;

import tk.shanebee.dinner.recipe.Recipe;
import tk.shanebee.dinner.recipe.TatorTotCasserole;
import tk.shanebee.dinner.util.Util;

import java.util.Scanner;

public class Dinner {

    public static void main(String[] args) {
        Util.log("What would you like to cook today?");
        recipe();
    }

    private static void recipe() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equalsIgnoreCase("tator tot casserole")) {
            Recipe tatorTotCasserole = new TatorTotCasserole();
            tatorTotCasserole.start();
        } else if (line.equalsIgnoreCase("exit")) {
            System.exit(1);
        } else {
            Util.log("Recipe not found, try again!");
            recipe();
        }
    }

}
