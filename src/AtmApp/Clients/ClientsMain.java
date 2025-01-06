package AtmApp.Clients;

import AtmApp.ClientModel.ClientModel;

public class ClientsMain {

    public static void main(String[] args) {

        ClientModel clientModel = new ClientModel(1,"Chris", "Doe", "115424856", "6948576978", "Athens", 1500, 1000);

        System.out.println("The clients details are: " + clientModel.getId() + ", " + clientModel.getFirstname() + "," + clientModel.getLastname());
    }
}
