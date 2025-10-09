package seedu.address.model.schedule;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Activity {
    String description;
    DayOfWeek day;
    LocalTime startTime;
    LocalTime endTime;

    public Activity(String description, DayOfWeek day, LocalTime startDateTime, LocalTime endDateTime) {
        this.description = description;
        this.day = day;
        this.startTime = startDateTime;
        this.endTime = endDateTime;
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
