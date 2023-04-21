package lms_with_arrays_v1;

public class Book {

    private int isbn_No;
    private String title;
    private final String author;
    private boolean isThere;
    private boolean isDamaged;

    public int getIsbn_No() {
        return isbn_No;
    }

    public void setIsbn_No(int isbn_no) {
        this.isbn_No = isbn_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String TITLE) {
        this.title = TITLE;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isThere() {
        return isThere;
    }

    public void setIsThere(boolean isThere) {
        this.isThere = isThere;
    }

    public boolean isIsDamaged() {
        return isDamaged;
    }

    public void setIsDamaged(boolean isDamaged) {
        this.isDamaged = isDamaged;
    }
    
    public Book(int isbn_no, String title, String author, boolean isThere) {
        this.isbn_No = isbn_no;
        this.title = title;
        this.author = author;
        this.isThere = isThere;
    }

    @Override
    public String toString() {
        return String.format("%8s %-5s %-20s %-20s %-18s %-18s\n", isbn_No, " ", title, author, isThere, isDamaged);
    }
}
