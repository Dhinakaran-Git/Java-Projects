package application.lms.model;

public class IssueBook {

    private int isbnId;
    private String title;
    private int memberId;
    private String issuedDate;
    private boolean issueBookStatus;

    public boolean isIssueBookStatus() {
        return issueBookStatus;
    }

    public int getIsbnId() {
        return isbnId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIssueBookStatus(boolean issueBookStatus) {
        this.issueBookStatus = issueBookStatus;
    }

    public void setBookid(int Bookid) {
        this.isbnId = Bookid;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s%-18s", isbnId, title, memberId, issuedDate, issueBookStatus);
    }

    public IssueBook(int isbnId, String title, int memberId, String issuedDate, boolean issueBookStatus) {
        this.isbnId = isbnId;
        this.title = title;
        this.memberId = memberId;
        this.issuedDate = issuedDate;
        this.issueBookStatus = issueBookStatus;
    }
}