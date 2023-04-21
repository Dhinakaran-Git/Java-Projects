
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lms_with_files_v3.Book;

public class Test {

    public static void main(String[] args) {
        try {
            File f = new File("/home/bas200137/NetBeansProjects/Library Management System/src/library_management_system/BooksData.txt");
            if (!f.exists()) {
                f.createNewFile();
            } else {
                Book[] books = {
//                    new Book(1001, "New Moons", "Suzanne", true),
//                    new Book(1002, "PHP", "Collins", true),
//                    new Book(1003, "Sql", "Newport", true),
//                    new Book(1004, "Javascript", "James", true),
//                    new Book(1005, "English", "Joe", false),
//                    new Book(1006, "Java", "Rupesh", false),
//                    new Book(1007, "C++", "Jenny", false)
                };

                ArrayList<Book> al = new ArrayList<>();

                for (Object boo : books) {
                    al.add((Book) boo);
                }

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(al);
                oos.close();
                System.out.println("Done");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("/home/bas200137/NetBeansProjects/Library Management System/src/library_management_system/sample.txt"));
            Book b1 = null;
            List array = new ArrayList();
            while (true) {
                try {
                    b1 = (Book) in.readObject();
                    array.add(b1);
                } catch (EOFException info) {
                    break;
                } catch (ClassNotFoundException info) {
                    info.printStackTrace();
                }
            }

            Iterator itr = array.iterator();

            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
