package in.bassure.training.batch7.java.lms.dao.file;

import in.bassure.training.batch7.java.lms.dao.MemberDAO;
import in.bassure.training.batch7.java.lms.dao.model.Member;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MemberDAOFileImpl implements MemberDAO {
    private FileInputStream in;
    private FileOutputStream out;
    private String memberDataFileName = "member-data.txt";

    @Override
    public void addMember(Member member) throws IOException{
        //in = new FileInputStream(memberDataFileName);
        
    }

}








