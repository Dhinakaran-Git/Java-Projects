
public class Demo {

    private static String name;
    private static int age;
    private String empName;
    private final long PHNUMBER = 35467890987L;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Demo.name = name;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public static void main(String[] args) {
        Demo.setName("moosa");
        System.out.println(Demo.getName());

        Demo d1 = new Demo();
        d1.setEmpName("Sam");
        System.out.println(d1.getEmpName());
    }
}
