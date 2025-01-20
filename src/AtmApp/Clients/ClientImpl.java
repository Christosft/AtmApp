package AtmApp.Clients;

import AtmApp.ClientModel.ClientModel;

public class ClientImpl implements IClient {

    @Override
    public void addClient(ClientModel client) {

    }

    @Override
    public void updateClient(int pinNumber, ClientModel client) {

    }

    @Override
    public boolean removeClient(int pinNumber) {
        return false;
    }

    @Override
    public ClientModel getClientById(int pinNumber) {
        return null;
    }

    @Override
    public ClientModel getClientByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public ClientModel[] getClientByCity(String city) {
        return new ClientModel[0];
    }

    @Override
    public ClientModel getClientByVat(int vatRegistrationNo) {
        return null;
    }
}
