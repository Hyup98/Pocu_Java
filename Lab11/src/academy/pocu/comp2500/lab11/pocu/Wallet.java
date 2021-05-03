package academy.pocu.comp2500.lab11.pocu;

import java.util.HashSet;

public class Wallet {
    private int amount;

    public Wallet(final User user) throws IllegalAccessException {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }

        HashSet<Department> departments = retrieveDepartmentsMock();

        if (!departments.contains(user.getDepartment())) {
            throw new PermanentlyClosedException("department is not found or permanently closed");
        }

        HashSet<User> users = retrieveAllowedUsersMock(user.getDepartment());

        if (!users.contains(user)) {
            throw new IllegalAccessException("user not allowed to access");
        }

        this.amount = retrieveAmountMock();
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean deposit(final int amount) {
        if (amount <= 0) {
            return false;
        }

        this.amount += amount;

        return true;
    }

    public boolean withdraw(final int amount) {
        if (amount <= 0 || this.amount < amount) {
            return false;
        }

        this.amount -= amount;
        return true;
    }

    private static int retrieveAmountMock() {
        return 100;
    }

    private static HashSet<Department> retrieveDepartmentsMock() {
        HashSet<Department> set = new HashSet<>();

        set.add(Department.ENGINEERING);
        set.add(Department.OPERATION);
        set.add(Department.QUALITY_ASSURANCE);

        return set;
    }

    private static HashSet<User> retrieveAllowedUsersMock(Department department) {
        HashSet<User> set = new HashSet<>();

        set.add(new User("Jane", "Many", department));
        set.add(new User("John", "Doe", department));
        set.add(new User("Winnie", "the Poo", department));

        return set;
    }
}
