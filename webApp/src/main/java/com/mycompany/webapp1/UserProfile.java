package com.mycompany.webapp1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userprofile", urlPatterns = {"/userprofile"})
public class UserProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        RequestDispatcher rd = request.getRequestDispatcher("viewMembers.jsp");
//        MemberDAOJpaImpl memberDAOJpaImpl = new MemberDAOJpaImpl();
//        request.setAttribute("member", memberDAOJpaImpl.viewMembers());
//        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
