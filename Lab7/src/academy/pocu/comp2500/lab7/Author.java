package academy.pocu.comp2500.lab7;

public class Author {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean equals(Author other) {
        if (other == this) {
            return true;
        }
        if(other.hashCode() != this.hashCode()) {
            return false;
        }

        if (other == null || !(other instanceof Author)) {
            return false;
        }

        if (other.firstName.equals(this.firstName)) {
            if (other.lastName.equals(this.lastName)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public int hashCode() {
        int tem = this.firstName.hashCode() ^ (this.lastName.hashCode() << 16);
        return tem;
    }

}
