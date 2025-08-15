import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        //System.out.print("Enter account number: ");
        String accNum = Account.accontNumbergenerartion();
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        System.out.println("Your Account Number is : " + accNum);

        Account account = new Account(accNum, name, balance);


        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depAmount = sc.nextDouble();
                    account.deposit(depAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double witAmount = sc.nextDouble();
                    account.withdraw(witAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: ₹" + String.format("%.2f", account.getBalance()));
                    break;
                case 4:
                    account.showTransactions();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
