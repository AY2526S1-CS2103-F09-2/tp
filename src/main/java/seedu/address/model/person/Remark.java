package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a remark about a Person in the address book.
 */
public class Remark {
    public static final String MESSAGE_CONSTRAINTS = "Remarks can take any values, and can be blank.";

    public final String value;

    /**
     * Constructs a {@code Remark}.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        this.value = remark.trim();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Remark
                && value.equals(((Remark) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

