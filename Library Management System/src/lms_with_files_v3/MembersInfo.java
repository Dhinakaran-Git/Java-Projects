package lms_with_files_v3;

public class MembersInfo {

    private int memberId;
    private String name;
    private int age;
    private String gender;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s%-20s%-15s%-18s", memberId, name, age, gender);
    }

    public MembersInfo(int memberId, String name, int age, String gender) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}