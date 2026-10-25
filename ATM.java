//  THIS IS ATM PROJECT
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int balance = 1000;

        while (true) {
            System.out.println("\nATM Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    int deposit = input.nextInt();
                    balance += deposit;
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawal = input.nextInt();
                    if (withdrawal <= balance) {
                        balance -= withdrawal;
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
