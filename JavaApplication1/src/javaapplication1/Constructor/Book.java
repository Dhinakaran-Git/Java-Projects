package javaapplication1.Constructor;

import java.util.*;

public class Book implements Cloneable {

    private String title;
    private String author;
    private double price;

    public Book() {
        super();
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Book[%s, %s, %f]", title, author, price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode()) {
            return true;
        }
        return false;
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book copy = new Book("Let us C", "James Gooslean", 132.2);
        return copy;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
