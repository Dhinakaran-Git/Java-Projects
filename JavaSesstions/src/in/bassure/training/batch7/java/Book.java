package in.bassure.training.batch7.java;

import java.util.Arrays;
import java.util.Objects;

public class Book implements Comparable<Book> {

    private String title;
    private String[] authors;
    private double price;

    @Override
    public int compareTo(Book that) {
        return this.title.compareTo(that.title);
    }

    public Book() {
        super();
    }

    public Book(String title, String[] author, double price) {
        this.title = title;
        this.authors = author;
        this.price = price;
    }

    @Override
    public Book clone() {
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }

    @Override
    public boolean equals(Object that) {
        if (this.hashCode() == that.hashCode()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Book[%s, %s, %f]", title, Arrays.toString(authors), price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
