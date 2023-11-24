import java.util.HashMap;

public class Expense {

    private int id;
    private String name;
    private double amount;
    private HashMap<User, Double> shareMap;

    public Expense(String name, double amount, HashMap<User, Double> shareMap) {
        this.id = idGenerator.getNextExpenseId();
        this.name = name;
        this.amount = amount;
        this.shareMap = shareMap;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public HashMap<User, Double> getShareMap() {
        return shareMap;
    }

    public void setShareMap(HashMap<User, Double> shareMap) {
        this.shareMap = shareMap;
    }
}
