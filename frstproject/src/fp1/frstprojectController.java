package fp1;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import fp1.MySqlConnector;

public class frstprojectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button availid;

    @FXML
    private Button editid;

    @FXML
    private ImageView imgid;

    @FXML
    private ComboBox<String> paperid;

    @FXML
    private TextField priceid;

    @FXML
    private Button searchid;

    @FXML
    private Button withdrawid;
    Connection con;
    PreparedStatement pst;
    @FXML
    void availaction(ActionEvent event) {
String papr=paperid.getSelectionModel().getSelectedItem();
float prc=Float.parseFloat(priceid.getText()); 
try {
	pst=con.prepareStatement("insert into papers values(?,?)");
	pst.setString(1,papr);
	pst.setFloat(2,prc);
	pst.executeUpdate();
	System.out.print(papr+","+prc);
}
catch(SQLException e)
{
	e.printStackTrace();
}

    }

    @FXML
    void editaction(ActionEvent event) {
String papr=paperid.getSelectionModel().getSelectedItem();
float prc=Float.parseFloat(priceid.getText());
try {
	pst=con.prepareStatement("update into papers set price=? where paper=?");
	pst.setString(1,papr);
	pst.setFloat(2,prc);
	pst.executeUpdate();
	
	System.out.print("record updated sucessfully");
}
catch(SQLException ex)
{
	System.out.print("exception occur");
}
    }

    @FXML
    void paperaction(ActionEvent event) {
String Item=paperid.getSelectionModel().getSelectedItem();
paperid.setAccessibleText(Item);
    }

    @FXML
    void priceaction(ActionEvent event) {

    }

    @FXML
    void searchaction(ActionEvent event) {
String combo=paperid.getSelectionModel().getSelectedItem();
if(combo.equals("Dainik Jagran"))
	priceid.setText("5");
if(combo.equals("The Tribune"))
	priceid.setText("6");
if(combo.equals("Punjabi Tribune"))
	priceid.setText("4");
if(combo.equals("Punjab kesari"))
	priceid.setText("3.5");
if(combo.equals("Jag Bani"))
	priceid.setText("7");
if(combo.equals("Ajit"))
	priceid.setText("2");
if(combo.equals("Azad Soch"))
	priceid.setText("4.5");



    }

    @FXML
    void withdrawaction(ActionEvent event) {
String papr=paperid.getSelectionModel().getSelectedItem();
try {
	pst=con.prepareStatement("delete from papers where paper=?");
	pst.setString(1,papr);
	pst.executeUpdate();
	System.out.print("record deleted");
}
catch(Exception ex)
{
	ex.printStackTrace();
}
    }

    @FXML
    void initialize() {
        assert availid != null : "fx:id=\"availid\" was not injected: check your FXML file 'frstproject.fxml'.";
        assert editid != null : "fx:id=\"editid\" was not injected: check your FXML file 'frstproject.fxml'.";
        assert imgid != null : "fx:id=\"imgid\" was not injected: check your FXML file 'frstproject.fxml'.";
        assert paperid != null : "fx:id=\"paperid\" was not injected: check your FXML file 'frstproject.fxml'.";
        assert priceid != null : "fx:id=\"priceid\" was not injected: check your FXML file 'frstproject.fxml'.";
        assert searchid != null : "fx:id=\"searchid\" was not injected: check your FXML file 'frstproject.fxml'.";
        assert withdrawid != null : "fx:id=\"withdrawid\" was not injected: check your FXML file 'frstproject.fxml'.";
        ArrayList<String>items=new ArrayList<String>(Arrays.asList("Dainik Jagran","The Tribune","Punjabi Tribune",
"Punjab kesari","Jag Bani","Ajit","Azad Soch"));
        paperid.getItems().addAll(items);
        con=MySqlConnector.doConnect();
    	if(con==null)
    			System.out.println("Connection Problem");
    	else
    		System.out.println("Connected");
    }

}
