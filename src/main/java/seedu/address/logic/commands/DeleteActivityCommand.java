package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SLOT;

import java.util.Optional;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.schedule.activity.Activity;
import seedu.address.model.schedule.activity.Day;
import seedu.address.model.schedule.activity.Info;
import seedu.address.model.schedule.activity.Timeslot;
import seedu.address.model.schedule.activity.Tuition;

/**
 * Deletes an activity identified using the day and timeslot of the activity in the schedule.
 */
public class DeleteActivityCommand extends Command {

    public static final String COMMAND_WORD = "deleteactivity";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the activity identified by its day and timeslot.\n"
            + "Parameters: "
            + PREFIX_DATE + "DAY_OF_WEEK "
            + PREFIX_SLOT + "START_TIME-END_TIME\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DATE + "friday "
            + PREFIX_SLOT + "0900-1000";

    public static final String MESSAGE_DELETE_ACTIVITY_SUCCESS = "Deleted Activity: %1$s";
    public static final String MESSAGE_ACTIVITY_NOT_FOUND = "Activity not found";
    public static final String MESSAGE_ACTIVITY_IS_TUITION = "Specified date and timeslot is for a tuition"
            + ", cannot be deleted via this command";


    private final Day day;
    private final Timeslot timeslot;

    /**
     * Creates a DeleteActivityCommand based on the day and timeslot.
     */
    public DeleteActivityCommand(Day day, Timeslot timeslot) {
        this.day = day;
        this.timeslot = timeslot;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Activity toDelete = new Activity(new Info("to delete"), day, timeslot);
        Optional<Activity> activityInSchedule = model.getSameDateTimeActivity(toDelete);
        if (activityInSchedule.isEmpty()) {
            throw new CommandException(MESSAGE_ACTIVITY_NOT_FOUND);
        } else if (activityInSchedule.get() instanceof Tuition) {
            throw new CommandException(MESSAGE_ACTIVITY_IS_TUITION);
        } else {
            model.deleteActivity(activityInSchedule.get());
            return new CommandResult(String.format(MESSAGE_DELETE_ACTIVITY_SUCCESS,
                    Messages.format(activityInSchedule.get())));
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteActivityCommand)) {
            return false;
        }

        DeleteActivityCommand otherDeleteActivityCommand = (DeleteActivityCommand) other;
        return day.equals(otherDeleteActivityCommand.day)
                && timeslot.equals(otherDeleteActivityCommand.timeslot);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("day", day)
                .add("timeslot", timeslot)
                .toString();
    }
}
