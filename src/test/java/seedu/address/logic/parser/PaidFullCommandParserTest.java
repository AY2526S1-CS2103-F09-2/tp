package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.PaidFullCommand;

public class PaidFullCommandParserTest {

    private PaidFullCommandParser parser = new PaidFullCommandParser();

    @Test
    public void parse_invalidIndex_failure() {
        // empty
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, PaidFullCommand.MESSAGE_USAGE));
        // negative
        assertParseFailure(parser, "-1",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, PaidFullCommand.MESSAGE_USAGE));
    }
}
