package in.bassure.training.batch7.java;

public class NodeStackDemo {

    public static void main(String[] args) {
        NodeStackV3<String> ns = new NodeStackV3<>();

        ns.push("James");
//        ns.push(123);

        NodeStackV3<Book> nsb = new NodeStackV3<>();
        nsb.push(new Book());
//        nsb.push("Hello");
    }

    public static void main2(String[] args) {

        NodeStackV2 ns = new NodeStackV2();

        ns.push("James");
        ns.push("Dennis");
        ns.push(25);
        ns.push("Bloch");
        ns.push(234.567);

        ns.print();

        System.out.println(ns.size());
        System.out.println(ns.peek());
        System.out.println(ns.pop());
        System.out.println(ns.size());

        String x = (String) ns.pop();
        System.out.println(x);

        System.out.println(ns.size());
        System.out.println(ns.pop());
        System.out.println(ns.size());
        ns.pop();
    }

    public static void main1(String[] args) {
        NodeStack ns = new NodeStack();

        ns.push(20);
        ns.push(10);
        ns.push(15);

        ns.print();

        System.out.println(ns.size());
        System.out.println(ns.peek());
        System.out.println(ns.pop());
        System.out.println(ns.size());
        System.out.println(ns.pop());
        System.out.println(ns.size());
        System.out.println(ns.pop());
        System.out.println(ns.size());
        ns.pop();
    }

}
