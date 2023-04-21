package javaapplication1.FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyProgram {

    public static void main(String[] args) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("/home/bas200137/Downloads/Code 15 React Projects - Complete Course.mp4");
            os = new FileOutputStream("/home/bas200137/Downloads/Code 15 React Projects - Complete Course1.mp4");
            byte[] start = new byte[10240];
            int input;
            while ((input = is.read(start)) != 0) {
                os.write(input);
            }
            System.out.println("File Copied Successfully...");
        } finally {
            is.close();
            os.close();
        }
    }
}
