package javaapplication1.Constructor;

public class BookDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Book b = new Book();
        Book b1 = new Book("Let us C", "James", 12.2);
        Book b2 = new Book("Let us C", "James Gooslean", 132.2);

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b.getClass());
        System.out.println(b1.equals(b2));
        System.out.println(b1.toString());
        System.out.println(b2);

        Book copyBook = (Book) b1.clone();
        b1.setTitle("Harry potter");
        System.out.println(b1);
        System.out.println(copyBook);
    }

}
