package AtmApp.Clients;

public class AtmClients {

    private static int clientCount = 0;
    private int pinNumber;
    private double primaryAccount;
    private double backupAccount;
    private String firstname;
    private String lastname;

    public AtmClients () {
        clientCount++;
    }

    public AtmClients(int pinNumber, String firstname, String lastname, double primaryAccount, double backupAccount) {
        this.pinNumber = pinNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.primaryAccount = primaryAccount;
        this.backupAccount = backupAccount;
    }

    public static int getClientCount() {
        return clientCount;
    }

    public static void setClientCount(int clientCount) {
        AtmClients.clientCount = clientCount;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(double primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

    public double getBackupAccount() {
        return backupAccount;
    }

    public void setBackupAccount(double backupAccount) {
        this.backupAccount = backupAccount;
    }
}
