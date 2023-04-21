
public class SwitchDemo {

    public static void main(String[] args) {
        String input = "Bro";
        
        switch(input){
            case "hi":
                System.out.println("It's, very western");
                break;
            case "hello":
                System.out.println("It's formal");
                break;
            case "howdy":
                System.out.println("Texas Style, cowboys");
                break;
            default:
                System.out.println("Bad, you don't know how to wish");
        }
    }
    
    public static void main2(String[] args) {
        int month = 10;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31");
                break;
            case 2:
                System.out.println("28/29");
                break;
            default:
                System.out.println("Wrong Month");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30");
        }
    }

    public static void main1(String[] args) {
        int month = 11;

        switch (month) {
            case 11:
                System.out.println("11");
                System.out.println("Eleven");
            case 12:
                System.out.println("12");
            case 1:
                System.out.println("One");
            case 6:
                System.out.println("6");
            case 7:
                System.out.println("7");
            case 8:
                System.out.println("8");
            case 2:
                System.out.println("Two");
            case 3:
                System.out.println("3");
            case 4:
                System.out.println("4");
            case 5:
                System.out.println("5");
            case 9:
                System.out.println("9");
            case 10:
                System.out.println("10");
        }
    }
}
