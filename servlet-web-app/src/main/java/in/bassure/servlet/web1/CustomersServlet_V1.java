package in.bassure.servlet.web1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class CustomersServlet_V1 extends HttpServlet {

//    @Override
//    public void init(ServletConfig sc) throws ServletException {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException cnfe) {
//            cnfe.printStackTrace();
//        }
//    }
//    @Override
//    public ServletConfig getServletConfig() {
//        return null;
//    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = this.getServletContext();
        String JDBC_URL = ctx.getInitParameter("JDBC_URL");

        if (ctx.getAttribute("appDS") instanceof DataSource ds) {

            try ( PrintWriter out = response.getWriter();  var con = ds.getConnection();  var rs = con.createStatement().executeQuery("SELECT * FROM customers")) {
                out.println("<html><head><title>all customers</title></head><body>");

                if (rs.next()) {
                    out.println("<table border='1' cellpadding='4px' cellspacing='4px'><tr><th>ID</th><th>Name</th><th>Email</th><th>Mobile</th><th>Joined On</th></tr>");

                    do {
                        out.println(
                                "<tr>"
                                + "<td>" + rs.getInt(1) + "</td>"
                                + "<td>" + rs.getString(2) + "</td>"
                                + "<td>" + rs.getString(3) + "</td>"
                                + "<td>" + rs.getString(4) + "</td>"
                                + "<td>" + rs.getTimestamp(5) + "</td>"
                                + "</tr>"
                        );
                    } while (rs.next());

                    out.println("</table>");
                } else {
                    out.println("<h2>No Customers exists YET</h2>");
                }

                out.println("</body></html>");
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        } else {

        }
    }

    @Override
    public String getServletInfo() {
        return "Shows Customer entity functionalities";
    }

//    @Override
//    public void destroy() {
//    }
}
