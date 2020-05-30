package bankaccountapp;

public class Checking extends Account {
    //List properties for checking account
    private int debitCardNumber;
    private int pin;

    //Constructor to initialize setting for setting properties
    public Checking(String name, String ssn, double initDesposit) {
        super(name, ssn, initDesposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
       rate = getBaseRate()* .15;
    }

    private void setDebitCard() {
        debitCardNumber = (int) (Math.random()*Math.pow(10, 12));
        pin = (int) (Math.random()*Math.pow(10, 4));
    }

    //Show Info
    public void showInfo(){
        super.showInfo();
        System.out.println("\nYour checking account info: "+"\n Debit Card Number: "+ debitCardNumber +"\n Debit card PIN: "+pin);
    }
}
