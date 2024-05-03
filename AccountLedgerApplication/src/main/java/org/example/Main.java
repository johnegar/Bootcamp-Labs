package org.example;

import java.util.List;
import java.util.Scanner;

import static org.example.FinancialTracker.*;
import static org.example.Ledger.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Home Screen ===");
            System.out.println("1. Add Deposit");
            System.out.println("2. Make Payment");
            System.out.println("3. Ledger");
            System.out.println("X. Exit");

            System.out.print("Choose an option: ");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    addTransaction("Deposit", scanner);
                    break;
                case "2":
                    addTransaction("Payment", scanner);
                    break;
                case "3":
                    showLedger(scanner);
                    break;
                case "x":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void showLedger(Scanner scanner) {
        List<Transaction> transactions = loadTransactions();
        while(true){
            System.out.println("=== Ledger ===");
            System.out.println("A. All Entries");
            System.out.println("D. Deposits");
            System.out.println("P. Payments");
            System.out.println("R. Reports");
            System.out.println("0. Back to Home Screen");

            System.out.print("Choose an option: ");
            String option = scanner.nextLine().trim();

            switch (option.toUpperCase()) {
                case "A":
                    displayTransactions(loadTransactions());
                    break;
                case "D":
                    displayTransactions(filterTransactionsByType(transactions, "Deposit"));
                    break;
                case "P":
                    displayTransactions(filterTransactionsByType(transactions, "Payment"));
                    break;
                case "R":
                    showReports(transactions, scanner);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public static void showReports(List<Transaction> transactions, Scanner scanner) {
        while (true) {
            System.out.println("=== Reports ===");
            System.out.println("1. Month to Date");
            System.out.println("2. Previous Month");
            System.out.println("3. Year to Date");
            System.out.println("4. Previous Year");
            System.out.println("5. Search by Vendor");
            System.out.println("0. Back to Ledger");

            System.out.print("Choose a report option: ");
            String reportOption = scanner.nextLine().trim();

            switch (reportOption) {
                case "1":
                    displayTransactions(filterTransactionsByMonthToDate(transactions));
                    break;
                case "2":
                    displayTransactions(filterTransactionsByPreviousMonth(transactions));
                    break;
                case "3":
                    displayTransactions(filterTransactionsByYearToDate(transactions));
                    break;
                case "4":
                    displayTransactions(filterTransactionsByPreviousYear(transactions));
                    break;
                case "5":
                    System.out.println("Enter vendor name: ");
                    String vendor = scanner.nextLine().trim();
                    displayTransactions(filterTransactionsByVendor(transactions, vendor));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}