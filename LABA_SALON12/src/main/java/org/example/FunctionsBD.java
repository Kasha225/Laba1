package org.example;

public class FunctionsBD {
    public static void ClientsOut(Clients clients){
        System.out.println(clients.getId_client() + " " + clients.getName() + " " + clients.getSurname());
    }
    public static void MastersOut(Masters masters){
        System.out.println(masters.getId_master() + " " + masters.getName() + " " + masters.getSurname());
    }
}
