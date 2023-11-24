import java.util.HashMap;
import java.util.TreeMap;

public class User {

    private int id;
    private String name;
    private String email;
    private String mobile;
    private double amount;
    public HashMap<User, Double> oweMap;

    public User(String name, String email, String mobile) {
        this.id = idGenerator.getNextUserId();
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.oweMap = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
