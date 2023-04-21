package application.lms.dao;

import java.io.IOException;

public interface MemberInfoDAO {

    public void viewMembers();
    
    public void viewMember(int id) throws IOException;
            
    public void addMember() throws IOException;

    public void removeMember(int id) throws IOException;

    public void memberOption() throws IOException;
}
