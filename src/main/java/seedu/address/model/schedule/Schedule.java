package seedu.address.model.schedule;

import static java.util.Objects.requireNonNull;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.logic.DayAndTimeChecker;
import seedu.address.model.schedule.exceptions.MismatchedTimeException;
import seedu.address.model.schedule.exceptions.OverlappingActivityException;

public class Schedule {
    private final ObservableList<Activity> activities = FXCollections.observableArrayList();

    public void add(Activity toAdd) {
        requireNonNull(toAdd);
        if (DayAndTimeChecker.hasMismatchedStartAndEnd(toAdd)) {
            throw new MismatchedTimeException();
        }
        if (DayAndTimeChecker.hasNoOverlapWithOtherActivities(toAdd,  activities)) {
            throw new OverlappingActivityException();
        }
        activities.add(toAdd);
    }

    @Override
    public int hashCode() {
        return activities.hashCode();
    }
}
