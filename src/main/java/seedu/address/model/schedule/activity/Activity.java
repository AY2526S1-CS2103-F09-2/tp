package seedu.address.model.schedule.activity;

import java.time.LocalTime;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents an Activity that the user has.
 */
public class Activity {
    private final Info info;
    private final Day day;
    private final Timeslot timeslot;

    /**
     * Constructs an Activity object.
     *
     * @param info Info of the activity.
     * @param day Day of the activity.
     * @param timeslot Timeslot of the activity.
     */
    public Activity(Info info, Day day, Timeslot timeslot) {
        this.info = info;
        this.day = day;
        this.timeslot = timeslot;
    }

    public Info getInfo() {
        return info;
    }

    public Day getDay() {
        return day;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public LocalTime[] getActivityTimes() {
        String[] activityTimesString = getTimeslot().value.split("-");
        LocalTime[] activityTimes = new LocalTime[activityTimesString.length];
        activityTimes[0] = LocalTime.parse(activityTimesString[0]);
        activityTimes[1] = LocalTime.parse(activityTimesString[1]);
        return activityTimes;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Activity)) {
            return false;
        }

        Activity otherActivity = (Activity) other;
        return info.equals(otherActivity.info)
                && day.equals(otherActivity.day)
                && timeslot.equals(otherActivity.timeslot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, day, timeslot);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("info", info)
                .add("day", day)
                .add("timeslot", timeslot)
                .toString();
    }
}
