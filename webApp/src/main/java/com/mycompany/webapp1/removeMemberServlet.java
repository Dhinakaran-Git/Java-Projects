package com.mycompany.webapp1;

//package com.mycompany.webapp1;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "removeMemberServlet", urlPatterns = {"/removeMember"})
//public class removeMemberServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        MemberDAO mDao = new MemberDAO();
//        mDao.removeMember(Integer.parseInt(req.getParameter("bId")));
//        resp.sendRedirect("index.jsp");
//    }
//}
