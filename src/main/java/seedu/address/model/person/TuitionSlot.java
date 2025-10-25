package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a timeslot of tuition in the address book.
 */
public class TuitionSlot {

    public static final String MESSAGE_CONSTRAINTS =
            "Slot is the timing that the tuition takes place, it must adhere to the following \n"
                    + "1. The timing formats need to be 24h time, with no space \n"
                    + "2. The two timings must be seperated by a hyphen, no space \n "
                    + "example: 16:00-18:00";
    public static final String VALIDATION_REGEX = "([01]\\d|2[0-3]):[0-5]\\d-([01]\\d|2[0-3]):[0-5]\\d";
    public final String slot;

    /**
     * Constructs a {@code Date}.
     *
     * @param slot A valid slot.
     */
    public TuitionSlot(String slot) {
        requireNonNull(slot);
        checkArgument(isValidSlot(slot), MESSAGE_CONSTRAINTS);
        this.slot = slot;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidSlot(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return slot;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TuitionSlot)) {
            return false;
        }

        TuitionSlot otherSlot = (TuitionSlot) other;
        return slot.equals(otherSlot.slot);
    }

    @Override
    public int hashCode() {
        return slot.hashCode();
    }

}
