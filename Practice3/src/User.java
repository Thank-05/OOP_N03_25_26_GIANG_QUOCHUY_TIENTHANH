public class User {
    private String name;
    private int age;
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { 
        if (age > 0) this.age = age; 
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { 
        if (email.contains("@")) this.email = email; 
    }

    public void displayInfo() {
        System.out.println("User: " + name + " | Age: " + age + " | Email: " + email);
    }
}
