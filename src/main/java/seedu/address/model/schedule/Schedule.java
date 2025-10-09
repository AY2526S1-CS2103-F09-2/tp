package seedu.address.model.schedule;

import static java.util.Objects.requireNonNull;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.logic.DayAndTimeChecker;
import seedu.address.model.schedule.exceptions.MismatchedTimeException;
import seedu.address.model.schedule.exceptions.OverlappingActivityException;

/**
 * Represents the user's schedule with all their activities.
 */
public class Schedule {
    private final ObservableList<Activity> activities = FXCollections.observableArrayList();

    /**
     * Adds an activity to schedule.
     * The start time of the activity must be before its end time.
     * The activity must not overlap with existing activities.
     *
     * @param toAdd Activity to be added to schedule.
     */
    public void add(Activity toAdd) {
        requireNonNull(toAdd);
        if (DayAndTimeChecker.hasMismatchedStartAndEnd(toAdd)) {
            throw new MismatchedTimeException();
        }
        if (DayAndTimeChecker.hasNoOverlapWithOtherActivities(toAdd, activities)) {
            throw new OverlappingActivityException();
        }
        activities.add(toAdd);
    }

    @Override
    public int hashCode() {
        return activities.hashCode();
    }
}
