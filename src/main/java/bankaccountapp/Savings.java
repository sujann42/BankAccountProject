package bankaccountapp;

public class Savings extends Account {
    //List properties for saving account
    int safetyDepositBoxID;
    int safetyDepositKey;


    //Constructor to initialize setting for setting properties
    public Savings(String name, String ssn, double initDesposit) {
        super(name, ssn, initDesposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();

    }

    @Override
    public void setRate() {
        rate = getBaseRate() -.25;

    }


    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositKey = (int) (Math.random() * Math.pow(10, 4));
    }

    //Show Info
    public void showInfo() {
        super.showInfo();
        System.out.println("\nYour savings account info: " + "\n Safety Deposit Box ID: " + safetyDepositBoxID + "\n Safety Deposit Box IKEY:" + safetyDepositKey);
    }
}
