package javaapplication1.FileHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class PrintFile {

    public static void main(String[] args) {
        FileReader in = null;
        try {
            in = new FileReader("/home/bas200137/NetBeansProjects/JavaApplication1/src/javaapplication1/FileHandling/sample.txt");
            int input;
            
            while ((input = in.read()) != -1) {
                System.out.print((char) input);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
    }
}