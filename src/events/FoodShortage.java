package events;
import core.Colony;

public class FoodShortage extends Event {

    @Override
    public void trigger(Colony colony) {

        System.out.println("WARNING! FOOD SHORTAGE!");

        colony.adjustResource(Colony.FOOD, -20);

        System.out.println("Food reduced by 20 units!");

        colony.adjustMorale(-5);

        System.out.println("Colony morale reduced by 5!");

    }
}
