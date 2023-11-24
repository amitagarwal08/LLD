import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SplitwiseDAO {

    private HashMap<String, User> userMap;
    private List<Expense> expenseList;

    public SplitwiseDAO() {
        userMap = new HashMap<>();
        expenseList = new ArrayList<>();
    }

    public void updateUserMap(String name, User user) {
        userMap.put(name, user);
        System.out.println("User map : " + userMap);
    }

    public HashMap<String, User> getUserMap() {
        return userMap;
    }

    public User getUser(String name) {
        if(userMap.containsKey(name)) {
            return userMap.get(name);
        }

        return null;
    }

    public void updateExpenseList(Expense e) {
        expenseList.add(e);
        System.out.println(expenseList);
    }
}
