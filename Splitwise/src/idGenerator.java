public class idGenerator {
    private static int userId = 1;
    private static int expenseId = 1;

    public static int getNextExpenseId() {
        return expenseId++;
    }

    public static int getNextUserId() {
        return userId++;
    }
}
