package seedu.address.model.schedule.exceptions;

/**
 * Signals that the operation is not accepted as start time of the activity is not before its end time.
 */
public class MismatchedTimeException extends RuntimeException {
    public MismatchedTimeException() {
        super("Start time of activity is equal to or after end time");
    }
}
