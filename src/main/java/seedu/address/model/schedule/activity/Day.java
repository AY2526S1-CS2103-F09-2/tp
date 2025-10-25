package seedu.address.model.schedule.activity;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.List;

/**
 * Represent's an activity's day in the schedule.
 * Guarantees: Immutable; is valid as declared in {@link #isValidDay(String)}.
 */
public class Day {

    public static final String MESSAGE_CONSTRAINTS =
            "Day of the activity must be in its full name, example: monday";

    public static final List<String> VALIDATION_REGEX = List.of("monday", "tuesday",
            "wednesday", "thursday", "friday", "saturday", "sunday");

    public final String value;

    /**
     * Constructs a {@code Day}.
     *
     * @param day A valid day.
     */
    public Day(String day) {
        requireNonNull(day);
        checkArgument(isValidDay(day), MESSAGE_CONSTRAINTS);
        String capital = day.substring(0, 1).toUpperCase();
        value = capital + day.substring(1);
    }

    /**
     * Returns true if a given string is a valid day.
     */
    public static boolean isValidDay(String test) {
        return VALIDATION_REGEX.contains(test.toLowerCase());
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Day)) {
            return false;
        }

        Day otherDay = (Day) other;
        return value.equals(otherDay.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
