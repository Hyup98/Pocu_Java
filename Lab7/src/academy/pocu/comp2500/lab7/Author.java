package academy.pocu.comp2500.lab7;

public class Author {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean equals(Object other) {
        System.out.print("equals호출\n");
        if (other == this) {
            return true;
        }

        if (other == null || !(other instanceof Author) || this.hashCode() != other.hashCode()) {
            return false;
        }

        Author tem = (Author) other;

        if (tem.firstName.equals(this.firstName)) {
            if (tem.lastName.equals(this.lastName)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public int hashCode() {
        System.out.print("\n"+this.firstName + " " + this.lastName + "\n");
        int tem = this.firstName.hashCode() + this.lastName.hashCode() * 11 ;
        System.out.print(tem + "해쉬값 호출 \n");

        return tem;
    }

}
