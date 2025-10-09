package seedu.address.model;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.person.Person;
import seedu.address.model.person.TuitionDate;
import seedu.address.model.person.TuitionSlot;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /** Predicate that evalutes to true if the person is tagged as a tutee*/
    Predicate<Person> IS_TUTEE =
            person -> person.getTags().stream()
                    .anyMatch(tag -> tag.tagName.equalsIgnoreCase("tutee"));

    /** Comparator for sorting tutees by tuition date (Mon–Sun) and then by tuition slot (earlier time first)*/
    Comparator<Person> BY_DATE_THEN_SLOT = (p1, p2) -> {
        TuitionDate d1 = p1.getDate();
        TuitionDate d2 = p2.getDate();
        TuitionSlot s1 = p1.getSlot();
        TuitionSlot s2 = p2.getSlot();

        // --- Compare by day of the week first ---
        List<String> dayOrder = List.of(
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        int dayCompare = Integer.compare(
                dayOrder.indexOf(d1.date),
                dayOrder.indexOf(d2.date)
        );

        if (dayCompare != 0) {
            return dayCompare;
        }

        // --- Then compare by start time (HH:mm) ---
        String start1 = s1.slot.split("-")[0];
        String start2 = s2.slot.split("-")[0];
        return start1.compareTo(start2);
    };

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    void sortListByDate(Comparator<Person> comparator);
}
