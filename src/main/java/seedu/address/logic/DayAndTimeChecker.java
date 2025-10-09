package seedu.address.logic;

import java.time.LocalTime;

import javafx.collections.ObservableList;
import seedu.address.model.schedule.Activity;

public class DayAndTimeChecker {
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
