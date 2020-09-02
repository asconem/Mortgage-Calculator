package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = 0;
        float annualInterestRate = 0;
        byte years = 0;

        System.out.println(greetUser("John", "Smith"));

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("Principal ($1K - $1M): ");
            principal = sc.nextInt();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Please enter a value between 1,000 and 1,000,000: ");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = sc.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30)
                break;

            System.out.println("Please enter a value between 1 and 30: ");

        }

        while (true) {
            System.out.print("Period (Years): ");
            years = sc.nextByte();
            if (years >= 1 && years <= 30)
                break;

            System.out.print("Please enter a value between 1 and 30: ");
        }

        double mortgage = calculateMortgage(principal, annualInterestRate, years);

        String formattedMortgagePayment = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly Mortgage Payment: " + formattedMortgagePayment);

    }

    public static String greetUser(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + ". Welcome to the Mortgage Calculator.";
    }

    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            byte years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return mortgage;
    }

}
