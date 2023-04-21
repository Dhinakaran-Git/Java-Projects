package com.mycompany.spring.app;

import com.mycompany.spring.app.practices.Car;
import com.mycompany.spring.app.practices.Department;
import com.mycompany.spring.app.practices.Employee;
import com.mycompany.spring.app.practices.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringApp.class);
    
    public static void main(String[] args) {
        
    }
    
    public static void main3(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Department d = ctx.getBean("d1", Department.class);
        System.out.println(d);

        Employee e = ctx.getBean("b2", Employee.class);
        System.out.println(e);

        Employee e1 = ctx.getBean("NewEmployee", Employee.class);
        System.out.println(e1);
    }

    public static void main2(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Car c = ctx.getBean("carA", Car.class);
        LOGGER.info("{}", c);
    }

    public static void main1(String[] args) {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
//        older approch
//        Employee a = (Employee) ctx.getBean("b1");
//        morden approch
//        Employee a = ctx.getBean("b1", Employee.class);
        ApplicationContext appContext = SpringApplication.run(SpringApp.class);

        PersonDAO personDAO = appContext.getBean(PersonDAO.class);
        PersonDAO personDAO1 = appContext.getBean(PersonDAO.class);

        LOGGER.info("{}", personDAO);
        LOGGER.info("{}", personDAO.getJdbcConnection());

        LOGGER.info("{}", personDAO1);
        LOGGER.info("{}", personDAO1.getJdbcConnection());
    }
}
