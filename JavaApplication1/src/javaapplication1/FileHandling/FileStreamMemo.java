package javaapplication1.FileHandling;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Objects;
import javaapplication1.Inheritance.DeepCopy.Car;
import javaapplication1.Inheritance.DeepCopy.Engine;

public class FileStreamMemo {

    public static void main1(String[] args) {
        FileReader in = null;
        Date start = new Date();
        try {
            in = new FileReader("/home/bas200137/Downloads/background.png");
            int input;

            while ((input = in.read()) != -1) {
                System.out.print((char) input);
            }
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());
        System.out.println(end.getTime() - start.getTime());
    }

    public static void main2(String[] args) {
        BufferedInputStream in = null;
        Date start = new Date();
        try {
            in = new BufferedInputStream(new FileInputStream("/home/bas200137/Downloads/background.png"));

            int input;

            while ((input = in.read()) != -1) {
                System.out.print((char) input);
            }
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());
        System.out.println(end.getTime() - start.getTime());
    }

    public static void main3(String[] args) {
        BufferedInputStream in = null;
        Date start = new Date();
        try {
            in = new BufferedInputStream(new FileInputStream("/home/bas200137/Downloads/background.png"));

            int input;

            while ((input = in.read()) != -1) {
                System.out.print((char) input);
            }
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());
        System.out.println(end.getTime() - start.getTime());
    }

    //Serializable
    public static void main(String[] args) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("/home/bas200137/NetBeansProjects/JavaApplication1/src/javaapplication1/FileHandling/sample_1.txt"));

            Car[] c1 = { new Car("BMW", "Red", new Engine(2000, "Petrol")) };
            out.writeObject(c1);

//            System.out.println(c1);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(out)) {
                try {
                    out.close();
                    System.out.println("Saved Sucessully");
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
    }

    //Deserializable
    public static void main12(String[] args) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("/home/bas200137/NetBeansProjects/JavaApplication1/src/javaapplication1/FileHandling/sample_1.txt"));

            Car c1 = new Car("BMW", "Red", new Engine(2000, "Petrol"));
            Car c = (Car) in.readObject();
            System.out.println(c);
//            System.out.println(c1);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
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

    public static void main6(String[] args) {
        File a = new File("/home/bas200137/NetBeansProjects/JavaApplication1/src/javaapplication1/FileHandling/sample_1.txt");

        System.out.println("IS FILE : " + a.isFile());
        System.out.println("Modified ON : " + new Date(a.lastModified()));
        System.out.println("FILE SIZE : " + a.length());
        System.out.println("FILE MEMOREY : " + a.getTotalSpace());
    }

    public static void main5(String[] args) {
        Date start = new Date();
        try {
            FileReader in = new FileReader("/home/bas200137/NetBeansProjects/JavaApplication1/src/javaapplication1/FileHandling/sample.txt");
            FileOutputStream out = new FileOutputStream("/home/bas200137/Downloads/background.png");

            int input;
            while ((input = in.read()) != -1) {
                System.out.print((char) input);
            }
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime());
    }
}
