package in.bassure.training.batch7.java.lms.dao;

import in.bassure.training.batch7.java.lms.dao.model.Member;
import java.io.IOException;

public interface MemberDAO {
    public void addMember(Member member)throws IOException;
}
