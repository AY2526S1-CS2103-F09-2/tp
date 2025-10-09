package seedu.address.logic;

import java.time.LocalTime;

import javafx.collections.ObservableList;
import seedu.address.model.schedule.Activity;

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
    public static boolean hasNoOverlapWithOtherActivities(Activity activity, ObservableList<Activity> activities) {
        for (Activity existingActivity : activities) {
            if (isNotSameDay(activity, existingActivity)) {
                continue;
            }
            if (isEqualOrAfter(activity.getStartTime(), existingActivity.getEndTime())) {
                continue;
            }
            if (isEqualOrAfter(existingActivity.getStartTime(), activity.getEndTime())) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean isNotSameDay(Activity activity, Activity existingActivity) {
        return !activity.getDay().equals(existingActivity.getDay());
    }

    public static boolean hasMismatchedStartAndEnd(Activity activity) {
        return isEqualOrAfter(activity.getStartTime(), activity.getEndTime());
    }

    private static boolean isEqualOrAfter(LocalTime first, LocalTime second) {
        return first.compareTo(second) >= 0;
    }
}
