package seedu.address.model.schedule;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.logic.DayAndTimeChecker;
import seedu.address.model.schedule.activity.Activity;
import seedu.address.model.schedule.exceptions.ActivityNotFoundException;
import seedu.address.model.schedule.exceptions.DuplicateActivityException;
import seedu.address.model.schedule.exceptions.MismatchedTimeException;
import seedu.address.model.schedule.exceptions.OverlappingActivityException;

/**
 * Represents the user's schedule with all their activities.
 */
public class Schedule implements ReadOnlySchedule {
    private final ObservableList<Activity> activities = FXCollections.observableArrayList();
    private final ObservableList<Activity> unmodifiableActivities =
            FXCollections.unmodifiableObservableList(activities);

    public Schedule() {
    }

    /**
     * Creates a Schedule using the Activities in the {@code schedule}.
     */
    public Schedule(ReadOnlySchedule schedule) {
        this();
        resetData(schedule);
    }

    /**
     * Replace the contents of the activities with {@code activities}.
     * {@code activities} must not contain duplicate activities.
     * The start time of the activities must be before its end time.
     * The activities must not overlap.
     */
    public void setActivities(List<Activity> activities) {
        requireAllNonNull(activities);
        for (Activity activity : activities) {
            add(activity);
        }
    }

    /**
     * Resets the existing data of this {@code Schedule} with {@code newSchedule}.
     */
    public void resetData(ReadOnlySchedule newSchedule) {
        requireNonNull(newSchedule);
        setActivities(newSchedule.getActivities());
    }

    /**
     * Returns true if an activity with the same information as {@code toCheck} exists in schedule.
     */
    public boolean hasActivity(Activity toCheck) {
        requireNonNull(toCheck);
        return activities.contains(toCheck);
    }

    /**
     * Returns true if the {@code toCheck} has mismatched start and end time.
     */
    public boolean hasMismatchedTime(Activity toCheck) {
        requireNonNull(toCheck);
        return DayAndTimeChecker.hasMismatchedStartAndEnd(toCheck);
    }

    /**
     * Returns true if the {@code toCheck} overlaps with those already in schedule.
     */
    public boolean hasOverlap(Activity toCheck) {
        requireNonNull(toCheck);
        return DayAndTimeChecker.hasOverlapWithOtherActivities(toCheck, activities);
    }

    /**
     * Returns an {@code Optional<Activity>} if an activity with the specified day and timeslot is found
     * from the schedule, returns an {@code Optional<Empty>} otherwise.
     */
    public Optional<Activity> getActivity(Activity toCheck) {
        requireNonNull(toCheck);
        return DayAndTimeChecker.getSameDateTimeActivity(toCheck, activities);
    }

    /**
     * Adds an activity to schedule.
     * The activity must not already exist in the schedule.
     * The start time of the activity must be before its end time.
     * The activity must not overlap with existing activities.
     */
    public void add(Activity toAdd) throws DuplicateActivityException, MismatchedTimeException,
            OverlappingActivityException {
        requireNonNull(toAdd);
        if (hasActivity(toAdd)) {
            throw new DuplicateActivityException();
        }
        if (hasMismatchedTime(toAdd)) {
            throw new MismatchedTimeException();
        }
        if (hasOverlap(toAdd)) {
            throw new OverlappingActivityException();
        }
        activities.add(toAdd);
    }

    /**
     * Deletes an activity from the schedule.
     * The activity must exist in the schedule.
     */
    public void delete(Activity toDelete) throws ActivityNotFoundException {
        requireNonNull(toDelete);
        if (!activities.remove(toDelete)) {
            throw new ActivityNotFoundException();
        }
    }

    /**
     * Returns the activities as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Activity> asUnmodifiableObservableList() {
        return unmodifiableActivities;
    }

    @Override
    public int hashCode() {
        return activities.hashCode();
    }

    @Override
    public String toString() {
        return activities.toString();
    }

    @Override
    public ObservableList<Activity> getActivities() {
        return asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Schedule)) {
            return false;
        }
        Schedule otherSchedule = (Schedule) other;
        return this.activities.equals(otherSchedule.activities);
    }
}
