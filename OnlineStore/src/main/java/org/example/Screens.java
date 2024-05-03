package org.example;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screens {
    //display product screen
    public static void displayProducts() {
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String filepath = "src/main/resources/";
        String productFile = filepath + "Products.csv";
        String shoppingCart = filepath + "shopping.cart.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(productFile))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] data = line.split("\\|");
                String sku = data[0];
                String productName = data[1];
                double price = Double.parseDouble(data[2]);
                String department = data[3];

                Product product = new Product(sku, productName, price, department);
                products.add(product);


            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (Product product : products) {
            System.out.println("SKU: " + product.getSku() + "Name: " + product.getProductName() + "Price: " + product.getPrice() + "Department: " + product.getDepartment());
        }
        //ask user for filter of products
        System.out.println("Would you like to filter products in a specific way?");
        System.out.println("(1): Filter \n (2): No Product Filter");

        while (true) {
            System.out.println("Please select an option: ");
            String userSearchFilter = scanner.nextLine();
            if (userSearchFilter.equalsIgnoreCase("1")) {
                searchFilter(products, userSearchFilter, scanner);
                break;
            } else if (userSearchFilter.equalsIgnoreCase("2")) {
                searchFilter(products, userSearchFilter, scanner);
                break;
            } else {
                System.out.println("sorry that doesn't seem right.");

            }

        }
        //add products into users cart
        while (true) {
            System.out.println("once you've added all of your items to your cart type 'x' to exit");
            System.out.println("Enter the name of the product you want to add: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("x")) {
                return;
            } else {
                for (Product product : products) {
                    if (userInput.equalsIgnoreCase(product.getProductName())) {
                        try {
                            FileWriter writer = new FileWriter(shoppingCart, true);
                            writer.write(product.getSku() + "|" + product.getProductName() + "|" + product.getPrice() + "|" + product.getDepartment() + "\n");
                            writer.close();
                        }
                        catch (IOException ex) {
                            System.out.println("Error adding the product to the cart.");
                        }
                    }
                }
            }
        }
    }

    //search filter
    public static void searchFilter(List<Product> products, String userInput, Scanner scanner) {

        if (userInput.equalsIgnoreCase("1")) {
            System.out.println("How would you like to filter the products?: ");
            System.out.println("(1): Filter by price");
            System.out.println("(2): Filter by department");
            System.out.println("(3): Continue without filtering products.");

            while (true) {
                System.out.print("Enter your choice here: ");
                String filterInput = scanner.nextLine();

                if (filterInput.equalsIgnoreCase("1")) {

                    System.out.println("Please enter minimum price: ");
                    String min = scanner.nextLine();
                    double minPrice = Double.parseDouble(min);
                    System.out.println("Please enter maximum price: ");
                    String max = scanner.nextLine();
                    double maxPrice = Double.parseDouble(max);


                    for (Product product : products) {
                        if (minPrice <= product.getPrice() && maxPrice >= product.getPrice()) {
                            System.out.println("SKU: " + product.getSku() + " Name: "
                                    + product.getProductName() + " Price " + product.getPrice() + " Department: " + product.getDepartment());

                        }
                        return;
                    }
                } else if (filterInput.equalsIgnoreCase("2")) {

                    System.out.println("Please enter the department");
                    String department = scanner.nextLine();

                    for (Product product : products) {
                        if (product.getDepartment().equalsIgnoreCase(department)) {
                            System.out.println("SKU number: " + product.getSku() + " Name: " + product.getProductName() + " Price: " + product.getPrice() + "Department: " + product.getDepartment());
                        } else if (filterInput.equalsIgnoreCase("3")) ;

                        return;
                    }
                }
            }
        }
    }

    public static void displayCart(List<Product> products, Scanner scanner) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String filePath = "src/main/resources/";
        String shoppingCart = filePath + "shopping.cart.csv";
        double sum = 0;

        System.out.println("\nHere's your shopping cart!\n");


        try (BufferedReader reader = new BufferedReader(new FileReader(shoppingCart))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cartDisplay = line.split("\\|");
                String sku = cartDisplay[0];
                String productName = cartDisplay[1];
                double price = Double.parseDouble(cartDisplay[2]);
                String department = cartDisplay[3];

                Product product = new Product(sku, productName, price, department);


            }
        } catch (IOException ex) {
            System.out.println("Error reading shopping cart file.");
        }
        for (Product product : products) {
            System.out.println("SKU: " + product.getSku() + " Name: "
                    + product.getProductName() + " Price: " + product.getPrice() + " Department: " + product.getDepartment());
            sum += product.getPrice();
        }

        System.out.println("\nTotal: $" + decimalFormat.format(sum));

        //Having user remove item from cart

        System.out.println("Would you like to remove any products from your cart?");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("yes")) {

            System.out.println("Please enter Product SKU to remove:");
            String userReturn = scanner.nextLine();

            // Create a new list for removing SKU
            List<Product> updatedProducts = new ArrayList<>();

            // This will run through the products and if it matches the SKU it doesn't add to the updated products.
            for (Product product : products) {
                if (!userReturn.equalsIgnoreCase(product.getSku())) {
                    updatedProducts.add(product);
                } else {
                    sum -= product.getPrice();
                }
            }

            // This will write out the new shopping.cart.csv file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(shoppingCart))) {
                for (Product product : updatedProducts) {
                    writer.write(product.getSku() + "|" + product.getProductName() + "|" + product.getPrice() + "|" + product.getDepartment());
                    writer.newLine();
                }
                System.out.println("Product with SKU " + userReturn + " removed from the shopping cart.");
            } catch (IOException ex) {
                System.out.println("Error writing to the shopping cart file:");
            }
            checkOut(products, scanner, sum);
        }

    }


    public static void checkOut(List<Product> products, Scanner scanner, double sum) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter receiptFmt = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String receiptDate = "src/main/receipts/" + today.format(receiptFmt) + ".txt";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("E, MMM dd, yyyy HH:mm");
        String todaysDate = today.format(fmt);
        String filePath = "src/main/resources/";
        String shoppingCart = filePath + "shopping.cart.csv";

        System.out.println("\nTotal: $" + decimalFormat.format(sum));

        System.out.println("Would you like to pay?");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("yes")) {
            System.out.println("Good choice");
        } else if (userInput.equalsIgnoreCase("no")) {
            System.out.println("you're paying....");
        } else {
            System.out.println("Looks like you didn't type yes or no, but you're paying");
        }

        System.out.println("How much are you going to pay ?");
        String userCash = scanner.nextLine();
        double cash = Double.parseDouble(userCash);
        while (true) {
            if (cash >= sum) {
                System.out.println("Thank you $" + decimalFormat.format(cash - sum) + " is your change");
                break;
            } else if (cash < sum) {
                System.out.println("You still owe $" + decimalFormat.format(sum - cash));
                System.out.println("How will you pay the due ammount ?");
                String userExtraPay = scanner.nextLine();
                cash += Double.parseDouble(userExtraPay);
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(shoppingCart));
             BufferedWriter writer = new BufferedWriter(new FileWriter(receiptDate))) {


            writer.write("Today's Date: " + todaysDate + "\n");

            products.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cartDisplay = line.split("\\|");
                String sku = cartDisplay[0];
                String productName = cartDisplay[1];
                double price = Double.parseDouble(cartDisplay[2]);
                String department = cartDisplay[3];

                Product product = new Product(sku, productName, price, department);
                products.add(product);

                writer.write(product.getSku() + "|" + product.getProductName() + "|" + product.getPrice() + "|" + product.getDepartment());
                writer.newLine();
            }


            writer.write("Sales Total $" + sum + "\n");
            writer.write("Amount payed $" + cash + "\n");
            writer.write("Change Given $" + decimalFormat.format(cash - sum) + "\n");


        } catch (IOException ex) {
            System.out.println("Error writing to the receipt file.");
        }
    }
}





