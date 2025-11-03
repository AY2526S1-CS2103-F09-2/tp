package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.EditHoursCommand;

public class EditHoursCommandParserTest {

    private EditHoursCommandParser parser = new EditHoursCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, "h/3",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditHoursCommand.MESSAGE_USAGE));

        // no field specified
        assertParseFailure(parser, "1",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditHoursCommand.MESSAGE_USAGE));

        // no index and no field specified
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditHoursCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5 h/2",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditHoursCommand.MESSAGE_USAGE));

        // zero index
        assertParseFailure(parser, "0 h/2",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditHoursCommand.MESSAGE_USAGE));

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditHoursCommand.MESSAGE_USAGE));

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 i/ string",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditHoursCommand.MESSAGE_USAGE));
    }
}
