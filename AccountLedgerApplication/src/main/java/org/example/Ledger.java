package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.FinancialTracker.transactionfp;

public class Ledger {
    public static List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(transactionfp))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String type = data[2];
                String vendor = data[3];
                double amount = Double.parseDouble(data[4]);
                String date = data[0];
                String time = data[1];

                LocalDate localDate = LocalDate.parse(date);
                LocalTime localTime = LocalTime.parse(time);

                LocalDateTime dateTime = LocalDateTime.of(localDate,localTime);
                Date dateFromDateTime = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
                Transaction transaction = new Transaction(type, vendor, amount, dateFromDateTime);
                transactions.add(transaction);
            }
       } catch(IOException ex){
            System.out.println("Transaction not saved");
        }
        return transactions;
    }
    public static void displayTransactions(List<Transaction> transactions){
        if(transactions.isEmpty()){
            System.out.println("No Transactions available. ");
        } else {
            for(Transaction transaction : transactions){
                System.out.println(transaction);
            }
        }
    }

    public static List<Transaction>filterTransactionsByType(List<Transaction> transactions, String type){
        return transactions.stream()
                .filter(transaction -> transaction.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
    public static List<Transaction> filterTransactionsByVendor(List<Transaction> transactions, String vendor) {
        return transactions.stream()
                .filter(transaction -> transaction.getVendor().equalsIgnoreCase(vendor))
                .collect(Collectors.toList());
    }
    public static List<Transaction> filterTransactionsByMonthToDate(List<Transaction> transactions){
        //get the current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //extract the year and month
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH); // Month is zero-based
        return transactions.stream().filter(transaction -> {
            //get transaction date and time
                    Calendar transactionDate = Calendar.getInstance();
                    transactionDate.setTime(transaction.getDate());
                    //filter through transactions that belong from month to date

                    int transactionYear = transactionDate.get(Calendar.YEAR);
                    int transactionMonth = transactionDate.get(Calendar.MONTH);// Month is zero-based
            //
                    return transactionYear == currentYear && transactionMonth == currentMonth;
        }).collect(Collectors.toList());
    }
    public static List<Transaction> filterTransactionsByPreviousMonth(List<Transaction> transactions){
        // Get the current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        // Subtract one month from the current date
        calendar.add(Calendar.MONTH, -1);

        // Extract the year and month components of the previous month
        int previousYear = calendar.get(Calendar.YEAR);
        int previousMonth = calendar.get(Calendar.MONTH); // Month is zero-based

        // Filter transactions that belong to the previous month
        return transactions.stream()
                .filter(transaction -> {
                    Calendar transactionDate = Calendar.getInstance();
                    transactionDate.setTime(transaction.getDate());
                    int transactionYear = transactionDate.get(Calendar.YEAR);
                    int transactionMonth = transactionDate.get(Calendar.MONTH); // Month is zero-based

                    // Check if the transaction's year and month match the previous year and month
                    return transactionYear == previousYear && transactionMonth == previousMonth;
                }).collect(Collectors.toList()); // Collect the filtered transactions into a list and return
    }
    public static List<Transaction> filterTransactionsByYearToDate(List<Transaction> transactions){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        // Extract the year component of the current date
        int currentYear = calendar.get(Calendar.YEAR);

        // Filter transactions that belong to the current year
        return transactions.stream()
                .filter(transaction -> {
                    Calendar transactionDate = Calendar.getInstance();
                    transactionDate.setTime(transaction.getDate());
                    int transactionYear = transactionDate.get(Calendar.YEAR);

                    // Check if the transaction's year matches the current year
                    return transactionYear == currentYear;
                })
                .collect(Collectors.toList()); // Collect the filtered transactions into a list and return
    }
    public static List<Transaction> filterTransactionsByPreviousYear(List<Transaction> transactions){
    // Get the current date
    Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

    // Extract the year component of the current date
    int currentYear = calendar.get(Calendar.YEAR);

    // Filter transactions that belong to the previous year
        return transactions.stream()
                .filter(transaction -> {
        Calendar transactionDate = Calendar.getInstance();
        transactionDate.setTime(transaction.getDate());
        int transactionYear = transactionDate.get(Calendar.YEAR);

        // Check if the transaction's year matches the previous year
        return transactionYear == currentYear - 1;
    })
            .collect(Collectors.toList()); // Collect the filtered transactions into a list and return
    }
}

