package fp13;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class fpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void docollector(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/fp5/fifthproject.fxml")); 
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

    @FXML
    void docustomer(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/fp3/thrdproject.fxml")); 
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

    @FXML
    void dodisplay(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/fp6/sixproject.fxml")); 
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

    @FXML
    void dogen(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/fp4/fourthproject.fxml")); 
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

    @FXML
    void dogoogler(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/fp7/seventhproject.fxml")); 
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

    @FXML
    void dohawker(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/fp2/scndproject.fxml")); 
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

    @FXML
    void dopapermaster(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/fp1/frstproject.fxml")); 
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
    @FXML
    void doproject(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/fp8/aboutus.fxml")); 
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
    @FXML
    void dostatus(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/fp9/billboard.fxml")); 
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

    @FXML
   
    	  Connection con;
    	    PreparedStatement pst;
    	  
    	    @FXML
    	    void initialize() {
    	    	con=MySqlConnector.doConnect();
    	    	if(con==null)
    	    		System.out.println("connector problem");
    	    	else 
    	    		System.out.println("Connected");
    }

}

