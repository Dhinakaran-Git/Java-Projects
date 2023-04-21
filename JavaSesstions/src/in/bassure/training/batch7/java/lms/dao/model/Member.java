package in.bassure.training.batch7.java.lms.dao.model;

public class Member {

    private int memberId;
    private String name;

    public Member() {
        super();
    }

    public Member(int memberId) {
        this.memberId = memberId;
    }

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

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
}
