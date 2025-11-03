package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.logic.commands.EditHoursCommand.MESSAGE_LARGE_HOURS;
import static seedu.address.logic.commands.EditHoursCommand.MESSAGE_NEGATIVE_OR_ZERO_HOURS;
import static seedu.address.testutil.TypicalActivities.getTypicalSchedule;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for EditHoursCommand.
 */
public class EditHoursCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), getTypicalSchedule(), new UserPrefs());

    @Test
    public void execute_largeHours_failure() {
        EditHoursCommand editHoursCommand = new EditHoursCommand(INDEX_FIRST_PERSON,
                10000);
        assertCommandFailure(editHoursCommand, model, MESSAGE_LARGE_HOURS);
    }

    @Test
    public void execute_negativeOrZeroHours_failure() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        EditHoursCommand editHoursCommand = new EditHoursCommand(INDEX_FIRST_PERSON, -2);
        assertCommandFailure(editHoursCommand, model, MESSAGE_NEGATIVE_OR_ZERO_HOURS);
    }

    @Test
    public void execute_invalidPersonIndex_failure() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        Index outOfBoundIndex = INDEX_SECOND_PERSON;
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getPersonList().size());
        EditHoursCommand editHoursCommand = new EditHoursCommand(outOfBoundIndex, 2);
        assertCommandFailure(editHoursCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        final EditHoursCommand standardCommand = new EditHoursCommand(INDEX_FIRST_PERSON, 2);

        // same values -> returns true
        EditHoursCommand commandWithSameValues = new EditHoursCommand(INDEX_FIRST_PERSON, 2);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditHoursCommand(INDEX_SECOND_PERSON, 2)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditHoursCommand(INDEX_FIRST_PERSON, 1)));
    }

    @Test
    public void toStringMethod() {
        Index index = Index.fromOneBased(1);
        EditHoursCommand editHoursCommand = new EditHoursCommand(index, 2);
        String expected = EditHoursCommand.class.getCanonicalName() + "{targetIndex=" + index + ", editedHours="
                + 2 + "}";
        assertEquals(expected, editHoursCommand.toString());
    }
}


