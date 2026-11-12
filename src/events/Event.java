package events;

import core.Colony;

public abstract class Event {

    public abstract void trigger(Colony colony);

}
