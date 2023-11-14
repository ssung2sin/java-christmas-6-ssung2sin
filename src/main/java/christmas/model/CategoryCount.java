package christmas.model;

public class CategoryCount {

    private int appetizer = 0;
    private int main = 0;
    private int dessert = 0;
    private int drink = 0;

    public CategoryCount() {
        this.appetizer = 0;
        this.main = 0;
        this.dessert = 0;
        this.drink = 0;
    }

    public void countAppetizer() {
        appetizer++;
    }

    public void countMain() {
        main++;
    }

    public void countDessert() {
        dessert++;
    }

    public void countDrink() {
        drink++;
    }

    public int getCountAppetizer() {
        return appetizer;
    }

    public int getCountMain() {
        return main;
    }

    public int getCountDessert() {
        return dessert;
    }

    public int getCountDrink() {
        return drink;
    }
}
