package org.example;

import java.sql.SQLException;
import java.util.List;

public interface ClRepository {
    List<Clients> getAllClients() throws SQLException;
    Clients getIdClient(int id);
    void addClient(Clients client);
    void updateClient(Clients client);
    void deleteClient(int id);
}
