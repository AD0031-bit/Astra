package events;
import core.Colony;

public class SolarStorm extends Event {

    @Override
    public void trigger(Colony colony) {

        System.out.println("WARNING! SOLAR STORM DETECTED!");

        colony.adjustResource(Colony.ENERGY, -25);

        System.out.println("Energy reduced by 25 units!");

    }
}
