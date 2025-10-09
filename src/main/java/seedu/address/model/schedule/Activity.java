package seedu.address.model.schedule;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Represents an Activity that the user has.
 */
public class Activity {
    private final String description;
    private final DayOfWeek day;
    private final LocalTime startTime;
    private final LocalTime endTime;

    /**
     * Constructs an Activity object.
     *
     * @param description Description of the activity.
     * @param day Day of the activity.
     * @param startTime Start time of the activity.
     * @param endTime End time of the activity.
     */
    public Activity(String description, DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
