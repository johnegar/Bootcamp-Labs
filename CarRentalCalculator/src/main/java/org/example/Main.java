package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and Welcome to car rental company website");
        //String pickupDate;
        //int daysRented;
        //int age;
        //boolean tollTag;
        //boolean GPS;
        //boolean roadsideAssistance;
        double underAgeCharge = 0;
        double baseRental = 29.99;
        System.out.println(" What pickup date works for you ?" + " Please enter a date in mm/dd format: ");
        String pickupDate = scanner.nextLine();

        System.out.println("How many days will you be renting a vehicle ?");
        double daysRented = scanner.nextInt();
        double total = baseRental * daysRented;

        scanner.nextLine();

        System.out.println("Would you like to add a tollTag ? (3.95$/day) \n(Y)ES\n(N)O ");
        String tollTag = scanner.nextLine();
        switch (tollTag.toUpperCase()) {
            case "Y":
                System.out.println("A daily charge of 3.95$/day will be added");
                total = total + (3.95 * daysRented);
                break;
            case "N":
                System.out.println("No Charge will be added");
                break;
            //System.out.println("%.2f" + option1);
        }
        System.out.println("Would You like to add a roadside assistance ? (3.95$/day)\n(Y)ES\n(N)O");
        String roadsideAssistance = scanner.nextLine();
        switch (roadsideAssistance.toUpperCase()) {
            case "Y":
                System.out.println("A daily charge of 3.95$/day Will be added");
                total = total + (3.95 * daysRented);
                break;
            case "N":
                System.out.println("No Additional Charges will be added");
                break;


        }
        System.out.println("Would you like to add a GPS ? (2.95$/day)\n(Y)ES\n(N)O");
        String GPS = scanner.nextLine();
        switch (GPS.toUpperCase()) {
            case "Y":
                System.out.println("A daily charge of 2.95$/day Will be added");
                total = total + (2.95 * daysRented);
                break;
            case "N":
                System.out.println("No Additional charges will be added");
                break;

        }
        System.out.println("What is your age ?");
        int age = scanner.nextInt();
        if (age < 25) {
            System.out.println(" A surcharge of 30% will be added to your total.\n here is the total cost of your rental!");
            underAgeCharge = ((baseRental * daysRented) * .30);
            total = total + underAgeCharge;
        } else {
            System.out.println("Thank You!");
        }
        double options = total - (baseRental * daysRented) - underAgeCharge;
        System.out.printf("BaseRental: $%.2f\nOptions: $%.2f\nUnderage driver surcharge: $%.2f\nTotal: $%.2f\n", (baseRental * daysRented),options, underAgeCharge, total);

        System.out.println("Thank you for renting from us! Enjoy your vehicle!");
    }
}
/* PSEUDO CODE
-ask the user for a preferred pickup date(string)
collect their input
-how many days will they occupy the rental
collect their input
-ask the user if they'd like to add an electronic toll tag at a rate of 3.95$/day
collect input and add to total
-ask the user if they'd like to add roadside assistance at a rate of 3.95$/day
collect input and add to total
-ask if they'd like to add a gps at a rate of 2.95$/day
collect input and add to total
-ask for their age
collect input, if input is less than 25 a surcharge of 30% will be added to the base rental fee
collect and total all the costs and output the total for the user
 */
