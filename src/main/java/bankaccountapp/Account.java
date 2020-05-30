package bankaccountapp;

public  abstract class Account implements IRate {
    //List commom properties for saving and checking accounts
     private String ssn;
     private String name;
     private double balance;
     protected String accountNumber;
     protected double rate;

    //others => For purpose of generating Account Number
    static int index = 10000;

    //Constructor to set base properties and initialize account
    public Account(String name, String ssn, double initDeposit){
       this.name = name;
       this.ssn = ssn;
       this.balance = initDeposit;

        //Set acccount number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }


    //Forcing to inherit the method
    public abstract void setRate();

    //Creating account number
    public String setAccountNumber() {
        String lastTwoofSSN = ssn.substring(ssn.length()-2);
        int uniqueID = index;
        int randomNum = (int) (Math.random() * 1000);

        return lastTwoofSSN+uniqueID+randomNum;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void compound(){
        double accruednterest = balance * (rate/100);
        balance +=accruednterest;
        System.out.println("Accrued Interest: $"+accruednterest);
        showBalance();
    }

    //Deposit method
    public void deposit(double amount){
        balance += amount;
        System.out.println("Depositing amount $"+amount);
        showBalance();
    }

    //Withdraw method
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("Amount withdrawl: $"+amount);
            showBalance();
        }else{
            System.out.println("Not sufficient fund!!!");
        }
    }

    //Transfer
    public void transfer(String destAccount, double amount){
       if(balance>amount){
           balance -= amount;
           System.out.println("Transfering $"+amount+ " to "+destAccount);
           showBalance();
       }else {
           System.out.println("Not sufficient fund!!!");
       }

    }

    public void showBalance(){
        System.out.println("Your balance now is: "+balance);
    }



    public void showInfo() {
        System.out.printf("%-13s %-13s %-13.2f %-15s %-13.2f", accountNumber, ssn, balance, accountNumber, rate);
    }
}
