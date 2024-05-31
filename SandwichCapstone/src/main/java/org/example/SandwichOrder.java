package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SandwichOrder {
    private SandwichSize size;
    private List<Meat> meats;
    private List<ExtraMeat> extraMeats;
    private List<Cheese> cheeses;
    private List<ExtraCheese> extraCheeses;
    private List<Toppings> toppings;
    private List<Sauce> sauces;
    private List<Chips> chips;
    private List<DrinkOrder> drinkOrders;


    private static final String CSV_FILE = "src/main/resources/recipt.csv";

    public SandwichOrder(SandwichSize size) {
        this.size = size;
        this.meats = new ArrayList<>();
        this.extraMeats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.extraCheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();

    }

    public void addMeat(Meat meat) {
        meats.add(meat);
    }

    public void addExtraMeat(ExtraMeat extraMeat) {
        extraMeats.add(extraMeat);
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public void addExtraCheese(ExtraCheese extraCheese) {
        extraCheeses.add(extraCheese);
    }

    public void addToppings(Toppings topping) {
        toppings.add(topping);
    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }
    public void addChips(Chips chip){
        chips.add(chip);
    }
    public void addDrinkOrder(DrinkOrder drinkOrder){
        drinkOrders.add(drinkOrder);
    }


    public double calculateTotalPrice() {
        double total = size.getBasePrice();
        for (Meat meat : meats) {
            total += meat.getPrice(size);
        }
        for (ExtraMeat extraMeat : extraMeats) {
            total += extraMeat.getPrice(size);
        }
        for (Cheese cheese : cheeses) {
            total += cheese.getPrice(size);
        }
        for (ExtraCheese extraCheese : extraCheeses) {
            total += extraCheese.getPrice(size);
        }
        for (Toppings toppings : toppings) {
            total += toppings.getBasePrice();
        }
        for (Sauce sauce : sauces) {
            total += sauce.getBasePrice();
        }
        for (DrinkOrder drinkOrder : drinkOrders) {
            total += drinkOrder.getDrink().getPrice(drinkOrder.getSize());
        }
        return total;
    }

    public void saveOrderToCSV() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String filename = "order_" + timestamp + ".txt";

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filename), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            StringBuilder sb = new StringBuilder();
            sb.append(size);

            for (Meat meat : meats) {
                sb.append('|').append(meat);
            }
            for (ExtraMeat extraMeat : extraMeats) {
                sb.append('|').append(extraMeat);
            }
            for (Cheese cheese : cheeses) {
                sb.append('|').append(cheese);
            }
            for (ExtraCheese extraCheese : extraCheeses) {
                sb.append('|').append(extraCheese);
            }
            for (Toppings topping : toppings) {
                sb.append('|').append(topping);
            }
            for (Sauce sauce : sauces) {
                sb.append('|').append(sauce);
            }
            for (Chips chip : chips){
                sb.append('|').append(chip);
            }
            for (DrinkOrder drinkOrder : drinkOrders){
                sb.append('|').append(drinkOrder.getDrink()).append('|').append(drinkOrder.getSize());
            }

            sb.append('|').append(calculateTotalPrice());
            writer.write(sb.toString());
            writer.newLine();
        }
    }
    public static String readLastLineFromCSV() throws IOException {
        Path path = Path.of(CSV_FILE);
        String lastLine = "";
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
        }
        return lastLine;
    }
    public static void deleteLastLineFromCSV() throws IOException {
        Path path = Path.of(CSV_FILE);
        List<String> lines = Files.readAllLines(path);
        if (!lines.isEmpty()) {
            lines.remove(lines.size() - 1);
            Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }

    public static void checkout() {
        Scanner scanner = new Scanner(System.in);
        try {
            String lastOrder = readLastLineFromCSV();
            if (lastOrder.isEmpty()) {
                System.out.println("No orders found.");
            } else {
                System.out.println("Most recent order: " + lastOrder);
                System.out.println("Do you want to proceed with the checkout? (yes/no)");
                String checkoutChoice = scanner.next().toLowerCase();
                if (checkoutChoice.equals("no")) {
                    deleteLastLineFromCSV();
                    System.out.println("Order has been canceled.");
                } else {
                    System.out.println("Thank you for your order!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class DrinkOrder{
    private Drinks drink;
    private DrinkSize size;

    public Drinks getDrink() {
        return drink;
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkOrder(Drinks drink, DrinkSize size){
        this.drink = drink;
        this.size = size;
    }

}