package in.bassure.training.batch7.java.lms;

import in.bassure.training.batch7.java.lms.dao.MemberDAO;
import in.bassure.training.batch7.java.lms.dao.file.MemberDAOFileImpl;
import in.bassure.training.batch7.java.lms.dao.model.Member;
import in.bassure.training.batch7.java.lms.dao.mysql.MemberDAOMySQLImpl;
import java.io.IOException;

public class LMSApplication {
    private enum DBType{
        FILE, MYSQL, MONGO
    }
    private static DBType dbType = DBType.FILE;
    
    private static MemberDAO memberDAO;
    
    public static void main(String[] args) throws IOException{
        if(dbType == DBType.FILE){
            memberDAO = new MemberDAOFileImpl();
        }else{
            memberDAO = new MemberDAOMySQLImpl();
        }
        
        Member current = new Member(123, "James");
        memberDAO.addMember(current);
    }
}









