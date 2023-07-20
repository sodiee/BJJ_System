package Application.Controller;

import Application.Model.Belt;
import Application.Model.Class;
import Application.Model.Fighter;
import Application.Model.JiuClass;
import Application.Model.Wear;
import Storage.Database;

import java.sql.*;
import java.util.ArrayList;

public class DBController {
    private Connection connection;
    private Database database;

    //__________________________________________________________________________________________________________________________

    public DBController() {
        database = createDB();
        connection = database.createConnection();
    }

    //__________________________________________________________________________________________________________________________

    public Database createDB() {
        if (database == null) {
            database = new Database(connection);
        }
        return database;
    }

    //__________________________________________________________________________________________________________________________

    public JiuClass createJiuClass(int number, int rating, String gym, Wear gear, String topic, Belt belt, Fighter fighter, Class typeOfClass) {
        JiuClass jiuClass = new JiuClass(number, rating, gym, gear, topic, fighter, typeOfClass);
        database.addJiuClass(jiuClass);
        return jiuClass;
    }

    public ArrayList<JiuClass> getJiuClasses() {
        return database.getJiuClasses();
    }

    //__________________________________________________________________________________________________________________________

    public Fighter createFighter(Belt belt, int age, String name) {
        Fighter fighter = new Fighter(belt, age, name);
        database.addFighter(fighter);
        return fighter;
    }

    public ArrayList<Fighter> getFighters() {
        return database.getFighters();
    }

    public void promoteJiuBelt(Fighter fighter) {
        fighter.promoteToNewBelt();
    }

    //__________________________________________________________________________________________________________________________

    public Connection createConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Jiu_System;user=sa;password=reallyStrongPwd123");
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

    //__________________________________________________________________________________________________________________________

    public void initStorage() {
        Fighter fighter = createFighter(Belt.WHITE, 22, "Mathias Sode-Carlsen");
        createJiuClass(1, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(2, 7, "The Grappling Lab", Wear.NOGI, "Open guard", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(3, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(4, 8, "The Grappling Lab", Wear.NOGI, "Turtle", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(5, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(6, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(7, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(8, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(9, 7, "The Grappling Lab", Wear.NOGI, "Standing takedown", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(10, 8, "The Grappling Lab", Wear.GI, "Sprawling, single leg lock, double leg lock", Belt.WHITE, fighter, Class.BASICS);
        try {
            createConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
