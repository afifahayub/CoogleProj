package ServiceReq;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServController {


















    public void manClients (ActionEvent event) throws IOException
    {
        Parent manageCustomer= FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));
        Scene manageCustomerScene=new Scene(manageCustomer);
        Stage Window= (Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(manageCustomerScene);
        Window.show();
    }

}
