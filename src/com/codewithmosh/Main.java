package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(greetUser("John", "Smith"));

        int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual interest rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, years);

        String formattedMortgagePayment = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly Mortgage Payment: " + formattedMortgagePayment);

    }

    public static String greetUser(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + ". Welcome to the Mortgage Calculator.";
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = sc.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max + ".");
        }
        return value;
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
