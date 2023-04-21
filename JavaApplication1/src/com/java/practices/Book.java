
public class Book {

    final String BOOK_TITLE;
    private static String category;
    final String AUTHOR_NAME;
    String BOOK_GENRE;
    String BOOK_COVER_TYPE;
    final int EDITION;
    final String PUBLISHER;
    int NUMBER_OF_PAGES;
    double BOOK_HEIGHT;
    double BOOK_WIDTH;
    double BOOK_LENGTH;

    public Book() {
        BOOK_TITLE = "DEEP WORK";
        AUTHOR_NAME = "CAL NEWPORT";
        BOOK_GENRE = "SELF HELP";
        BOOK_COVER_TYPE = "PAPERBACK";
        EDITION = 2002;
        PUBLISHER = "Grand central publishing";
        NUMBER_OF_PAGES = 289;
        BOOK_HEIGHT = 233;
        BOOK_WIDTH = 23;
        BOOK_LENGTH = 153;
    }

    public Book(String BOOK_TITLE, String PUBLISHER, String AUTHOR_NAME, int EDITION) {
        this.BOOK_TITLE = BOOK_TITLE;
        this.PUBLISHER = PUBLISHER;
        this.AUTHOR_NAME = AUTHOR_NAME;
        this.EDITION = EDITION;
    }

    public Book(String BOOK_TITLE, String AUTHOR_NAME, String BOOK_TYPE, String BOOK_COVER_TYPE, int EDITION, String PUBLISHER, int NUMBER_OF_PAGES, double BOOK_HEIGHT, double BOOK_WIDTH, double BOOK_THICKNESS) {
        this.BOOK_TITLE = BOOK_TITLE;
        this.AUTHOR_NAME = AUTHOR_NAME;
        this.BOOK_GENRE = BOOK_TYPE;
        this.BOOK_COVER_TYPE = BOOK_COVER_TYPE;
        this.EDITION = EDITION;
        this.PUBLISHER = PUBLISHER;
        this.NUMBER_OF_PAGES = NUMBER_OF_PAGES;
        this.BOOK_HEIGHT = BOOK_HEIGHT;
        this.BOOK_WIDTH = BOOK_WIDTH;
        this.BOOK_LENGTH = BOOK_THICKNESS;
    }

    public String getBOOK_TITLE() {
        return BOOK_TITLE;
    }

    public static String getCategory() {
        return category;
    }

    public String getAUTHOR_NAME() {
        return AUTHOR_NAME;
    }

    public String getBOOK_GENRE() {
        return BOOK_GENRE;
    }

    public String getBOOK_COVER_TYPE() {
        return BOOK_COVER_TYPE;
    }

    public int getEDITION() {
        return EDITION;
    }

    public String getPUBLISHER() {
        return PUBLISHER;
    }

    public int getNUMBER_OF_PAGES() {
        return NUMBER_OF_PAGES;
    }

    public double getBOOK_HEIGHT() {
        return BOOK_HEIGHT;
    }

    public double getBOOK_WIDTH() {
        return BOOK_WIDTH;
    }

    public double getBOOK_LENGTH() {
        return BOOK_LENGTH;
    }
}
