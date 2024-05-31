package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a sandwich size: 1. 4 inch, 2. 8 inch, 3. 12 inch");
        int sizeChoice = scanner.nextInt();
        SandwichSize size = null;
        switch (sizeChoice) {
            case 1:
                size = SandwichSize.Four_Inch;
                break;
            case 2:
                size = SandwichSize.Eight_Inch;
                break;
            case 3:
                size = SandwichSize.Twelve_Inch;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        SandwichOrder order = new SandwichOrder(size);

        System.out.println("Add meats (type '0' to finish): 1. STEAK, 2. HAM, 3. SALAMI, 4. ROAST BEEF, 5. CHICKEN, 6. BACON");
        while (true) {
            int meatChoice = scanner.nextInt();
            if (meatChoice == 0) break;
            switch (meatChoice) {
                case 1:
                    order.addMeat(Meat.Steak);
                    break;
                case 2:
                    order.addMeat(Meat.Ham);
                    break;
                case 3:
                    order.addMeat(Meat.Salami);
                    break;
                case 4:
                    order.addMeat(Meat.RoastBeef);
                    break;
                case 5:
                    order.addMeat(Meat.Chicken);
                    break;
                case 6:
                    order.addMeat(Meat.Bacon);
                    break;
                default:
                    System.out.println("Invalid meat choice.");
            }
        }

        // Add extra meats
        System.out.println("Add extra meats (type '0' to finish): 1. EXTRA_STEAK, 2. EXTRA_HAM, 3. EXTRA_CHICKEN");
        while (true) {
            int extraMeatChoice = scanner.nextInt();
            if (extraMeatChoice == 0) break;
            switch (extraMeatChoice) {
                case 1:
                    order.addExtraMeat(ExtraMeat.Extra_Steak);
                    break;
                case 2:
                    order.addExtraMeat(ExtraMeat.Extra_Ham);
                    break;
                case 3:
                    order.addExtraMeat(ExtraMeat.Extra_Chicken);
                    break;
                default:
                    System.out.println("Invalid extra meat choice.");
            }
        }

        // Add cheeses
        System.out.println("Add cheeses (type '0' to finish): 1. American, 2. Provolone, 3. Cheddar, 4. Swiss");
        while (true) {
            int cheeseChoice = scanner.nextInt();
            if (cheeseChoice == 0) break;
            switch (cheeseChoice) {
                case 1:
                    order.addCheese(Cheese.American);
                    break;
                case 2:
                    order.addCheese(Cheese.Provolone);
                case 3:
                    order.addCheese(Cheese.Cheddar);
                case 4:
                    order.addCheese(Cheese.Swiss);
                    break;
                default:
                    System.out.println("Invalid cheese choice.");
            }
        }

        // Add extra cheeses
        System.out.println("Add extra cheeses (type '0' to finish): 1. Extra American,2. Extra Provolone 3. Extra Cheddar,4. Extra Swiss");
        while (true) {
            int extraCheeseChoice = scanner.nextInt();
            if (extraCheeseChoice == 0) break;
            switch (extraCheeseChoice) {
                case 1:
                    order.addExtraCheese(ExtraCheese.Extra_American);
                    break;
                case 2:
                    order.addExtraCheese(ExtraCheese.Extra_Provolone);
                    break;
                case 3:
                    order.addExtraCheese(ExtraCheese.Extra_Cheddar);
                case 4:
                    order.addExtraCheese(ExtraCheese.Extra_Swiss);
                default:
                    System.out.println("Invalid extra cheese choice.");
            }
        }

        // Add regular toppings
        System.out.println("Add regular toppings (type '0' to finish): 1. LETTUCE, 2. TOMATO, 3. PEPPERS, 4. ONIONS, 5. JALAPENOS, 6. CUCUMBERS, 7. PICKLES, 8. GUACAMOLE, 9. MUSHROOMS");
        while (true) {
            int regularToppingChoice = scanner.nextInt();
            if (regularToppingChoice == 0) break;
            switch (regularToppingChoice) {
                case 1:
                    order.addToppings(Toppings.Lettuce);
                    break;
                case 2:
                    order.addToppings(Toppings.Tomatoes);
                    break;
                case 3:
                    order.addToppings(Toppings.Peppers);
                    break;
                case 4:
                    order.addToppings(Toppings.Onions);
                    break;
                case 5:
                    order.addToppings(Toppings.Jalapenos);
                    break;
                case 6:
                    order.addToppings(Toppings.Cucumbers);
                    break;
                case 7:
                    order.addToppings(Toppings.Pickles);
                    break;
                case 8:
                    order.addToppings(Toppings.Guacamole);
                    break;
                case 9:
                    order.addToppings(Toppings.Mushrooms);
                    break;
                default:
                    System.out.println("Invalid regular topping choice.");
            }
        }

        // Add sauces
        System.out.println("Add sauces (type '0' to finish): 1. MAYO, 2. MUSTARD, 3. KETCHUP, 4. THOUSAND ISLANDS, 5. VINAIGRETTE");
        while (true) {
            int sauceChoice = scanner.nextInt();
            if (sauceChoice == 0) break;
            switch (sauceChoice) {
                case 1:
                    order.addSauce(Sauce.MAYO);
                    break;
                case 2:
                    order.addSauce(Sauce.MUSTARD);
                    break;
                case 3:
                    order.addSauce(Sauce.KETCHUP);
                    break;
                case 4:
                    order.addSauce(Sauce.THOUSAND_ISLANDS);
                    break;
                case 5:
                    order.addSauce(Sauce.VINAIGRETTE);
                    break;
                default:
                    System.out.println("Invalid sauce choice.");
            }
        }
        //add chips
        System.out.println("Add Chips (Type '0' to Finish): 1. Doritos, 2. Lays, 3. Kettle Cooked");
        while (true) {
            int chipChoice = scanner.nextInt();
            if (chipChoice == 0) break;
            switch (chipChoice) {
                case 1:
                    order.addChips(Chips.doritos);
                    break;
                case 2:
                    order.addChips(Chips.lays);
                    break;
                case 3:
                    order.addChips(Chips.kettle);
                    break;
                default:
                    System.out.println("Invalid Chip Choice.");
            }
        }
        System.out.println("Add Drinks (Type '0' to Finish): 1. Pepsi, 2. Coke, 3. Sprite, 4. RootBeer");
        while (true) {
            int drinkChoice = scanner.nextInt();
            if (drinkChoice == 0) break;
            Drinks drink = null;
            switch (drinkChoice) {
                case 1:
                    drink = Drinks.pepsi;
                    break;
                case 2:
                    drink = Drinks.coke;
                    break;
                case 3:
                    drink = Drinks.sprite;
                    break;
                case 4:
                    drink = Drinks.rootBeer;
                    break;
                default:
                    System.out.println("Invalid Drink Choice.");
                    continue;
            }

            System.out.println("Choose Drink Size: 1. Small, 2. Medium, 3. Large");
            int drinkSizeChoice = scanner.nextInt();
            DrinkSize drinksize = null;
            switch (drinkSizeChoice) {
                case 1:
                    drinksize = DrinkSize.Small;
                    break;
                case 2:
                    drinksize = DrinkSize.Medium;
                    break;

                case 3:
                    drinksize = DrinkSize.Large;
                    break;
                default:
                    System.out.println("Invalid Drink Size.");
            }
            order.addDrinkOrder(new DrinkOrder(drink, drinksize));
        }

        // Save the order
        try {
            order.saveOrderToCSV();
            System.out.println("Order saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Do you want to checkout and see your order ? (yes/no)");
        String checkoutChoice = scanner.next().toLowerCase();
        if (checkoutChoice.equals("yes")) {
            SandwichOrder.checkout();
        } else if (checkoutChoice.equals("no")) {
            try {
                SandwichOrder.deleteLastLineFromCSV();
                System.out.println("Order has been canceled.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




