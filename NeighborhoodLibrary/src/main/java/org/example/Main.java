package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library.library();
        greeting();


    }
        public static void greeting(){

        Scanner scanner = new Scanner(System.in);


            System.out.println("Welcome to the library!");
            System.out.println("1). Available Books");
            System.out.println("2). Checked Out Books");
            System.out.println("3). Peace out");

            var input = scanner.nextLine();

            switch(input){
                case "1":
                    Library.showAvailableBooks();
                    break;
                case "2":
                    Library.checkedOutBooks();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry I don't Recognize that Input.");
                    break;
            }
        }

    }





