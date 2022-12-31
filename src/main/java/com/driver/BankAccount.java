package com.driver;

public class BankAccount {

    private String name;
    private double balance;

    public double getBalance() {
        return balance;
    }



    public double getMinBalance() {
        return minBalance;
    }
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
              this.name=name;
              this.balance=balance;
              this.minBalance=minBalance;
    }







    public int DigitSum(int digit){
        int sumOfDigit=0;
        while(digit!=0){
            int rem= digit%10;
            sumOfDigit+=rem;
            digit=digit/10;
        }
        return sumOfDigit;
    }
    public String convertStringFromDigit(int digit){
        String AccountNo="";
        while(digit!=0){
            int rem= digit%10;
            AccountNo+=rem;
            digit=digit/10;
        }
        return AccountNo;

    }
    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

           if(DigitSum(digits)==sum){
               String generateAccountNo= convertStringFromDigit(digits);
               return generateAccountNo;
           }
           else {
               throw new Exception("Account Number can not be generated");
           }


    }

    public void deposit(double amount) {
        //add amount to balance
        if(balance!=0){
            this.balance+=amount;
        }
        else {
            System.out.println("availabe balance is low");
        }

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        double remainingAmount = balance - minBalance;
        if(remainingAmount<minBalance)
        {
            throw new Exception("Insufficient Balance");
        }
        else {
            remainingAmount=balance;
        }
    }

}