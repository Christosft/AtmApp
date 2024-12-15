package AtmApp;

import java.util.Scanner;

/**
 * Creation of a simple Atm program
 * with menu and the usual transactions
 */

public class AtmApp {

    static double account = 1500;
    static double nAccount;
    static double newAccount;
    static double deposit = 0;
    static double withdraw = 0;
    static double dAccount;
    static double wAccount;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(atmMenu());

    }

    public static double atmMenu() {

        int inputChoice;

        do {
            System.out.println("Please make a selection: ");
            System.out.println("1. Make a deposit");
            System.out.println("2. Make a withdraw");
            System.out.println("3. Check account balance");
            System.out.println("4. Make accounts transfers");
            System.out.println("5. Exit");
            inputChoice = scanner.nextInt();

            if (inputChoice == 1) {
                System.out.println("Deposit. Please insert an amount: ");
                deposit = scanner.nextDouble();
                dAccount = account + deposit;
                System.out.println("Your new balance after the deposit is: " + dAccount);
                break;
            } else if (inputChoice == 2) {
                System.out.println("Withdraw. Please insert an amount: ");
                withdraw = scanner.nextDouble();
                wAccount = account - withdraw;
                System.out.println("Your new balance after the withdraw is: " + wAccount);
                break;
            }
            else if (inputChoice == 3) {
                if ((dAccount >= account)) {
                    nAccount = dAccount;
                    System.out.println("Your account balance is: " + nAccount);
                    break;
                } else if ((wAccount != account)) {
                    newAccount = wAccount;
                    System.out.println("Your account balance is: " + newAccount);
                    break;
                }
            }

        } while (inputChoice != 5);
            return atmMenu();

    }
}
