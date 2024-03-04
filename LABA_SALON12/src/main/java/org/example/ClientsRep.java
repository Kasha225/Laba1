package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsRep implements ClRepository{

    @Override
    public List<Clients> getAllClients() throws SQLException {
        List<Clients> listClients = new ArrayList<>();
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:salon", "sa", "");
        if (conn == null) {
            System.out.println("Нет соединения с БД!");
            System.exit(0);
        }
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("");
        while (rs.next()) {
            int id = rs.getInt("id_client");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            Clients client = new Clients(id, name, surname);
            listClients.add(client);
        }
        stmt.close();
        return listClients;
    }

    @Override
    public Clients getIdClient(int id) {
        return null;
    }

    @Override
    public void addClient(Clients client) {

    }

    @Override
    public void updateClient(Clients client) {

    }

    @Override
    public void deleteClient(int id) {

    }
}
