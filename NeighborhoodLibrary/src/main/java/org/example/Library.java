package org.example;

import java.util.Scanner;

public class Library {
        public static Book[] book;

        public static void library() {

                book = new Book[20];
                book[0] = new Book(1, "989-356528", "To Kill A Mockingbird");
                book[1] = new Book(2, "989-238718", "The Great Gatsby");
                book[2] = new Book(3, "989-736412", "Dune");
                book[3] = new Book(4, "989-928437", "The lord of the rings");
                book[4] = new Book(5, "989-182743", "Harry Potter and the Sorcerers Stone");
                book[5] = new Book(6, "989-182764", "Harry Potter and the Chamber of Secrets");
                book[6] = new Book(7, "989-182734", "Harry Potter and The Prisoner of Azkaban");
                book[7] = new Book(8, "989-073264", "Of Mice and Men");
                book[8] = new Book(9, "989-183526", "Animal Farm");
                book[9] = new Book(10, "989-647263", "The Alchemist");
                book[10] = new Book(11, "989-964827", "The Da Vinci Code");
                book[11] = new Book(12, "989-476254", "The Shining");
                book[12] = new Book(13, "989-010273", "The Hunger Games");
                book[13] = new Book(14, "989-816273", "The Road");
                book[14] = new Book(15, "989-673827", "Initial D Volume 1");
                book[15] = new Book(16, "989-768437", "Jiu jitsu Kaisen Volume 8 ");
                book[16] = new Book(17, "989-000817", "MF Ghost Volume 4");
                book[17] = new Book(18, "989-777182", "Horimiya Volume 6");
                book[18] = new Book(19, "989-771622", "One Piece Volume 105");
                book[19] = new Book(20, "989-771823", "Initial D");


        }

        public static void showAvailableBooks() {
                System.out.println("Here is the list of available books: ");
                for (Book book : book) {
                        if (book.CheckedOut() == false) {
                                System.out.printf("ID: %d,TITLE: %s,ISBN: %s,Is Checked out? %b\n", book.getId(), book.getTitle(), book.getIsbn(), book.CheckedOut());
                        }
                }
                Scanner scanner = new Scanner(System.in);
                System.out.println(" Please select an option ");
                System.out.println("1.) Checkout a Book");
                System.out.println("2.) Home Screen");
                String input = scanner.nextLine();

                if (input.equals("1")) {
                        checkOut();
                } else if (input.equals("2")) {
                        Main.greeting();
                } else {
                        System.out.println("no bueno");

                }
        }

        public static void checkedOutBooks() {
                for (Book book : book) {
                        if (book.CheckedOut() == true) {
                                System.out.printf("ID: %d, TITLE: %s, ISBN: %s, Is Checked out: %b\n",
                                        book.getId(), book.getTitle(), book.getIsbn(), book.CheckedOut());
                        }
                }
                Scanner scanner = new Scanner(System.in);

                System.out.println("(1) Check in a book");
                System.out.println("(2) Home screen");
                String input = scanner.nextLine();

                if (input.equals("1")) {
                        checkIn();

                } else if (input.equals("2")){
                        Main.greeting();
                } else {
                        System.out.println("no bueno");

                }
        }

        public static void checkOut() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please Provide the ID of the book you'd like to check out: ");
                int input = scanner.nextInt();

                scanner.nextLine();
                System.out.println("Please enter your name:");
                String name = scanner.nextLine();

                for (Book book : book) {
                        if (input == book.getId()) {
                                book.setCheckedOutTo(name);
                                book.setCheckedOut(true);
                                System.out.println("Book Is Checked Out to: " + book.getCheckedOutTo());
                        }
                }
                Main.greeting();
        }

        public static void checkIn() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please Provide the ID of the book you'd like to check in: ");
                int input = scanner.nextInt();

                for (Book book : book) {
                        if (input == book.getId()) {
                                book.setCheckedOut(false);
                                System.out.println("Book Is Checked in!");
                        }
                }
                Main.greeting();
        }
}



