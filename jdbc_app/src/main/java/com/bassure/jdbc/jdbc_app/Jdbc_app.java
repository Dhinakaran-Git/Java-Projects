package com.bassure.jdbc.jdbc_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_app {

    public static void addMember() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://bassure.in:3306/dhinakaran_db", "dhinakaran", "bassure@33");
            PreparedStatement pst = c.prepareStatement("INSERT INTO danny(id, name, age) VALUES (0, ?, ?)");
            pst.setString(1, "Dhina");
            pst.setInt(2, 23);
            pst.executeUpdate();
            System.out.println("Added Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

//                addMember();

        Connection con = DriverManager.getConnection("jdbc:mysql://bassure.in:3306/dhinakaran_db", "dhinakaran", "bassure@33");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM danny");

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);

            System.out.println(id + " # " + name + " # " + age + " # ");
        }
        con.close();
        
    }
}
