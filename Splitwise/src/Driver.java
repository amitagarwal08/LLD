import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        SplitwiseService service = new SplitwiseService();
        Scanner sc = new Scanner(System.in);

        outer: while(true) {
            System.out.print("\nWelcome to Splitwise!!\n Enter your choice from below:\n 1. Add user\n 2. Add Expense\n 3. Show user's owe amount\n 4. Show all users owe amount\n 5. Exit\n\n Enter your input:");

            switch(sc.nextInt()) {
                case 1:
                    System.out.println("Enter User details");
                    System.out.print("Enter name: ");
                    String name = sc.next();
//                    System.out.print("Enter email: ");
//                    String email = sc.next();
//                    System.out.print("Enter mobile: ");
//                    String mobile = sc.next();

//                    service.addUser(name, email, mobile);
                    service.addUser(name, "abc@example.com", "1234567890");
                    break;

                case 2:
                    System.out.println("Enter Expense");
                    String expense = sc.next();
                    expense += sc.nextLine();
//                    System.out.println(expense);
                    service.addExpense(expense);
                    break;

                case 3:
                    System.out.println("Enter user");
                    String user = sc.next();
                    service.showOweMapForUser(user);
                    break;

                case 4:
                    service.showOweMapForAllUsers();
                    break;

                case 5:
                    System.out.println("Exiting app...");
                    break outer;

                default:
                    System.out.println("Invalid input. Please provide valid input");
                    break;
            }
        }
    }
}
