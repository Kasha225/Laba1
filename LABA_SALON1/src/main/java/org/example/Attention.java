package org.example;

public class Attention {
    private int id;
    private Clients id_client;
    private Masters id_master;

    public Attention(int id, Clients id_client, Masters id_master) {
        this.id = id;
        this.id_client = id_client;
        this.id_master = id_master;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clients getId_client() {
        return id_client;
    }

    public void setId_client(Clients id_client) {
        this.id_client = id_client;
    }

    public Masters getId_master() {
        return id_master;
    }

    public void setId_master(Masters id_master) {
        this.id_master = id_master;
    }
}
