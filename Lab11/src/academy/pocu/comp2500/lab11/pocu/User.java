package academy.pocu.comp2500.lab11.pocu;

public class User {
    private String firstName;
    private String lastName;
    private Department department;

    public User() {
        loadUserMock();
    }

    // mock
    User(final String firstName, final String lastName, final Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public Department getDepartment() {
        return this.department;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null
                || !(obj instanceof academy.pocu.comp2500.lab11.pocu.User)
                || this.hashCode() != obj.hashCode()) {
            return false;
        }

        User other = (User) obj;
        return this.firstName.equals(other.firstName)
                && this.lastName.equals(other.lastName)
                && this.department == other.department;
    }

    @Override
    public int hashCode() {
        int hash = this.firstName.hashCode() ^ (this.lastName.hashCode() << 16);
        hash += this.department.hashCode();

        return hash;
    }

    private void loadUserMock() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.department = Department.ENGINEERING;
    }
}
