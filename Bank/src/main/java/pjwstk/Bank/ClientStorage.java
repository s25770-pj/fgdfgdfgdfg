package pjwstk.Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientStorage {

    List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getAllClients(){
        return clients;
    }

    public Client findClientById(String id) {
        for(Client client:clients)
        {
            if(client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }

}
