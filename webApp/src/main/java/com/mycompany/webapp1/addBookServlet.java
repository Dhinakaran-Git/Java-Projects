package com.mycompany.webapp1;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "addBookServlet", urlPatterns = "/addBook")
//public class addBookServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BookDAO bDao = new BookDAO();
//        Book book = new Book();
//        book.setTitle(req.getParameter("bname"));
//        book.setIsbn(Integer.parseInt(req.getParameter("ISBN")));
//        book.setPrice(Integer.parseInt(req.getParameter("Price")));
//        int id = Integer.parseInt(req.getParameter("bCopies"));
//        bDao.addBook(book,id);
//        
//        resp.sendRedirect("index.jsp");
//
//    }
//
//}
