package Storage;

import Application.Model.Fighter;
import Application.Model.JiuClass;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;

    private ArrayList<Fighter> fighters = new ArrayList<>();

    private ArrayList<JiuClass> jiuClasses = new ArrayList<>();

    public Database(Connection connection) {
        this.connection = connection;
    }

    //__________________________________________________________________________________________________________________________

    public void addJiuClass(JiuClass jiuClass) {
        jiuClasses.add(jiuClass);
    }

    public ArrayList<JiuClass> getJiuClasses() {
        return jiuClasses;
    }

    //__________________________________________________________________________________________________________________________

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public ArrayList<Fighter> getFighters() {
        return fighters;
    }

    //__________________________________________________________________________________________________________________________

    public Connection createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Jiu_System;user=sa;password=reallyStrongPwd123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public PreparedStatement createPreparedStatement(String sql) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(sql);
        return stmt;
    }

    public void executeStatementFighter(PreparedStatement stmt, String belt, String name, int age) throws SQLException {
        stmt.setString(1, belt);
        stmt.setString(2, name);
        stmt.setInt(3, age);
        stmt.executeUpdate();
    }

    public void executeStatementJiuClass(PreparedStatement stmt, int number, int totalNumber, int rating, String gym, String gear, String topic, String fighter) throws SQLException {
        stmt.setInt(1, number);
        stmt.setInt(2, totalNumber);
        stmt.setInt(3, rating);
        stmt.setString(4, gym);
        stmt.setString(5, gear);
        stmt.setString(6, topic);
        stmt.setString(7, fighter);
        stmt.executeUpdate();
    }

    public void close(Statement stmt, Connection connection) throws SQLException {
        stmt.close();
        connection.close();
    }
}
