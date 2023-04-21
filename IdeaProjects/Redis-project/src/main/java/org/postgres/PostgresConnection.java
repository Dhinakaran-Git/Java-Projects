package org.postgres;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class PostgresConnection {
    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
        configSetter();
    }

    public static BasicDataSource getConnection() {
        System.out.println("Connection Success");
        return dataSource;
    }

    public static void configSetter() {
        dataSource.setUrl("jdbc:postgresql://raeen.dev.bassure.in:5432/test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("bad-ran-pwd@#001");
        dataSource.setMaxIdle(20);
        dataSource.setMinIdle(10);
        dataSource.setDriverClassName("org.postgresql.Driver");
    }

    public void updateStatement(Long number, int id) {
        try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement("update student SET number = ? where id = ? RETURNING *")) {
            ps.setLong(1, number);
            ps.setInt(2, id);
            System.out.println("Successfully updated");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql Exception : " + e);
        }
    }

    public void insertStatement(int id, String name, int age, Long number) {
        try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement("insert into student (id, name, age, number) VALUES (? , ?, ?, ?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setLong(4, number);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql Exception : " + e);
        }
    }

    public void findAll() {
        try (Connection con = dataSource.getConnection(); Statement st = con.createStatement(); ResultSet resultSet = st.executeQuery("SELECT * FROM student")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Long number = resultSet.getLong("number");
                System.out.println("ID : " + id + " NAME : " + name + " AGE : " + age + " NUMBER : " + number);
            }
        } catch (SQLException e) {
            System.out.println("something went wrong " + e);
        }
    }

    public static void main(String[] args) {
        PostgresConnection postgresConnection = new PostgresConnection();
//        postgresConnection.updateStatement(56787654367L, 2);
        postgresConnection.findAll();
    }
}
