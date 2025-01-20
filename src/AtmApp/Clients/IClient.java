package AtmApp.Clients;

import AtmApp.ClientModel.ClientModel;

public interface IClient {

    void addClient(ClientModel client);
    void updateClient(int pinNumber, ClientModel client);
    boolean removeClient(int pinNumber);
    ClientModel getClientById(int pinNumber);
    ClientModel getClientByPhoneNumber(String phoneNumber);
    ClientModel[] getClientByCity(String city);
    ClientModel getClientByVat(int vatRegistrationNo);
}
