package sample;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller implements Initializable {
    @FXML private Button manClients;
    @FXML private Button manContractors;
    @FXML private Button manServices;


    public void manClients(ActionEvent event) throws IOException
    {
        Parent manageCustomer= FXMLLoader.load(this.getClass().getResource("../Clients/clients.fxml"));
        Scene manageCustomerScene = new Scene(manageCustomer);
        Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(manageCustomerScene);
        Window.show();
    }
    public void manContractors(ActionEvent event) throws IOException {
        Parent manageCustomer= FXMLLoader.load(this.getClass().getResource("../Contractors/manContractors.fxml"));
        Scene manageCustomerScene = new Scene(manageCustomer);
        Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(manageCustomerScene);
        Window.show();
    }
    public void manServices(ActionEvent event) throws IOException
    {
        Parent manageCustomer = FXMLLoader.load(this.getClass().getResource("../ServiceReq/manServices.fxml"));
        Scene manageCustomerScene = new Scene(manageCustomer);
        Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(manageCustomerScene);
        Window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
