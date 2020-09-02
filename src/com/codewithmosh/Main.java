package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments = 0;

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
            float annualInterestRate = sc.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Please enter a value between 1 and 30: ");

        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = sc.nextByte();
            if (years >= 1 && years <= 30){
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.print("Please enter a value between 1 and 30: ");
        }

        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String formattedMortgagePayment = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly Mortgage Payment: " + formattedMortgagePayment);

    }

    public static String greetUser(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + ". Welcome to the Mortgage Calculator.";
    }



}
