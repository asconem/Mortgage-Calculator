package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner sc = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = sc.nextInt();

        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = sc.nextDouble()/PERCENT;
        double monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        int years = sc.nextInt();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double topHalfOfEquation = monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments);
        double bottomHalfOfEquation = Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;
        double mortgagePayment = principal * (topHalfOfEquation/bottomHalfOfEquation);

        String formattedMortgagePayment = NumberFormat.getCurrencyInstance().format(mortgagePayment);
        System.out.print("Monthly Mortgage Payment: " + formattedMortgagePayment);

    }

}
