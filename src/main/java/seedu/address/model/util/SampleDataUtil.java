package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.TuitionDate;
import seedu.address.model.person.TuitionSlot;
import seedu.address.model.tag.BillingContact;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), new TuitionDate("monday"),
                    new TuitionSlot("16:00-18:00"), getTagSet("friends"),getContactSet("88245781")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new TuitionDate("monday"),
                    new TuitionSlot("13:00-21:00"), getTagSet("colleagues", "friends"),
                    getContactSet("88245781")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new TuitionDate("tuesday"),
                    new TuitionSlot("14:00-16:00"),
                getTagSet("neighbours"), getContactSet("88245781")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new TuitionDate("sunday"),
                    new TuitionSlot("08:00-09:00"),
                getTagSet("family"), getContactSet("88245781")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), new TuitionDate("thursday"),
                    new TuitionSlot("12:00-13:00"),
                getTagSet("classmates"), getContactSet("88245781")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), new TuitionDate("tuesday"),
                    new TuitionSlot("16:00-18:00"),
                getTagSet("colleagues"), getContactSet("88245781"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a contact set containing the list of strings given.
     */
    public static Set<BillingContact> getContactSet(String... strings) {
        return Arrays.stream(strings)
                .map(BillingContact::new)
                .collect(Collectors.toSet());
    }

}
