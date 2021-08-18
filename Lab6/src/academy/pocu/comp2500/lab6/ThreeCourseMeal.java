package academy.pocu.comp2500.lab6;

public class ThreeCourseMeal extends SetMenu {
    private static final int PRICE = 25;

    public ThreeCourseMeal() {
        super(PRICE);
    }

    private void setValid() {
        this.isValid = this.appetizers.size() > 0 && this.mainCourses.size() > 0 && this.desserts.size() > 0;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourses.clear();

        this.mainCourses.add(mainCourse);
        setValid();
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizers.clear();

        this.appetizers.add(appetizer);
        setValid();
    }

    public void setDessert(Dessert dessert) {
        this.desserts.clear();

        this.desserts.add(dessert);
        setValid();
    }
}
