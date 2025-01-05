package AtmApp;

import java.util.Scanner;

public class AtmApp {

    static double primaryAccount = 1500;
    static double backupAccount = 1000;
    static double newBackupAccount;
    static double transferWithdraw = 0;
    static double deposit = 0;
    static double withdraw = 0;
    static double dAccount;
    static double wAccount;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        atmAppMenu();

    }

        public static void atmAppMenu() {
            while (true) {
                System.out.println("Atm app menu: ");
                System.out.println("1. Make a deposit");
                System.out.println("2. Make a withdraw");
                System.out.println("3. Account balance");
                System.out.println("4. account transfer");
                System.out.println("5. Exit Atm App menu");

                int inputChoice = scanner.nextInt();

                switch (inputChoice) {
                    case 1:
                        System.out.println("Select the deposit amount");
                        deposit = scanner.nextDouble();
                        break;

                    case 2:
                        System.out.println("Select the withdraw amount");
                        withdraw = scanner.nextDouble();
                        break;

                    case 3:
                        System.out.println("Check account balance");
                        if (deposit > 0) {
                            dAccount = primaryAccount + deposit;
                            System.out.println("Your account balance is: " + dAccount);
                        } else if (withdraw > 0) {
                            wAccount = primaryAccount - withdraw;
                            System.out.println("Your account balance is: " + wAccount);

                        } break;

                    case 4:
                        System.out.println("Account transfer");
                        transferWithdraw = scanner.nextDouble();
                        newBackupAccount = backupAccount + transferWithdraw;
                        System.out.println("Your backup account balance was: " + backupAccount +"\n" +
                                "Your new balance is: " + newBackupAccount);
                        break;

                    case 5:
                        System.out.println("Exit menu.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Wrong entry. \n" +
                                "Please make a selection.");

                }
            }
        }
    }
