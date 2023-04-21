package in.bassure.training.batch7.java.collections;

import in.bassure.training.batch7.java.Book;
import in.bassure.training.batch7.java.Chair;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        Comparator<Chair> chairBrandComparator = new Comparator<>() {
            @Override
            public int compare(Chair a, Chair b) {
                return a.getBrand().compareTo(b.getBrand());
            }
        };
        Set<Chair> set = new TreeSet<>(chairBrandComparator);

        Chair a = new Chair("Metal", "Transteel");
        Chair b = new Chair("Plastic", "Neelkamal");
        Chair c = new Chair("Wooden", "Wakefit");

        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println(set);
    }

    public static void main6(String[] args) {
        Set<Chair> set = new TreeSet<>(new ChairPriceComparator());

        Chair a = new Chair(200);
        Chair b = new Chair(300);
        Chair c = new Chair(275);

        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println(set);
    }

    public static void main5(String[] args) {
        TreeSet<Book> set = new TreeSet<>(new BookPriceComparator());
        Book a = new Book("Java, How To Program", null, 568);
        Book b = new Book("Let Us C", null, 423);
        Book c = new Book("HTML, Black Book", null, 675);
        Book d = new Book("Java, How To Program", null, 745);

        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);

        System.out.println(set);
    }

    public static void main4(String[] args) {
        Set data = new TreeSet();
        data.addAll(Set.of(10, 20, 15, 5));
        performSomeJob(data);
    }

    public static void performSomeJob(Set input) {
        System.out.println(input);
        input.stream().sorted().forEach(System.out::println);
    }

    public static void main3(String[] args) {
        LinkedHashSet<Integer> set1 = new LinkedHashSet();
        set1.add(20);
        set1.add(25);
        System.out.println(set1);

        set1.addAll(Set.of(10, 12, 15));
        System.out.println(set1);

        //set1.removeAll(Set.of(25, 15));
        set1.retainAll(Set.of(25, 15));
        System.out.println(set1);

        Object[] arr = set1.toArray();
        Integer[] arr2 = set1.toArray(new Integer[]{});
        System.out.println(Arrays.toString(arr2));
    }

    public static void main2(String[] args) {
        Set<Integer> data = Set.of(15, 12, 21);
        System.out.println(data);

        Iterator<Integer> iter = data.iterator();
        int sum = 0;
        while (iter.hasNext()) {
            sum += iter.next();
        }

        System.out.println("Sum: " + sum);

        data.add(22);
        System.out.println(data);
    }

    public static void main1(String[] args) {
        LinkedHashSet s1 = new LinkedHashSet();

        s1.add(45);
        s1.add("Java");
        s1.add(34.78);
        s1.add(false);

        System.out.println(s1);
    }

}
