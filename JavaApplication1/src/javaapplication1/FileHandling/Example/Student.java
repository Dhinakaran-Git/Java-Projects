package javaapplication1.FileHandling.Example;

/**
 * Student.java This class represents a Student
 *
 * @author www.codejava.net
 */
public class Student {

    private String name;
    private boolean gender;
    private int age;
    private float grade;

    public Student() {
    }

    public Student(String name, boolean gender, int age, float grade) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
