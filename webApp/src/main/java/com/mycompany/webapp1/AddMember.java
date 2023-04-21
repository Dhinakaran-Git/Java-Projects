package com.mycompany.webapp1;

import com.mycompany.webapp1.dao.jpa.MemberDAOJpaImpl;
import com.mycompany.webapp1.jpaModel.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addmember", urlPatterns = {"/addmember"})
public class AddMember extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAOJpaImpl memberDAOJpaImpl = new MemberDAOJpaImpl();
        Member mem = new Member();
        mem.setMemberId(0);
        mem.setName(req.getParameter("name"));
        mem.setAge(Integer.parseInt(req.getParameter("age")));
        mem.setGender(req.getParameter("gender"));
        mem.setNumber(Long.parseLong(req.getParameter("num")));
        mem.setMemberStatus("Available");
        System.out.println(mem);
        memberDAOJpaImpl.addMember(mem);
        req.setAttribute("member", memberDAOJpaImpl.viewMembers());
        resp.sendRedirect("viewmembers");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
