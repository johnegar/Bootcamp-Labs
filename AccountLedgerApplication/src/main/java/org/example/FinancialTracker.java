package org.example;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class FinancialTracker {
    public static String transactionfp = "src/main/resources/transactions.csv";

    public static void addTransaction(String type, Scanner scanner){
        System.out.println("Enter Vendor Name: ");
        String vendor = scanner.nextLine().trim();
        System.out.println("Enter Amount: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());


        Transaction transaction = new Transaction(type, vendor, amount);
        saveTransaction(transaction);
        System.out.println("Transaction saved successfully.");
    }
    public static void saveTransaction(Transaction transaction){
        try(PrintWriter outWriter = new PrintWriter(new FileWriter(transactionfp,true))){
            outWriter.println(transaction);


        }catch (IOException ex) {
            System.out.println("transaction was not saved");
        }
    }
}




