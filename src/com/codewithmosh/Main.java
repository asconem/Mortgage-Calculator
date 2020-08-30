package com.codewithmosh;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner sc = new Scanner(System.in);

        System.out.println("Principal: ");
        int principal = sc.nextInt();

        System.out.println("Annual Interest Rate: ");
        double annualInterestRate = sc.nextDouble()/PERCENT;
        double monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR;

        System.out.println("Period (Years): ");
        int years = sc.nextInt();
        int numberOfPayments = years * MONTHS_IN_YEAR;

    }

}
