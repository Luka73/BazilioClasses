package Entities;

public abstract class BankingAccount {
    protected double startingBalance;
    protected double currentBalance;
    protected double totalOfDeposits;
    protected int numberOfDeposits;
    protected double totalOfWithdrawals;
    protected int numberOfWithdrawals;
    protected double annualInterestRate;
    protected double monthlyServiceCharge;
    protected boolean activeAccount;

    public BankingAccount(double startingBalance, double annualInterestRate) {
        this.startingBalance = startingBalance;
        this.annualInterestRate = annualInterestRate;
        this.activeAccount = true;
    }

    public void makeDeposit(double amount) {
        this.currentBalance += amount;
        this.totalOfDeposits += amount;
        this.numberOfDeposits++;
    }

    public void makeWithdraw(double amount) {
        this.currentBalance -= amount;
        this.totalOfWithdrawals += amount;
        this.numberOfWithdrawals++;
    }

    public void calculateInterest() {
        double monthlyInterestRate = (annualInterestRate/12.0);
        double monthlyInterest = currentBalance * monthlyInterestRate;
        currentBalance += monthlyInterest;
    }

    public void doMonthlyReport() {
        currentBalance -= monthlyServiceCharge;
        calculateInterest();

        String accountStatus = (activeAccount) ? "Active" : "Inactive";

        System.out.printf("Starting balance: %.2f \n" , startingBalance);
        System.out.printf("Total of deposits: %.2f \n" , totalOfDeposits);
        System.out.printf("Total of withdrawals: %.2f \n" , totalOfWithdrawals);
        System.out.printf("Service charges: %.2f \n" , monthlyServiceCharge);
        System.out.printf("Current balance: %.2f \n" , currentBalance);
        System.out.println("Account status: " + accountStatus);

        startingBalance = currentBalance;

        currentBalance = 0;
        totalOfDeposits = 0;
        numberOfDeposits = 0;
        totalOfWithdrawals = 0;
        numberOfWithdrawals = 0;
        monthlyServiceCharge = 0;
        monthlyServiceCharge = 0;
    }

}
