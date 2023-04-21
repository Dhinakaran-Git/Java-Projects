package com.bassure.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AlienDemo {

    public static void main(String[] args) {
        Alien a1 = new Alien();
        a1.setAName("Moosa");
        a1.setAid(12);
        a1.setColor("red");
        System.out.println(a1);
        
        Configuration con = new Configuration().configure("hibernate.xml").addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
     
        Transaction tx = session.beginTransaction();
        
        session.save(a1);
        
        tx.commit();
    }
}
