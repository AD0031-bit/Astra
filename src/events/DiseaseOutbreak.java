package events;
import core.Colony;

public class DiseaseOutbreak extends Event {

    @Override
    public void trigger(Colony colony) {

        System.out.println("WARNING! DISEASE OUTBREAK DETECTED!");

        colony.changePopulation(-2);

        System.out.println("2 colonists have been lost!");

        colony.changeMorale(-10);

        System.out.println("Colony morale reduced by 10!");

    }
}
