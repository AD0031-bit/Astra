package events;
import core.Colony;

public class DiseaseOutbreak extends Event {

    @Override
    public void trigger(Colony colony) {

        System.out.println("WARNING! DISEASE OUTBREAK DETECTED!");

        colony.adjustPopulation(-2);

        System.out.println("2 colonists have been lost!");

        colony.adjustMorale(-10);

        System.out.println("Colony morale reduced by 10!");

    }
}
