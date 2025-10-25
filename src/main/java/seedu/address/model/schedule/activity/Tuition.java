package seedu.address.model.schedule.activity;

import seedu.address.model.person.Person;

/**
 * Represents a tuition class for a tutee.
 */
public class Tuition extends Activity {

    /**
     * Constructs a Tuition object.
     *
     * @param person Tutee that is added.
     */
    public Tuition(Person person) {
        this(new Info("Tuition for " + person.getName().toString()),
                new Day(person.getDate().toString()), new Timeslot(person.getSlot().toString()));
    }

    /**
     * Constructs a Tuition object.
     */
    public Tuition(Info info, Day day, Timeslot timeslot) {
        super(info, day, timeslot);
    }
}
