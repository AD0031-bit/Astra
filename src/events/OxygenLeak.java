package events;
import core.Colony;

public class OxygenLeak extends Event {

    @Override
    public void trigger(Colony colony) {

        System.out.println("WARNING! OXYGEN LEAK DETECTED!");

        colony.adjustResource(Colony.OXYGEN, -20);

        System.out.println("Oxygen reduced by 20 units!");

    }
}
