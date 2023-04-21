package in.bassure.training.batch7.java.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;

public class IOStreamsDemo {
    public static void main(String... args) throws IOException{
        //File f = new File("C:\\Users\\rkvod\\RKV\\TECHs\\bassure\\Rupesh\\training\\batch-7\\code\\Basics\\src\\in\\bassure\\training\\batch7\\java\\exceptions\\sample_copy.txt");
        File f = new File("hello.txt");
        if(!f.exists()){
            f.createNewFile();
        }

        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.getPath());
        
        Path fp = f.toPath();
    }
    
    public static void main6(String[] args) {
        File a = new File("C:\\Users\\rkvod\\RKV\\TECHs\\bassure\\Rupesh\\training\\batch-7\\code\\Basics\\src\\in\\bassure\\training\\batch7\\java\\exceptions\\sample_copy.txt");

        System.out.println("IS FILE: " + a.isFile());
        System.out.println("Modified On: " + new Date(a.lastModified()));
        System.out.println("Size: " + a.length());
        System.out.println("Memory: " + a.getTotalSpace());

        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root);
        }
    }

    public static void main5(String[] args) {
        BufferedReader in = null;
        try {
            //in = new BufferedReader(new InputStreamReader(new FileInputStream("")));
            in = new BufferedReader(new FileReader("C:\\Users\\rkvod\\RKV\\TECHs\\bassure\\Rupesh\\training\\batch-7\\code\\Basics\\src\\in\\bassure\\training\\batch7\\java\\exceptions\\sample_copy.txt"));

            String data = null;

            while (Objects.nonNull(data = in.readLine())) {
                System.out.println(data);
            }
            System.out.println(File.separator);
            System.out.println(File.pathSeparator);
            
        } catch (IOException ex) {
            ex.printStackTrace();
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

    public static void main4(String[] args) {
        DataInputStream in = null;
        try {
            in = new DataInputStream(new FileInputStream("C:\\Users\\rkvod\\RKV\\TECHs\\bassure\\Rupesh\\training\\batch-7\\code\\Basics\\src\\in\\bassure\\training\\batch7\\java\\exceptions\\sample.txt"));

            System.out.println(in.readInt());
            System.out.println(in.readByte());
            System.out.println(in.readBoolean());
            System.out.println(in.readShort());
            System.out.println(in.readUTF());
            System.out.println(in.readChar());
            System.out.println(in.readLong());
            System.out.println(String.format("%f", in.readDouble()));
            System.out.println(in.readFloat());
            
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

    public static void main3(String[] args) {
        int i = 34567890;
        byte b = 115;
        short s = 754;
        long howLong = 984672514375L;
        float f = 567.87395F;
        double d = 89274568.3912086;
        boolean bool = true;
        char c = 'j';
        String str = "Dennis";

        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream("C:\\Users\\rkvod\\RKV\\TECHs\\bassure\\Rupesh\\training\\batch-7\\code\\Basics\\src\\in\\bassure\\training\\batch7\\java\\exceptions\\sample.txt"));

            out.writeInt(i);
            out.writeByte(b);
            out.writeBoolean(bool);
            out.writeShort(s);
            out.writeUTF(str);
            out.writeChar(c);
            out.writeLong(howLong);
            out.writeDouble(d);
            out.writeFloat(f);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(out)) {
                try {
                    out.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void main2(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("C:\\Users\\rkvod\\RKV\\TECHs\\Languages\\IDE\\NetBeans\\Apache-NetBeans-15-bin-windows-x64.exe");
            out = new FileOutputStream("C:\\Users\\rkvod\\RKV\\TECHs\\Languages\\IDE\\NetBeans\\Apache-NetBeans-15-bin-windows-x64-bak.exe");

            Date start = new Date();
            byte[] input = new byte[10240];
            while ((in.read(input)) > 0) {
                out.write(input);
            }
            System.out.println("File copied successfully.");
            System.out.println(new Date().getTime() - start.getTime());
            
            FileDescriptor fd = in.getFD();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(out)) {
                try {
                    out.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void main1(String[] args) throws IOException {
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
