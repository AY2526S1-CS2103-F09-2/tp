package seedu.address.model.schedule.exceptions;

/**
 * Signals that the operation will result in activities having overlapping timeslots.
 */
public class OverlappingActivityException extends RuntimeException {
    public OverlappingActivityException() {
        super("Timeslot for this activity overlaps with an existing activity");
    }
}
