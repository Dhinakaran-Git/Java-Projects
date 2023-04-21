package javaapplication1.CustomException;

public class BookPage {

    String content = "new content";
    final int TOTALPAGES;
    int currentPage;

    public BookPage() {
        this.TOTALPAGES = 500;
        this.currentPage = 5;
    }

    public BookPage(int totalPages, int currentPage) {
        this.TOTALPAGES = totalPages;
        this.currentPage = currentPage;
    }
}
