package library_management_system;

public class CollectBook {

    private int isbnId;
    private int memberId;
    private String collectDate;
    private boolean collectBookStatus;

    public int getBookid() {
        return isbnId;
    }

    public void setBookid(int Bookid) {
        this.isbnId = Bookid;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(String collectDate) {
        this.collectDate = collectDate;
    }

    public boolean isCollectBookStatus() {
        return collectBookStatus;
    }

    public void setCollectBookStatus(boolean collectBookStatus) {
        this.collectBookStatus = collectBookStatus;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-18s", isbnId, memberId, collectDate, collectBookStatus);
    }

    public CollectBook(int isbnId, int memberId, String collectDate, boolean collectBookStatus) {
        this.isbnId = isbnId;
        this.memberId = memberId;
        this.collectDate = collectDate;
        this.collectBookStatus = collectBookStatus;
    }
}
