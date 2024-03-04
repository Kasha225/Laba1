package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasterRep implements IRepository<Masters>{

    public Connection connect() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:salon", "sa", "");
        if (conn==null){System.out.println("Нет соединения с БД!");
            System.exit(0);
        }
        return conn;
    }
    public Statement createStmt(Connection conn)throws SQLException{
        return conn.createStatement();
    }

    @Override
    public void addObj(Masters master) throws SQLException {
        String query = "INSERT INTO Masters (id_master, name, surname) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setInt(1, master.getId_master());
            statement.setString(2, master.getName());
            statement.setString(3, master.getSurname());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Masters master) throws SQLException {
        String query = "DELETE FROM Masters WHERE id_master = ?";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setInt(1, master.getId_master());
            statement.executeUpdate();
        }

    }

    @Override
    public void update(Masters master) throws SQLException {
        String query = "UPDATE Clients SET name = ?, surname = ? WHERE id_master = ?";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setString(1, master.getName());
            statement.setString(2, master.getSurname());
            statement.setInt(3, master.getId_master());
            statement.executeUpdate();
        }

    }

    @Override
    public List<Masters> getAll() throws SQLException {
        Statement stmt = createStmt(connect());
        ResultSet rs = stmt.executeQuery("SELECT id_master, name, surname FROM Masters");
        List<Masters> masters = new ArrayList<>();
        while(rs.next()){
            Masters master = new Masters(rs.getInt("id_master"), rs.getString("name"), rs.getString("surname"));
            masters.add(master);
        }
        stmt.close();
        return masters;
    }

}

