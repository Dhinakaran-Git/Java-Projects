package javaapplication1.CustomException;

public class BookDemo {

    public static void main(String[] args) {
        BookPage bookinfo = new BookPage(250, 1);
        Book inBook = new Book(bookinfo);
//        inBook.searchPageNo(3);
        inBook.getCurrentPage();
    }
}
