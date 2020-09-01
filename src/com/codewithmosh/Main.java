package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        double monthlyInterestRate = 0;
        int numberOfPayments = 0;

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("Principal ($1K - $1M): ");
            principal = sc.nextInt();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.print("Please enter a value between 1,000 and 1,000,000: ");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            double annualInterestRate = sc.nextDouble() / PERCENT;
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
                break;
            }
            System.out.print("Please enter a value between 1 and 30: ");

        }

        while (true) {
            System.out.print("Period (Years): ");
            int years = sc.nextInt();
            if (years >= 1 && years <= 30){
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.print("Please enter a value between 1 and 30: ");
        }

        double topHalfOfEquation = monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments);
        double bottomHalfOfEquation = Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;
        double mortgagePayment = principal * (topHalfOfEquation/bottomHalfOfEquation);

        String formattedMortgagePayment = NumberFormat.getCurrencyInstance().format(mortgagePayment);
        System.out.print("Monthly Mortgage Payment: " + formattedMortgagePayment);

    }

}
