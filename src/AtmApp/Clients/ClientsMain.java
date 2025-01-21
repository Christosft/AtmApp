package AtmApp.Clients;

import AtmApp.ClientModel.ClientModel;
import java.util.ArrayList;
import java.util.List;

public class ClientsMain {



    private final List<ClientModel> clients = new ArrayList<>();

    public ClientsMain() {

        clients.add(new ClientModel(1651,"Chris", "Doe", 115424856, "6948576978", "Athens", 3000, 1500));
        clients.add(new ClientModel(1980, "Kostas", "Christou", 111111111, "6982473645", "Athens", 15000.00, 20000.00));
    }

    public ClientModel getClientByPinNumber(int pinNumber) {
        for (ClientModel client : clients) {
            if (client.getPinNumber() == (pinNumber)) {
                return client;
            }
        }
        return null;
    }

    public List<ClientModel> getAllClients() {
        return clients;

    }
    }