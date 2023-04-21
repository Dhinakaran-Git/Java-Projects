package in.bassure.training.batch7.java.collections;

import in.bassure.training.batch7.java.Book;
import in.bassure.training.batch7.java.Chair;
import in.bassure.training.batch7.java.WaterBottle;
import java.util.random.RandomGenerator;

public class MyTreeDemo {

    public static void main(String[] args) {
        
    }

    public static void main5(String[] args) {
        var bookTree = new MyGenericTree<Book>();
        Book a = new Book("Java, How To Program", null, 568);
        Book b = new Book("Let Us C", null, 423);
        Book c = new Book("HTML, Black Book", null, 675);

        bookTree.add(a);
        bookTree.add(b);
        bookTree.add(c);

        bookTree.printInOrder();
    }

    public static void main4(String[] args) {
        var bottleTree = new MyGenericTree<WaterBottle>();

        bottleTree.add(new WaterBottle("A", 1000));
        bottleTree.add(new WaterBottle("B", 950));
        bottleTree.add(new WaterBottle("C", 750));
        bottleTree.add(new WaterBottle("A", 1500));

        bottleTree.printInOrder();
    }

    public static void main3(String[] args) {
        Character c;
        MyGenericTree<String> tree = new MyGenericTree<>();
        tree.add("Stroustrup");
        tree.add("James");
        tree.add("Dennis");
        tree.add("Rod");

        tree.printInOrder();
    }

    public static void main2(String[] args) {
        MyTree tree = new MyTree();
        tree.printInOrder();

        RandomGenerator.getDefault().ints(30, 10, 100)
                .forEach(tree::add);

        tree.printInOrder();

    }

    public static void main1(String[] args) {
        MyTree tree = new MyTree();

        System.out.println("5 exists: " + tree.exists(5));

        tree.add(20);
        tree.add(18);
        System.out.println("20 exists: " + tree.exists(20));
        System.out.println("18 exists: " + tree.exists(18));

        tree.add(12);
        tree.add(15);
        tree.add(10);
        tree.printInOrder();
    }

}
