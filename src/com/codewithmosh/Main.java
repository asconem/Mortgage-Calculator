package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("Principal ($1K - $1M): ");
            principal = sc.nextInt();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Enter a value between 1,000 and 1,000,000");
        }

        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = sc.nextDouble()/PERCENT;
        while (annualInterestRate <= 0.0 || annualInterestRate > 30.0){
            System.out.print("Please enter a number greater than 0 and less than or equal to 30: ");
            annualInterestRate = sc.nextDouble()/PERCENT;
        }
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
