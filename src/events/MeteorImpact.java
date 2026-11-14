package events;
import core.Colony;

public class MeteorImpact extends Event {

    @Override
    public void trigger(Colony colony) {

        System.out.println("WARNING! METEOR IMPACT DETECTED!");

       colony.adjustResource(Colony.METAL, -15);

        System.out.println("Metal reduced by 15 units!");

        colony.adjustResource(Colony.OXYGEN, -10);

        System.out.println("Oxygen reduced by 10 units!");

        colony.adjustMorale(-5);

        System.out.println("Colony morale reduced by 5!");

    }
}
