package bankaccountapp;

public interface IRate {

    //Method that returns the rate
    default double getBaseRate(){
        return 2.50;
    }

}
