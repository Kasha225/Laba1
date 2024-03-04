package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRep implements IRepository<Clients>{
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
    public void addObj(Clients client) throws SQLException{
        String query = "INSERT INTO Clients (id_client, name, surname) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setInt(1, client.getId_client());
            statement.setString(2, client.getName());
            statement.setString(3, client.getSurname());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Clients client)throws SQLException {
        String query = "DELETE FROM Clients WHERE id_client = ?";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setInt(1, client.getId_client());
            statement.executeUpdate();
        }

    }

    @Override
    public void update(Clients client)throws SQLException {
        String query = "UPDATE Clients SET name = ?, surname = ? WHERE id_client = ?";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setInt(3, client.getId_client());
            statement.executeUpdate();
        }
    }

    @Override
    public List<Clients> getAll() throws SQLException{
        Statement stmt = createStmt(connect());
        ResultSet rs = stmt.executeQuery("SELECT id_client, name, surname FROM clients");
        List<Clients> clients = new ArrayList<>();
        while(rs.next()){
            Clients client = new Clients(rs.getInt("id_client"), rs.getString("name"), rs.getString("surname"));
            clients.add(client);
        }
        stmt.close();
        return clients;
    }
}
