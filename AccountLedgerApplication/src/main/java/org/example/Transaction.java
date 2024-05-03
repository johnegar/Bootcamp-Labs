package org.example;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Serializable {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
    private String type; // Deposit or Payment
    private String vendor;
    private double amount;
    private Date date;

    public Transaction(String type, String vendor, double amount) {
        this.type = type;
        this.vendor = vendor;
        this.amount = amount;
        this.date = new Date();
    }

    public Transaction(String type, String vendor, double amount, Date date) {
        this.type = type;
        this.vendor = vendor;
        this.amount = amount;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString(){
        return String.format(dateFormat.format(date) + "|" + type + "|" + vendor + "|" + amount);
}
}

