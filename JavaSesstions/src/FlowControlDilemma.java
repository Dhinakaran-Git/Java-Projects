
public class FlowControlDilemma {

    public static void main(String[] args) {
        logicFor5();
        logicFor5();
        logicOnce();
        logicFor5();
        logicFor5();
        logicFor5();
    }
    
    public static void logicFor5(){
        System.out.println("Login 5");
    }
    
    public static void logicOnce(){
        System.out.println("Login Once");
    }

}
