package bankaccountapp;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) throws IOException {
        List<Account> accounts = new LinkedList<>();


        String file = "/Users/suzan/Desktop/Book1.csv";

        //Read a CSV file then create new account using the info from it.
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        System.out.println("New Accounts:");

        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            System.out.println(name + " " + ssn + " " + accountType + " " + initDeposit);
            if (accountType.equals("Savings")) {
                System.out.println("Open Savings Account");
                accounts.add(new Savings(name, ssn, initDeposit));
            } else if (accountType.equals("Checking")) {
                System.out.println("Open Checking Account");
                accounts.add(new Checking(name, ssn, initDeposit));
            } else {
                System.out.println("ERROR Reading Account type!!!");
            }
        }

        //Display all accounts
        for (Account acc:accounts) {
            System.out.println("\n*********************");
            acc.showInfo();
        }
        accounts.get((int) Math.random()*accounts.size()).deposit(1000);
    }
}
