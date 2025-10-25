package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.BillingContact;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final String imagePath;

    // Data fields
    private final Address address;
    private final TuitionDate date;
    private final TuitionSlot slot;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<BillingContact> contacts = new HashSet<>();
    private final Remark remark;


    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address,
                  TuitionDate date, TuitionSlot slot, Set<Tag> tags, Set<BillingContact> contacts, Remark remark) {
        requireAllNonNull(name, phone, email, address, date, tags, contacts);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.date = date;
        this.slot = slot;
        this.tags.addAll(tags);
        this.contacts.addAll(contacts);
        this.remark = remark;
        this.imagePath = "/images/default-avatar.png";
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public TuitionDate getDate() {
        return date;
    }

    public TuitionSlot getSlot() {
        return slot;
    }

    public Remark getRemark() {
        return remark;
    }

    public String getImagePath() {
        return imagePath;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns an immutable contact set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<BillingContact> getContacts() {
        return Collections.unmodifiableSet(contacts);
    }

    /**
     * Returns true if both persons have the everything except tags.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getAddress().equals(getAddress())
                && otherPerson.getDate().equals(getDate())
                && otherPerson.getSlot().equals(getSlot())
                && otherPerson.getRemark().equals(getRemark());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && address.equals(otherPerson.address)
                && date.equals(otherPerson.date)
                && slot.equals(otherPerson.slot)
                && tags.equals(otherPerson.tags)
                && contacts.equals(otherPerson.contacts)
                && remark.equals(otherPerson.remark);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, date, slot, tags, contacts, remark);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("date", date)
                .add("slot", slot)
                .add("tags", tags)
                .add("contacts", contacts)
                .add("remark", remark)
                .toString();
    }

}
