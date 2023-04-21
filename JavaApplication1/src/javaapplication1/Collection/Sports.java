package javaapplication1.Collection;

import java.util.ArrayList;

class Cricket {

    String ball;

    public Cricket(String ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "Cricketball = " + ball;
    }
}

class Foodball {

    String ball;

    public Foodball(String ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "Foodball = " + ball;
    }
}

class Vollyball {

    String ball;
    int count;

    public Vollyball(String ball, int count) {
        this.ball = ball;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Vollyball = " + ball + ", Count = " + count;
    }
}

public class Sports {

    public static void main(String[] args) {
        //collection
        ArrayList al = new ArrayList();

//        Cricket c = new Cricket("Cricketball");
//        Foodball f = new Foodball("Foodball");
//        Vollyball w = new Vollyball("Vollyball",10);
        al.add(new Cricket("Cricketball"));
        al.add(new Foodball("Foodball"));
        al.add(new Vollyball("vollyball", 13));
        
        System.out.println(al);
        
        for (Object newarray : al) {
            System.out.println(newarray);
        }
    }
}
