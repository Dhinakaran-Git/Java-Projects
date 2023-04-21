package in.bassure.servlet.web1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(displayName = "Customer2", name = "CustomerV2Servlet", 
        urlPatterns = {"/c2"})
public class CustomersServlet_V2 extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        System.out.println("#".repeat(20) + " GET Called");
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        System.out.println("#".repeat(20) + " POST Called");
    }
}
