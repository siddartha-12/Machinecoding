package splitwise;

// here we can implement builder pattern
public class User {
    private int id;
    private String name;

    public User(String name, int id, String phoneNumber, String email) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private String phoneNumber;
    private String email;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
