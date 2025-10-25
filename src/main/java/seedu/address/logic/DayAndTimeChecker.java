package seedu.address.logic;

import java.time.LocalTime;
import java.util.Optional;

import javafx.collections.ObservableList;
import seedu.address.model.schedule.activity.Activity;

/**
 * Checks that the day and time provided for an activity is valid
 * and does not overlap with other activities.
 */
public class DayAndTimeChecker {

    /**
     * Returns true if the activity does not overlap with any existing activity
     * in the user's schedule.
     *
     * @param activity Activity to be added to schedule.
     * @param activities Existing list of activities.
     * @return true if there is no overlap, false otherwise.
     */
    public static boolean hasOverlapWithOtherActivities(Activity activity, ObservableList<Activity> activities) {
        LocalTime[] activityTimes = activity.getActivityTimes();
        for (Activity existingActivity : activities) {
            LocalTime[] existingActivityTimes = existingActivity.getActivityTimes();
            if (isNotSameDay(activity, existingActivity)) {
                continue;
            }
            if (isEqualOrAfter(activityTimes[0], existingActivityTimes[1])) {
                continue;
            }
            if (isEqualOrAfter(existingActivityTimes[0], activityTimes[1])) {
                continue;
            }
            return true;
        }
        return false;
    }

    /**
     * Returns an {@code Optional<Activity>} if an activity with the specified day and timeslot is found
     * from the schedule, returns an {@code Optional<Empty>} otherwise.
     */
    public static Optional<Activity> getSameDateTimeActivity(Activity activity, ObservableList<Activity> activities) {
        LocalTime[] activityTimes = activity.getActivityTimes();
        for (Activity existingActivity : activities) {
            LocalTime[] existingActivityTimes = existingActivity.getActivityTimes();
            if (isNotSameDay(activity, existingActivity)) {
                continue;
            }
            if (!isEqual(activityTimes[0], existingActivityTimes[0])) {
                continue;
            }
            if (!isEqual(activityTimes[1], existingActivityTimes[1])) {
                continue;
            }
            return Optional.of(existingActivity);
        }
        return Optional.empty();
    }

    /**
     * Returns true if the start and end time of the activity does not overlap.
     */
    public static boolean hasMismatchedStartAndEnd(Activity activity) {
        String[] activityTimings = activity.getTimeslot().value.split("-");
        LocalTime startTime = LocalTime.parse(activityTimings[0]);
        LocalTime endTime = LocalTime.parse(activityTimings[1]);
        return isEqualOrAfter(startTime, endTime);
    }

    private static boolean isNotSameDay(Activity activity, Activity existingActivity) {
        return !activity.getDay().equals(existingActivity.getDay());
    }

    private static boolean isEqual(LocalTime first, LocalTime second) {
        return first.equals(second);
    }

    private static boolean isEqualOrAfter(LocalTime first, LocalTime second) {
        return first.compareTo(second) >= 0;
    }
}
