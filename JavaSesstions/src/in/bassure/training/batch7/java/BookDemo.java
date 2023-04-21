package in.bassure.training.batch7.java;

public class BookDemo {

    public static void main(String[] args) {
        Book b1 = new Book();
        System.out.println(b1);
        
        b1.setAuthors("Author 1", "Author 2");
        System.out.println(b1);
        
        Book b2 = new Book();
        b2.setAuthors("Author A", "Author B", "Author C");
        System.out.println(b2);
        
        Book b3 = new Book();
        b3.setAuthors("Un Author");
        System.out.println(b3);
    }

    public static void main4(String[] args) {
        Book b1 = new Book("Java, How To Program",
                new String[]{"Dietel & Dietel"}, 565);

        System.out.println(b1);

        b1.setTitle("Let's Java");
        System.out.println(b1);
    }

    public static void main3(String[] args) {
        Class b1 = Book.class;
        Book bo1 = new Book();
        Object temp = new Object();
        someMethod(bo1);
    }

    public static void someMethod(Object param1) {
        System.out.println(param1.getClass().getName());
    }

    public static void main2(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

        Book b1 = new Book("Java, How To Program",
                new String[]{"Dietel"}, 589.6);
        Book b2 = new Book("Java, How To Program",
                new String[]{"Dietel"}, 589.6);
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b1.equals(b2));

        int hashCode = 20;
    }

    public static void main1(String[] args) {
        Book b1 = new Book("Java, How To Program",
                new String[]{"Dietel"}, 589.45);
        Book b2 = new Book("Let Us C",
                new String[]{"Kanitkar"}, 375.7);
        System.out.println(b1.getTitle());

        System.out.println(b1);
        System.out.println(b1.toString());
        System.out.println(b2);
        System.out.println(b2.toString());

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
    }

}
