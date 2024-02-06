package fp10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class adminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField adminid;

    @FXML
    private Button loginid;

    @FXML
    void adminaction(ActionEvent event) {

    }

    @FXML
    void loginaction(ActionEvent event) {
    	if(adminid.getText().equals("123456"))
    	{
    		try{
        		Parent root=FXMLLoader.load(getClass().getResource("/fp13/fp.fxml")); 
    			Scene scene = new Scene(root);
    			Stage stage=new Stage();
    			stage.setScene(scene);
    			stage.show();
     

    		}
        	catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	else
    		System.out.println("incorrect password");
    }

    @FXML
    void initialize() {
        assert adminid != null : "fx:id=\"adminid\" was not injected: check your FXML file 'admin.fxml'.";
        assert loginid != null : "fx:id=\"loginid\" was not injected: check your FXML file 'admin.fxml'.";

    }

}
