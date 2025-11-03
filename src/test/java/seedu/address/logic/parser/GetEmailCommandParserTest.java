package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.GetEmailCommand;
import seedu.address.model.person.Name;

public class GetEmailCommandParserTest {

    private GetEmailCommandParser parser = new GetEmailCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // empty
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, GetEmailCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidName_failure() {
        // symbols
        assertParseFailure(parser, "4$3",
                Name.MESSAGE_CONSTRAINTS);
    }
}
