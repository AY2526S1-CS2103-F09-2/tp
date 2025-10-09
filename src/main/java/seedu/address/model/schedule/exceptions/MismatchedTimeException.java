package seedu.address.model.schedule.exceptions;

public class MismatchedTimeException extends RuntimeException {
    public MismatchedTimeException() {
        super("Start time of activity is equal to or after end time");
    }
}
