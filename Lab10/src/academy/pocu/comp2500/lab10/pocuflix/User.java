package academy.pocu.comp2500.lab10.pocuflix;

public final class User {
    private final String username;
    private final String password;

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null
                || !(obj instanceof User)
                || this.hashCode() != obj.hashCode()) {
            return false;
        }

        User other = (User) obj;
        return this.username.equals(other.username) && this.password.equals(other.password);
    }

    @Override
    public int hashCode() {
        return this.username.hashCode() ^ (this.password.hashCode() << 16);
    }
}
