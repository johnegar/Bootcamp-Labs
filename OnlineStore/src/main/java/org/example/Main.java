package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static List<Product> products;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to the online store!");
    System.out.println("please select one of the following options:\n (1):Display Products \n (2):Display Cart \n (3):Exit");

        String input = scanner.nextLine();

        switch(input){
            case "1":
            Screens.displayProducts(
            );
                break;

            case "2":
            Screens.  displayCart( products,scanner);
                break;

            case "3":
            System.exit(0);
            break;

            default:
                System.out.println("Incorrect Input");
        }




        }


    }
