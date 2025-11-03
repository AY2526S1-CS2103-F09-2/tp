package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.GetAmountOwedCommand;
import seedu.address.model.person.Name;

public class GetAmountOwedCommandParserTest {

    private GetAmountOwedCommandParser parser = new GetAmountOwedCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // empty
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, GetAmountOwedCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidName_failure() {
        // symbols
        assertParseFailure(parser, "4$3",
                Name.MESSAGE_CONSTRAINTS);
    }
}
