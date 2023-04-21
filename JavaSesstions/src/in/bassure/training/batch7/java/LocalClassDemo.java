package in.bassure.training.batch7.java;

public class LocalClassDemo {

    public static void main(String[] args) {
        class LocalClass{
            String name;
            {
                name = "Defalut Name for LocalClass-name";
            }
        }
        
        LocalClass a = new LocalClass();
        System.out.println(a.name);
    }
    
    public static void someMethod(){
//        LocalClass b = new LocalClass();
    }

}
