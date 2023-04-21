package in.bassure.servlet.web1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.commons.dbcp2.BasicDataSource;

@WebListener
public class ApplicationDataSourceListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        
        try {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl(ctx.getInitParameter("JDBC_URL"));
            ds.setUsername("batch7_user");
            ds.setPassword("batch7-pwd");
            ds.setMaxIdle(2);
            ds.setMinIdle(1);
            ds.setMaxTotal(10);
            
            ctx.setAttribute("appDS", ds);
        } finally {
            
        }
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        ctx.removeAttribute("appDS");
    }
    
}
