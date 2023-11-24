import java.util.HashMap;
import java.util.Map;

public class SplitwiseService {

    private SplitwiseDAO dao;

    public SplitwiseService() {
        dao = new SplitwiseDAO();
    }

    public void addUser(String name, String email, String mobile) {
        User user = new User(name.trim(), email.trim(), mobile.trim());
        dao.updateUserMap(name, user);

        System.out.println("Successfully added user : " + name);
    }

    public void addExpense(String expense) {
        String expenseArr[] = expense.trim().split(" ");
        double amount = Double.parseDouble(expenseArr[1]);
        int usersCount = Integer.parseInt(expenseArr[2]);
        String expenseType = expenseArr[usersCount+3];

        switch(expenseType) {
            case "EQUAL":
                double eachShare = amount/usersCount;
//                double firstShare = amount - eachShare * (usersCount-1);
                HashMap<User, Double> expenseMap = new HashMap<>();
//                expenseMap.put(dao.getUser(expenseArr[3]), firstShare);
                for(int i=0; i<usersCount; i++) {
                    expenseMap.put(dao.getUser(expenseArr[i+3]), eachShare);
                }

                Expense e = new Expense(expenseArr[0], amount, expenseMap);
                dao.updateExpenseList(e);

                User payer = dao.getUser(expenseArr[0]);
                for(int i=0; i<usersCount; i++) {
                    User curr = dao.getUser(expenseArr[i + 3]);
                    if (curr != payer) {
                        double oweAmt = payer.oweMap.getOrDefault(curr, 0.00);
                        oweAmt -= eachShare;
                        payer.oweMap.put(curr, oweAmt);
                        curr.oweMap.put(payer, oweAmt * -1);
                    }
                }

                break;
            default:
                System.out.println("Given Expense Type not supported");

        }
    }

    public void showOweMapForUser(String u) {
        User user = dao.getUser(u);
        if(user==null) {
            System.out.println("No user found");
            return;
        }

        HashMap<User, Double> map = user.oweMap;

        if(map.isEmpty()) {
            System.out.println("No balances");
            return;
        }

        for(Map.Entry<User, Double> m : map.entrySet()) {
            if(m.getValue() > 0) {
                System.out.println(u + " owes " + m.getKey().getName() + ": " + m.getValue());
            } else {
                System.out.println(m.getKey().getName() + " owes " + u + ": " + m.getValue()* -1);
            }
        }
    }

    public void showOweMapForAllUsers() {
        HashMap<String, User> userMap = dao.getUserMap();
        boolean flag = false;
        for(Map.Entry<String, User> m : userMap.entrySet()){
            User curr = m.getValue();
            HashMap<User, Double> oweMap = curr.oweMap;
            if(!oweMap.isEmpty()) {
                flag = true;
            }
            for(Map.Entry<User, Double> owe: oweMap.entrySet()) {
                if(owe.getValue() > 0){
                    System.out.println(curr.getName() + " owes " + owe.getKey().getName() + ": " + owe.getValue());
                }
            }
        }

        if(!flag) {
            System.out.println("****No Balances****");
        }
    }
}
