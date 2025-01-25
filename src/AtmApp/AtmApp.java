package AtmApp;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import AtmApp.ClientModel.ClientModel;
import AtmApp.Clients.ClientsMain;


/**
 * This is a basic ATM program.
 * I use simple coding for all the function of the app.
 *
 * @author chris
 * @version 0.5
 */

public class AtmApp {


    static double primaryAccount;
    static double backupAccount;
    static double transferWithdraw = 0;
    static double deposit = 0;
    static double withdraw = 0;
    static ClientModel clientModel;
    static int enteredPin;
    static int newPinNUmber;
    static int vat;
    static int attempts = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        ClientsMain clientsMain = new ClientsMain();

        clientModel = loginUser(clientsMain);


        primaryAccount = clientModel.getPrimaryAccount();
        backupAccount = clientModel.getBackupAccount();

        atmAppMenu();

    }

    private static void atmAppMenu() throws IOException {
            while (true) {
                System.out.println("Hello " + clientModel.getFirstname() + " " + clientModel.getLastname());
                System.out.println("1. Make a deposit");
                System.out.println("2. Make a withdraw");
                System.out.println("3. Account balance");
                System.out.println("4. Account transfer");
                System.out.println("5. Pin number change");
                System.out.println("6. Exit Atm App menu");

                int inputChoice = scanner.nextInt();

                switch (inputChoice) {
                    case 1:
                        depositMenu();
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
                        pinChange();
                        break;

                    case 6:
                        System.out.println("Exit Atm Application.");
                        System.exit(0);
                        break;

                            default:
                                System.err.println("Wrong entry. \n" +
                                        "Please make a selection.");
                        }
                }
            }

            private static void depositCase() {
                System.out.println("Select the deposit amount");

                try (PrintWriter pDeposit = new PrintWriter(new FileWriter("c:/AtmApp/deposit.txt", true))) {

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
                        if (deposit < 0) {
                            System.err.println("Error. The amount of deposit is invalid");
                        }
                    } catch (IOException | InputMismatchException e) {
                    System.err.println("Error. The file is not found or cannot be created.");

                    System.err.println("Error. The deposit amount is invalid.");
                }
                    System.out.println("Transaction completed successfully.");
                }

            private static void withdrawCase() {
                System.out.println("Select the withdraw amount");

                try (PrintWriter pWithdraw = new PrintWriter(new FileWriter("c:/AtmApp/withdraw.txt", true))) {
                    System.out.println("Your transaction will be printed in file");

                    withdraw = scanner.nextDouble();

                    if (withdraw <= 0 || withdraw > primaryAccount) {
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
                } catch (InputMismatchException |IOException e) {
                    System.err.println("Error. The file is not found or cannot be created.");

                    System.err.println("Error. The Withdraw amount is invalid.");
                }
                System.out.println("Transaction completed successfully.");
            }

            private static void accountsBalance() {
                try (PrintWriter pAccount = new PrintWriter(new FileWriter("c:/AtmApp/account-balance.txt", true))) {

                    System.out.println("Your transaction will be printed in file");
                    System.out.println();
                    System.out.println("Your primary account balance is: " + primaryAccount);

                    System.out.println("Your backup account balance is: " + backupAccount);
                    pAccount.println("ATM APP PRINT ACCOUNT \n" +
                            "Full name: " + clientModel.getLastname() + " " + clientModel.getFirstname() + "\n" +
                            "Your accounts balance are: \n" +
                            "Primary account: " + primaryAccount + "\n" +
                            "Backup account: " + backupAccount);

                } catch (IOException e) {
                    System.err.println("Error. The file is not found or cannot be created.");
                }
                System.out.println("Transaction completed successfully.");
            }

            private static void accountsTransfer() {
                System.out.println("Account transfer");

                try (PrintWriter pTransfer = new PrintWriter(new FileWriter("c:/AtmApp/account-transfer.txt", true))) {
                    System.out.println("Your transaction will be printed in file");

                    pTransfer.println("ATM APP PRINT ACCOUNT \n" +
                            "The primary account balance: " + primaryAccount + "\n" +
                            "The backup account balance: " + backupAccount);

                    System.out.println("Please enter the transfer amount");
                    transferWithdraw = scanner.nextDouble();

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
                } catch (InputMismatchException | IOException e) {
                    System.err.println("Error. The file is not found or cannot be created.");

                    System.err.println("The withdraw amount is invalid.");
                }
                System.out.println("Transaction complete successfully.");
            }

            private static ClientModel loginUser(ClientsMain clientsMain) throws IOException {
                System.out.println("Please enter your pin number.");

                System.out.println("Pin: ");

                if (clientModel == null) {
                    while (true) {
                        while (attempts < 3) {
                            try {
                                enteredPin = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.err.println("Error. Invalid number. Please enter a valid pin number");
                                scanner.nextLine();
                                continue;
                            }
                            clientModel = clientsMain.getClientByPinNumber(enteredPin);

                            if (enteredPin == clientModel.getPinNumber()) {

                                System.out.println("Please enter your VAT number to confirm its you! ");
                            } else {
                                attempts++;
                                System.err.println("Error. Wrong pin number you have " + (3 - attempts) + " left.");

                                if (attempts == 3) {
                                    System.out.println("You have no attempts left. The system is locked.");
                                    System.exit(0);
                                }
                            }

                            while (attempts < 3) {
                                try {
                                    vat = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.err.println("Error. Invalid number. Please enter a valid VAT number");
                                    scanner.nextLine();
                                    continue;
                                }

                                if (vat == clientModel.getVatRegistrationNo()) {
                                    System.out.println("The identification is completed");
                                    atmAppMenu();
                                } else {
                                    attempts++;
                                    System.err.println("Error. Wrong VAT number you have " + (3 - attempts) + " left.");

                                    if (attempts == 3) {
                                        System.out.println("You have no attempts left. The system is locked. Please contact local administrator.");
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                    }
                }
                return null;
            }



            private static void pinChange () throws IOException {
                try {
                    while (true) {
                        System.out.println("Please give your old pin number: ");
                        enteredPin = scanner.nextInt();
                        if (enteredPin != clientModel.getPinNumber()) {

                            System.err.println("Error. Enter your current pin number.");
                            return;
                        }
                        System.out.println("Please choose new pin number: ");
                        newPinNUmber = scanner.nextInt();
                        if (newPinNUmber == enteredPin) {

                            System.err.println("Error. The pin must not be the same with the previous one.");
                            continue;
                        }
                        if (newPinNUmber <= 0) {

                            System.err.println("Error. Pin number must not be negative");
                        } else {
                            clientModel.setPinNumber(newPinNUmber);

                            System.out.println("You successfully change your pin number!");

                            System.out.println("The Atm App will restart and enter with new pin number");
                            atmAppMenu();
                        }
                    }

                } catch (InputMismatchException e) {
                    System.out.println();
                }
            }

            private static void depositMenu() {
                while(true) {
                    System.out.println("Choose deposit amount: ");
                    System.out.println("1. 40");
                    System.out.println("2. 60");
                    System.out.println("3. 80");
                    System.out.println("4. 120");
                    System.out.println("5. 200");
                    System.out.println("6. 400");
                    System.out.println("7. Enter the amount manually");
                    System.out.println("8. Return to main menu");

                    int inputChoice = scanner.nextInt();

                    if (inputChoice == 9) {
                        return; // Exit back to the main menu
                    }

                    switch (inputChoice) {
                        case 1: deposit = 40;
                        break;

                        case 2: deposit = 60;
                        break;

                        case 3: deposit = 80;
                        break;

                        case 4: deposit = 120;
                        break;

                        case 5: deposit = 200;
                        break;

                        case 6: deposit = 400;
                        break;

                        case 7:
                            depositCase();
                        break;

                        case 8: return;

                        default:
                            System.err.println("Wrong entry. \n" +
                                    "Please make a selection.");
                    }
                }
            }
        }

