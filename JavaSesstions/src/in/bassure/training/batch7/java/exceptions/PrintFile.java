package in.bassure.training.batch7.java.exceptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class PrintFile {

    public static void main(String[] args) throws IOException {
        try (
                 var in = new FileReader("C:\\Users\\rkvod\\RKV\\TECHs\\bassure\\Rupesh\\training\\batch-7\\code\\Basics\\src\\in\\bassure\\training\\batch7\\java\\exceptions\\sample.txt");  var out = new FileOutputStream("C:\\Users\\rkvod\\RKV\\TECHs\\Languages\\IDE\\NetBeans\\Apache-NetBeans-15-bin-windows-x64-bak.exe")) {
            int input;
            while ((input = in.read()) != -1) {
                System.out.print((char) input);
            }
        }
    }

    public static void main3(String[] args) throws IOException, FileNotFoundException {
        FileReader in = new FileReader("C:\\Users\\rkvod\\RKV\\TECHs\\bassure\\Rupesh\\training\\batch-7\\code\\Basics\\src\\in\\bassure\\training\\batch7\\java\\exceptions\\sample.txt");

        int input;
        while ((input = in.read()) != -1) {
            System.out.print((char) input);
        }

        in.close();

    }

    public static void main2(String[] args) {
        FileReader in = null;
        try {
            in = new FileReader("C:\\Users\\rkvod\\RKV\\TECHs\\bassure\\Rupesh\\training\\batch-7\\code\\Basics\\src\\in\\bassure\\training\\batch7\\java\\exceptions\\sample.txt");

            int input;
            while ((input = in.read()) != -1) {
                System.out.print((char) input);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void main1(String[] args) {
        FileReader in = null;
        try {
            in = new FileReader("C:\\Users\\rkvod\\RKV\\TECHs\\bassure\\Rupesh\\training\\batch-7\\code\\Basics\\src\\in\\bassure\\training\\batch7\\java\\exceptions\\sample.txt");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        int input;

        try {
            while ((input = in.read()) != -1) {
                System.out.print((char) input);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
