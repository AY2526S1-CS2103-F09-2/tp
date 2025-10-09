package seedu.address.model.schedule.exceptions;

public class OverlappingActivityException extends RuntimeException {
    public OverlappingActivityException() {
        super("Timeslot for this activity overlaps with an existing activity");
    }
}
