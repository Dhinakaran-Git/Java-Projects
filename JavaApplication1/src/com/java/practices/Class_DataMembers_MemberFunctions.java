
class Actor {

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}

class Actor1 {

    @Override
    public String toString() {
        return "hello"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}

public class Class_DataMembers_MemberFunctions {

    public static void main(String[] args) {
        Actor a = new Actor();
        System.out.println(a.toString());

        Actor1 a1 = new Actor1();
        System.out.println(a1.toString());
    }
}
