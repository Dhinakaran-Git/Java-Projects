package com.bassure.learning.springmvc.lms.RowMapper;

import com.bassure.learning.springmvc.lms.model.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Member(
                rs.getInt(1),
                 rs.getString(2),
                 rs.getInt(3),
                 rs.getString(4),
                rs.getLong(5),
                 rs.getString(6)
        );
    }
}
