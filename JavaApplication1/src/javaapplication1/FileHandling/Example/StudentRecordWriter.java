package javaapplication1.FileHandling.Example;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentRecordWriter.java This program illustrates how to use the
 * DataOutputStream class for writing data to a file.
 *
 * @author www.codejava.net
 */
public class StudentRecordWriter {

    DataOutputStream dataOutput;

    public StudentRecordWriter(String outputFile) throws IOException {
        dataOutput = new DataOutputStream(new FileOutputStream(outputFile));
    }

    public void write(Student student) throws IOException {
        dataOutput.writeUTF(student.getName());
        dataOutput.writeBoolean(student.getGender());
        dataOutput.writeInt(student.getAge());
        dataOutput.writeFloat(student.getGrade());
    }

    public void save() throws IOException {
        dataOutput.close();
    }

    public static void main(String[] args) {

        String outputFile = "/home/bas200137/NetBeansProjects/JavaApplication1/src/javaapplication1/FileHandling/Example/studentdata.txt";

        List<Student> listStudent = new ArrayList<>();
        
        listStudent.add(new Student("Alice", false, 23, 80.5f));
        listStudent.add(new Student("Brian", true, 22, 95.0f));
        listStudent.add(new Student("Carol", false, 21, 79.8f));
        
        try {
            StudentRecordWriter writer = new StudentRecordWriter(outputFile);

            for (Student student : listStudent) {
                writer.write(student);
            }

            writer.save();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
