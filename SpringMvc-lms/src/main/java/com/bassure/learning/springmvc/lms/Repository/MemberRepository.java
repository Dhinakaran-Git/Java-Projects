package com.bassure.learning.springmvc.lms.Repository;

import com.bassure.learning.springmvc.lms.RowMapper.MemberRowMapper;
import com.bassure.learning.springmvc.lms.model.Member;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbctemp;

    public void MemberDAOImpl(DataSource ds) {
        this.jdbctemp = new JdbcTemplate(ds);
    }

    public List<Member> getMembers() {
        String sql = "select * from lms_members";
        List<Member> m = jdbctemp.query(sql, new MemberRowMapper());
        return m;
    }

//    public String addMember(Member member) {
//        String sql = "insert into lms_members value(0, ?, ?, ?, ?, 'Available')";
//        int affectedRowsusers = jdbctemp.update(sql, member.getName(), member.getAge(), member.getGender(), member.getPhone_Number());
//        if (affectedRowsusers == 1) {
//            return "Member Added Successfully";
//        } else {
//            return "something went wrong";
//        }
//    }
    
    public boolean addMember(Member members) {
        try {
            jdbctemp.update("INSERT INTO lms_members(name, age, gender, phone_number) VALUES(?, ?, ?, ?)",
                    members.getName(), members.getAge(), members.getGender(), members.getPhone_Number());
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Boolean deleteMember(int mId) {
        try {
            System.out.println(mId);
            jdbctemp.update("update lms_members set memberstatus = 'Removed' where member_id = ?", mId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateMember(Member mId) {
        try {
            jdbctemp.update("update lms_members set name = ?, age = ?, gender = ?, phone_number = ?, memberstatus = ? where member_id = ?", 
                    mId.getName(), mId.getAge(), mId.getGender(), mId.getPhone_Number(), mId.getMemberStatus(), mId.getMember_id());
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Member findMember(int mId) {
        return this.jdbctemp.queryForObject("select * from lms_members where member_id = ?",
                new MemberRowMapper(), mId);
    }

}
