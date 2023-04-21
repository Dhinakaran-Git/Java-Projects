package in.bassure.servlet.web1;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("#".repeat(30) + " Application Started");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

}
