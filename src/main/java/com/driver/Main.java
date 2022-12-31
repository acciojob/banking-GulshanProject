package com.driver;

public class Main {
    public static void main(String[] args) {
        SavingsAccount saveA=new SavingsAccount("GulshanKumar",5000,700,5);

        System.out.println(saveA.getSimpleInterest(4));
        System.out.println(saveA.getCompoundInterest(2,4));

    }
}