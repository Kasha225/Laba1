package org.example;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        IRepository<Clients> clientsList = new ClientRep();
        IRepository<Masters> mastersList = new MasterRep();
        //clientsList.addObj(new Clients (11,"Kasha", "Malasha"));
        //clientsList.update(new Clients(11, "Boba", "Biba"));
        //clientsList.delete(new Clients(11, "Kasha", "Malasha"));
        List<Masters> masters = mastersList.getAll();
        List<Clients> clients = clientsList.getAll();
        //clientsList.delete(clients.get(10));

        for(Clients cl: clients){
            FunctionsBD.ClientsOut(cl);
        }
        for(Masters ma: masters){
            FunctionsBD.MastersOut(ma);
        }

    }

}