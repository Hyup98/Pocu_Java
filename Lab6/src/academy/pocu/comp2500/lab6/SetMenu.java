package academy.pocu.comp2500.lab6;
import java.util.ArrayList;

public class SetMenu extends Menu {

    protected ArrayList<Appetizer> appetizers = new ArrayList<Appetizer>();
    protected ArrayList<MainCourse> mainCourses = new ArrayList<MainCourse>();
    protected ArrayList<Dessert> desserts = new ArrayList<Dessert>();

    protected SetMenu(int price) {
        super(price);
    }

    public ArrayList<Appetizer> getAppetizers() {
        assert (this.appetizers.size() > 0) : "call isValid() first!";
        return this.appetizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        assert (this.mainCourses.size() > 0) : "call isValid() first!";
        return this.mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        assert (this.desserts.size() > 0) : "call isValid() first!";
        return this.desserts;
    }
}
