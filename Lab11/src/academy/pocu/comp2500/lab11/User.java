package academy.pocu.comp2500.lab11;

import java.util.UUID;

public class User {
    private Department department;
    private String name;

    public User(Department dep, String name) {
        this.name = name;
        this.department = dep;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }
}
