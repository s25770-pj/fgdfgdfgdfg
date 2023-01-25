package pjwstk.Bank;

import org.springframework.stereotype.Component;

@Component
public class BankService {
    private ClientStorage clientStorage;
    public BankService(ClientStorage clientStorage){
      this.clientStorage = clientStorage;
    }
    public Client clientRegistration(String id, double balance)
    {
        Client client = new Client(id,balance);
        clientStorage.addClient(client);
        return client;
    }
    public Transfer deposit(String id, double value) {
        Client client = clientStorage.findClientById(id);
        if(client == null || value < 0){
            return new Transfer(value, "DECLINED");
        }
        client.setBalance(client.getBalance()+value);
        return new Transfer(client.getBalance(), "ACCEPTED");

    }
    public Transfer transfer(String id, double value) {
        Client client = clientStorage.findClientById(id);
        if(client == null || value < 0 || client.getBalance() - value < 0){
            return new Transfer(value, "DECLINED");
        }
        client.setBalance(client.getBalance()-value);
        return new Transfer(client.getBalance(), "ACCEPTED");

    }
}
