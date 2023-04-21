
public class ScopesDemo {

    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = "Hello";
        String s4 = "Hello";
                
        System.out.println(s2);
        System.out.println(s2.charAt(4));
        System.out.println(s2.toLowerCase());
        System.out.println(s2.toUpperCase());
        System.out.println(s2);
        
        String s3 = s2.toLowerCase();
        System.out.println(s3);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s4);
        
        if(s1 == s2){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
        
        if(s2 == s4){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
}
