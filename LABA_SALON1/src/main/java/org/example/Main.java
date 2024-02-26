package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:salon", "sa", "");
        if (conn==null){System.out.println("Нет соединения с БД!");
            System.exit(0);}
        Statement stmt = conn.createStatement();
        List<Clients> clients= new ArrayList<>();
        List<Masters> masters= new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT clients.id_client,\n" +
                "    clients.name AS client_name,\n" +
                "    clients.surname AS client_surname,\n" +
                "    masters.id_master,\n" +
                "    masters.name AS master_name,\n" +
                "    masters.surname AS master_surname FROM Clients join attention on clients.id_client = attention.id_client " +
                "join masters on attention.id_master = masters.id_master");

        while(rs.next()){
            Clients client = new Clients(rs.getInt("id_client"), rs.getString("name"), rs.getString("surname"));
            clients.add(client);
            Masters master = new Masters(rs.getInt("id_master"), rs.getString("name"), rs.getString("surname"));
            masters.add(master);
            System.out.println(rs.getRow() + ". "+ "Клиент - " + rs.getString("clients.name") + " " + rs.getString("clients.surname") + " \t\t"+
                    "Мастер - " + rs.getString("masters.name") + " " + rs.getString("masters.surname"));
        }

        for (Clients cl : clients){
            FunctionsBD.ClientsOut(cl);
        }

    }

}