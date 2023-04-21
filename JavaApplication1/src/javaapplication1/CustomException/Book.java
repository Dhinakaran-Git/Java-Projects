package javaapplication1.CustomException;

public class Book {

    final String bookName;
    final String author;
    BookPage pages;

    public Book(String bookName, String author, BookPage page) {
        this.bookName = bookName;
        this.author = author;
        this.pages = page;
    }

    public Book(BookPage page) {
        this.bookName = "Java";
        this.author = "Rupesh";
        this.pages = page;
    }

    public void getCurrentPage() {
        System.out.println("Current Page is : " + pages.currentPage);
    }

    public void searchPageNo(int num) throws BookException {
        pages.currentPage = num;

        if (num <= 0) {
            throw new BookException(num + ", Cannot find page no");
        }

        if (num > pages.TOTALPAGES) {
            throw new BookException(num + ", The given Page Out of limet");
        }
        System.out.println("seaching Page No : " + pages.currentPage);
    }

    public void turnLeft() throws BookException {
        pages.currentPage += 1;

        if (pages.currentPage == pages.TOTALPAGES) {
            throw new BookException(pages.currentPage + ", The book has No More Page");
        }

        System.out.println("The Current Page is : " + pages.currentPage);
    }

    public void turnRight() throws BookException {
        pages.currentPage = pages.currentPage - 1;

        if (pages.currentPage <= 0) {
            throw new BookException(pages.currentPage + ", is not a valid page to view");
        }

        System.out.println("the current page is : " + pages.currentPage);
    }

    @Override
    public String toString() {
        return "Book{" + "bookName=" + bookName + ", author=" + author + ", pages=" + pages + '}';
    }
}
