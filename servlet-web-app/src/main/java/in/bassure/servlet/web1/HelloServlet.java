package in.bassure.servlet.web1;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Enumeration;

public class HelloServlet extends GenericServlet {

//    @Override
//    public void init(ServletConfig sc) throws ServletException {
//        System.out.println("#".repeat(25) + " HelloServlet initialized");
//    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        System.out.println("#".repeat(25) + config);

        System.out.println("#".repeat(25) + " HelloServlet service executed");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("Hello, it's now : " + LocalDateTime.now());
        out.println("Name: " + config.getServletName());
        
        Enumeration<String> paramsEnum = config.getInitParameterNames();
        out.println("<table border='1'><tr><td>Name</td><td>Value</td></tr>");
        
        while(paramsEnum.hasMoreElements()){
            String paramName = paramsEnum.nextElement();
            String paramValue = config.getInitParameter(paramName);
            
            out.println("<tr><td>" + paramName + "</td>"
                    + "<td>" + paramValue + "</td></tr>");
        }
        
        out.println("</table>");

        out.flush();
    }

//    @Override
//    public String getServletInfo() {
//        return "HelloServlet for wishing the audience";
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("#".repeat(25) + " HelloServlet destroyed");
//    }

}
