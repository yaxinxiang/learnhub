package designpatterns.ceratepatterns.Builder;

public class MealBuilder {
    private Meal meal;

    public MealBuilder setFood(String food){
        meal.setFood(food);
        return this;
    }

    public MealBuilder setDrink(String drink){
        meal.setDrink(drink);
        return this;
    }

    public Meal build(){
        return meal;
    }

    public static void main(String[] args) {
        Meal meal = new MealBuilder().setFood("burger")
                .setDrink("juice")
                .build();
    }
}
