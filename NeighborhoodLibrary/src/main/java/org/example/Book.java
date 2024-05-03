package org.example;

public class Book {
    //properties
    public int id;
    public String isbn;
    public String title;
    public boolean CheckedOut;
    public String checkedOutTo;


    //constructor
    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.CheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }
    //overloaded constructor

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }
//  getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean CheckedOut() {
        return CheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        CheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
}










