package events;
import core.Colony;

public class MeteorImpact extends Event {

    @Override
    public void trigger(Colony colony) {

        System.out.println("WARNING! METEOR IMPACT DETECTED!");

        colony.changeResource("Metal", -15);

        System.out.println("Metal reduced by 15 units!");

        colony.changeResource("Oxygen", -10);

        System.out.println("Oxygen reduced by 10 units!");

        colony.changeMorale(-5);

        System.out.println("Colony morale reduced by 5!");

    }
}
