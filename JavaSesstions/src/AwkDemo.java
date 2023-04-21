public class AwkDemo {
    public static void main(String[] args) {
        Integer i = 5;
        Integer a = i * 100;
        Integer b = i * 100;
        
        System.out.println(a == b);
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
    }
    
    public static void main1(String[] args) {
        Integer a = 128;
        Integer b = Integer.valueOf(128);
        long c = b.longValue();
        int value = Integer.valueOf("20", 8);
        System.out.println(value);
        
        System.out.println(a.intValue() == b);
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
    
}
