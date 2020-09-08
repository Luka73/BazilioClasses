package BankAccount.Utils;

import BankAccount.Entities.BankingAccount;
import java.util.Scanner;

public class Menu {
    public static String getBankMenuOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************");
        System.out.println("Bank Menu");
        System.out.println("A: Savings");
        System.out.println("B: Checking");
        System.out.println("C: Exit");
        return sc.next().toUpperCase();
    }

    public static String getAccountOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("A: Deposit");
        System.out.println("B: Withdrawal");
        System.out.println("C: Report");
        System.out.println("D: Return to Bank Menu");
        return sc.next().toUpperCase();
    }

    public static boolean accountMenu(String optionAccount, BankingAccount bankingAccount) {
        Scanner sc = new Scanner(System.in);
        if(optionAccount.equalsIgnoreCase("A")) {
            System.out.println("Enter deposit amount: ");
            double amount = sc.nextDouble();
            bankingAccount.makeDeposit(amount);
        } else if (optionAccount.equalsIgnoreCase("B")) {
            System.out.println("Enter withdrawal amount: ");
            double amount = sc.nextDouble();
            bankingAccount.makeWithdraw(amount);
        } else if (optionAccount.equalsIgnoreCase("C")) {
            bankingAccount.doMonthlyReport();
        } else {
            return false;
        }

        return true;
    }
}
