package in.bassure.training.batch7.java.inheritance;

public class InheritanceDemo {

    public static void main(String[] args) {
        Animal a = new Tiger("Shera");
        System.out.println(a.getName());

        System.out.println(a.whatCanYouDo());
    }

    public static void main1(String[] args) {
        Animal a = new Tiger();
        a.whoAmI();
    }

}
