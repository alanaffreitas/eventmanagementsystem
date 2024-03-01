public class User {
    private String name;
    private String email;
    private String city;

    public User(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }
}
