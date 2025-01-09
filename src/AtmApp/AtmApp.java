package AtmApp;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import AtmApp.ClientModel.ClientModel;


/**
 * This is a basic ATM program.
 * I use simple coding for all the function of the app.
 *
 * @author chris
 * @version 0.2
 */

public class AtmApp {


    static double primaryAccount;
    static double backupAccount;
    static double transferWithdraw = 0;
    static double deposit = 0;
    static double withdraw = 0;
    static ClientModel clientModel;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        clientModel = new ClientModel(1651, "Chris", "Doe", "115424856", "6948576978", "Athens", 3000, 1500);
        primaryAccount = clientModel.getPrimaryAccount();
        backupAccount = clientModel.getBackupAccount();
        pinNumber();
        atmAppMenu();


    }

    public static void atmAppMenu() throws IOException {
            while (true) {
                System.out.println("Atm app menu: Hello " + clientModel.getFirstname() + " " + clientModel.getLastname());
                System.out.println("1. Make a deposit");
                System.out.println("2. Make a withdraw");
                System.out.println("3. Account balance");
                System.out.println("4. Account transfer");
                System.out.println("5. Exit Atm App menu");

                int inputChoice = scanner.nextInt();

                switch (inputChoice) {
                    case 1:
                        depositCase();
                        break;

                    case 2:
                        withdrawCase();
                        break;

                    case 3:
                        accountsBalance();
                        break;

                    case 4:
                        accountsTransfer();
                        break;

                    case 5:
                        System.out.println("Exit menu.");
                        pinNumber();
                        atmAppMenu();
                        return;

                            default:
                                System.err.println("Wrong entry. \n" +
                                        "Please make a selection.");
                        }

                }
            }

            public static void depositCase() throws IOException{
                System.out.println("Select the deposit amount");
                try (PrintStream pDeposit = new PrintStream(new PrintStream("c:/AtmApp/deposit.txt"))) {
                    System.out.println("Your transaction will be printed in file");
                    deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        primaryAccount += deposit;
                        System.out.println("You successfully deposit: " + deposit);
                        System.out.println("Your new account balance is: " + primaryAccount);
                        pDeposit.println("ATM APP PRINT ACCOUNT \n" +
                                "You successfully deposit: " + deposit + "\n" +
                                "Your new account balance is: " + primaryAccount);
                    }
                    if (deposit < 0){
                        System.err.println("Error. The amount of deposit is invalid");
                    }
                } catch (IOException e) {
                    System.err.println("The file is not found or cannot be created.");
                    //e.printStackTrace();
                    throw e;
                }
            }

            public static void withdrawCase() {
                System.out.println("Select the withdraw amount");
                try (PrintStream pWithdraw = new PrintStream(new PrintStream("c:/AtmApp/withdraw.txt"))) {
                    System.out.println("Your transaction will be printed in file");
                    withdraw = scanner.nextDouble();
                    if (withdraw <= 0 && withdraw > primaryAccount) {
                        System.err.println("Error. The withdraw is invalid or there are insufficient funds.");
                    }
                    if (withdraw >= 800) {
                        System.err.println("Sorry. You have reached the withdrawn day limit.");
                        return;
                    }

                    primaryAccount -= withdraw;
                    System.out.println("You successfully withdraw: " + withdraw);
                    System.out.println("Your new account balance is: " + primaryAccount);
                    pWithdraw.println("ATM APP PRINT ACCOUNT \n" +
                            "You successfully withdraw: " + withdraw + "\n" +
                            "Your new account balance is: " + primaryAccount);

                } catch (IOException e) {
                    System.err.println("Error. The file is not found or cannot be created.");
                }
            }

            public static void accountsBalance() {
                try (PrintStream pAccount = new PrintStream(new PrintStream("c:/AtmApp/account-balance.txt"))) {
                    System.out.println("Your transaction will be printed in file");
                    System.out.println();
                    System.out.println("Your primary account balance is: " + primaryAccount);
                    System.out.println("Your backup account balance is: " + backupAccount);
                    pAccount.println("ATM APP PRINT ACCOUNT \n" +
                            "Your accounts balance are: \n" +
                            "Primary account: " + primaryAccount + "\n" +
                            "Backup account: " + backupAccount);

                } catch (IOException e) {
                    System.err.println("Error. The file is not found or cannot be created.");
                }
            }

            public static void accountsTransfer() {
                System.out.println("Account transfer");
                try (PrintStream pTransfer = new PrintStream(new PrintStream("c:/AtmApp/account-transfer.txt"))) {
                    System.out.println("Your transaction will be printed in file \n" +
                            "Please enter the transfer amount");
                    transferWithdraw = scanner.nextDouble();
                    pTransfer.println("ATM APP PRINT ACCOUNT \n" +
                            "The primary account balance : " + primaryAccount + "\n" +
                            "The backup account balance : " + backupAccount);
                    if (transferWithdraw > 0 && transferWithdraw <= primaryAccount) {
                        primaryAccount -= transferWithdraw;
                        backupAccount += transferWithdraw;
                        System.out.println("You successfully transfer the amount: " + transferWithdraw + "\n" +
                                "Your new primary account balance is: " + primaryAccount + "\n" +
                                "Your new backup account balance is: " + backupAccount);
                        pTransfer.println("Transfer amount : " + transferWithdraw);
                        pTransfer.println("The primary account balance : " + primaryAccount + "\n" +
                                "The backup account balance : " + backupAccount);
                    } else {
                        System.err.println("Error. The transfer you are trying is invalid or there are insufficient funds!");
                    }
                } catch (IOException e) {
                    System.err.println("Error. The file is not found or cannot be created.");
                }
            }

            private static void pinNumber() {
                System.out.println("Please enter your pin number: ");

                while (true) {
                    int enteredPin = scanner.nextInt();

                    if (enteredPin == clientModel.getPinNumber()) {
                        System.out.println("You have entered correct Pin Number.");
                        System.out.println("You have entered the ATM MENU! ");
                        break;
                    } else {
                        System.err.println("Error.You have entered wrong pin number. \n" +
                                "Please try again.");
                    }

                }
            }
        }

