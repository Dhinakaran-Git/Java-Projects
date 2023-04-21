package in.bassure.training.batch7.java.collections;

import in.bassure.training.batch7.java.Book;
import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {

    @Override
    public int compare(Book a, Book b) {
        if (a.getPrice() < b.getPrice()) {
            return -1;
        } else if (a.getPrice() > b.getPrice()) {
            return 1;
        }
        return 0;
    }
}
