package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REMARK_TUTEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SLOT_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.BillablePerson;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code BillablePerson} objects to be used in tests.
 */
public class TypicalPersons {

    public static final BillablePerson ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253").withDate("Monday").withSlot("09:00-11:00")
            .withTags("friends").withContacts("81250293").withRemark("New tutee").build();
    public static final BillablePerson BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432").withDate("Wednesday").withSlot("19:00-21:00")
            .withTags("owesMoney", "friends").withContacts("81250293").build();
    public static final BillablePerson CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").withDate("Tuesday")
            .withSlot("16:00-18:00").build();
    public static final BillablePerson DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withRemark("Exams soon")
            .withDate("Tuesday").withSlot("19:00-21:00").withTags("friends").build();
    public static final BillablePerson ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("94382224")
            .withEmail("werner@example.com").withAddress("michegan ave").withDate("Thursday").withSlot("16:00-18:00")
            .build();
    public static final BillablePerson FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("94824227")
            .withEmail("lydia@example.com").withAddress("little tokyo").withDate("Thursday").withSlot("19:00-21:00")
            .build();
    public static final BillablePerson GEORGE = new PersonBuilder().withName("George Best").withPhone("94824421")
            .withEmail("anna@example.com").withAddress("4th street").withDate("Saturday").withSlot("17:00-19:00")
            .build();

    // Manually added
    public static final BillablePerson HOON = new PersonBuilder().withName("Hoon Meier").withPhone("84824224")
            .withEmail("stefan@example.com").withAddress("little india").withDate("Wednesday").withSlot("16:00-18:00")
            .build();
    public static final BillablePerson IDA = new PersonBuilder().withName("Ida Mueller").withPhone("84823131")
            .withEmail("hans@example.com").withAddress("chicago ave").withDate("Wednesday").withSlot("16:00-18:00")
            .build();

    // Manually added - BillablePerson's details found in {@code CommandTestUtil}
    public static final BillablePerson AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withDate(VALID_DATE_AMY)
            .withTags(VALID_TAG_FRIEND).withSlot(VALID_SLOT_AMY).withRemark(VALID_REMARK_TUTEE).build();
    public static final BillablePerson BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .withRemark(VALID_REMARK_TUTEE).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
