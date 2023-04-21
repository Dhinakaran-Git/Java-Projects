package in.bassure.training.batch7.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(
                new InputStreamReader(System.in)
        );

        System.out.print("Enter Name: ");
        String name = input.readLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(input.readLine());

        System.out.println(String.format("Name: %s # Age: %d", name, age));
    }
}
