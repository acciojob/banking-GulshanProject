package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance,double minBalance, String  institutionName) {
        //minimum balance is 0 by defaul
        super(name, balance, minBalance);
        this.institutionName = institutionName;

    }

}
