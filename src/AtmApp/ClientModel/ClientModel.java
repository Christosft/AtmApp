package AtmApp.ClientModel;


public class ClientModel {
    private int pinNumber;
    private String firstname;
    private String lastname;
    private int vatRegistrationNo;
    private String phoneNo;
    private String city;
    private double primaryAccount;
    private double backupAccount;


    public ClientModel(int pinNumber, String firstname, String lastname, int vatRegistrationNo, String phoneNo, String city, double primaryAccount, double backupAccount) {
        this.pinNumber = pinNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.vatRegistrationNo = vatRegistrationNo;
        this.phoneNo = phoneNo;
        this.city = city;
        this.primaryAccount = primaryAccount;
        this.backupAccount = backupAccount;
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

    public int getVatRegistrationNo() {
        return vatRegistrationNo;
    }

    public void setVatRegistrationNo(int vatRegistrationNo) {
        this.vatRegistrationNo = vatRegistrationNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
