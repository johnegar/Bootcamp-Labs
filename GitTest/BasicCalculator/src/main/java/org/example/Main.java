package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int firstNumber = 5;
        int secondNumber = 12;

        //math symbols are + - / * %
        int A = firstNumber + secondNumber;
        int S = firstNumber - secondNumber;
        int M = firstNumber * secondNumber;
        int D = firstNumber / secondNumber;

        System.out.println("firstNumber = 5, secondNumber = 12");
        System.out.println("""
                Possible Calculations
                (A)dd
                (S)Subtract
                (M)ultiply
                (D)ivide
                PLease Select an operation:""");

        Scanner scanner = new Scanner(System.in);

        String result = scanner.nextLine();

        if (result.equalsIgnoreCase("A")) {
            System.out.println(firstNumber + "+" + secondNumber + "=" + (A));
        } else if (result.equalsIgnoreCase("S")) {
            System.out.println(firstNumber + "-" + secondNumber + "=" + (S));
        } else if (result.equalsIgnoreCase("M")) {
            System.out.println(firstNumber + "*" + secondNumber + "=" + (M));
        } else if (result.equalsIgnoreCase("D")) {
            System.out.println(firstNumber + "/" + secondNumber + "=" + (D));

        }
    }
}