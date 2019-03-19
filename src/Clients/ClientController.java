package Clients;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientController implements Initializable{


    @FXML
    private TextField id;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;
    @FXML
    private TableView<ClientDB> clienttable;

    @FXML
    private TableColumn<ClientDB, String> idcol;
    @FXML
    private TableColumn<ClientDB, String> fnamecol;
    @FXML
    private TableColumn<ClientDB, String> lnamecol;
    @FXML
    private TableColumn<ClientDB, String> emailcol;

    private dbConnection database;
    private ObservableList<ClientDB> records,people;
    private String SQLi="SELECT * FROM Customer";
    public void initialize(URL location, ResourceBundle resources)
    {
        this.database=new dbConnection();
    }
    @FXML
    private void loadClientData(ActionEvent event) throws SQLException{
        try{
            Connection conn=dbConnection.conn();
            this.records= FXCollections.observableArrayList();
            ResultSet resultset= conn.createStatement().executeQuery(SQLi);
            while(resultset.next()){
                this.records.add(new ClientDB(resultset.getString(1),resultset.getString(2),resultset.getString(3), resultset.getString(4)));
            }
        }
        catch (SQLException e){
            System.err.println("Error"+e);
        }
        this.idcol.setCellValueFactory(new PropertyValueFactory<ClientDB , String>("ID"));
        this.fnamecol.setCellValueFactory(new PropertyValueFactory<ClientDB , String>("firstName"));
        this.lnamecol.setCellValueFactory(new PropertyValueFactory<ClientDB , String>("lastName"));
        this.emailcol.setCellValueFactory(new PropertyValueFactory<ClientDB , String>("email"));
        this.clienttable.setItems(null);
        this.clienttable.setItems(this.records);
    }


    @FXML
    private void addClients (ActionEvent event){
        String insert="INSERT INTO Customer(id,fname,lname,email) VALUES (?,?,?,?)";
        try{
            Connection connect=dbConnection.conn();
            PreparedStatement statement=connect.prepareStatement(insert);
            statement.setString(1 , this.id.getText());
            statement.setString(2 , this.firstname.getText());
            statement.setString(3 , this.lastname.getText());
            statement.setString(4 , this.email.getText());
            statement.execute();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void delete (ActionEvent event){
        records=clienttable.getItems();
        people=clienttable.getSelectionModel().getSelectedItems();
        for (ClientDB clientdb: people){
            records.remove(clientdb);
        }

    }
   //DO NOT CHANGE
   public void manClients (ActionEvent event) throws IOException
    {
        Parent manageCustomer= FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));
        Scene manageCustomerScene=new Scene(manageCustomer);
        Stage Window= (Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(manageCustomerScene);
        Window.show();
    }

}
