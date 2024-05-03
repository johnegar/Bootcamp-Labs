package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productName;
    private Double price;
    private String department;
    private String sku;


    public Product(String sku,String productName, Double price, String department) {
        this.productName = productName;
        this.price = price;
        this.department = department;
        this.sku = sku;

    }
    public String getSku(){
        return sku;
    }
    public String setSku(){
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}