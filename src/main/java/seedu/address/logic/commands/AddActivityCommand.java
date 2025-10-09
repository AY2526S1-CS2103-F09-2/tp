package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.schedule.Activity;

/**
 * Adds an Activity to Schedule.
 */
public class AddActivityCommand extends Command {
    public static final String COMMAND_WORD = "addactivity";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds the user's activity.\n"
            + "Parameters: ACTIVITY_DESCRIPTION DAY_OF_WEEK START_TIME-END_TIME\n"
            + "Example: " + COMMAND_WORD + " lesson friday 0900-1000";

    public static final String MESSAGE_ADD_ACTIVITY_SUCCESS = "Added activity: %1$s";
    public static final String MESSAGE_OVERLAP_TIMING = "There is already something scheduled during this timeslot";

    private final Activity activity;

    public AddActivityCommand(Activity activity) {
        this.activity = activity;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        return new CommandResult(String.format(MESSAGE_ADD_ACTIVITY_SUCCESS, Messages.format(activity)));
    }
}
