package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.BY_DATE_THEN_SLOT;
import static seedu.address.model.Model.IS_TUTEE;

import seedu.address.model.Model;

/**
 * Sorts and lists all tutee in the address book by the date and time of their class.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sortbydate";

    public static final String MESSAGE_SUCCESS = "All your tutees sorted by date and time";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(IS_TUTEE);
        model.sortListByDate(BY_DATE_THEN_SLOT);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
