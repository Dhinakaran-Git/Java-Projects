package application.lms.dao;

import java.io.IOException;

public interface BookDAO {

    public void addBook() throws IOException;

    public void removeBook(int bookid);

    public void viewBooks() throws IOException;

    public void viewBook(String title);

    public void statistics();
    
}
