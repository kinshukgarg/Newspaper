package fp5;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class fifthprojectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField amountid;

    @FXML
    private Button billid;

    @FXML
    private TextField customerid;

    @FXML
    private DatePicker datepicker1;

    @FXML
    private DatePicker datepicker2;

    @FXML
    private Button doneid;

    @FXML
    private ImageView imgid;

    @FXML
    private Label labelid;
    Connection con;
    PreparedStatement pst;

    @FXML
    void billaction(ActionEvent event) {
    	try
    	{
    	pst=con.prepareStatement("select * from bills where mobile=?");
    	pst.setString(1,customerid.getText());
    	ResultSet table =pst.executeQuery();
    	while(table.next())
  		{
  			
  			
  			java.sql.Date df=table.getDate("datefrom");
  			
  			java.sql.Date dt=table.getDate("dateto");
  			String b=table.getString("bill");
  			int a=table.getInt("billstatus");
  			if(a>0)
  			{
  				labelid.setText("bill paid sucessfully");
  			}
  			else 
  			{
  				labelid.setText("bill not paid ");
  			}
  			amountid.setText(b);
  			datepicker2.setValue(dt.toLocalDate());
  			datepicker1.setValue(df.toLocalDate());
  			System.out.println(b+","+dt+","+df+",");
  		  
  		  
    	}
    	}
    	catch(SQLException exp)
    	{
    		exp.printStackTrace();
    	}
    }

    @FXML
    void doneaction(ActionEvent event) {
    	int  res=1;
    	try {
    	pst=con.prepareStatement("update bills  set billstatus=? where mobile=? ");
    	
    	pst.setInt(1,res);
    	pst.setString(2,customerid.getText());
    	pst.executeUpdate();
    	System.out.println("Record saved....");
    	labelid.setText("Bill paid sucessfully");
    	}
    	catch(Exception exp)
    	{
    		exp.printStackTrace();
    	}
    	
    }

    @FXML
    void initialize() {
        assert amountid != null : "fx:id=\"amountid\" was not injected: check your FXML file 'fifthproject.fxml'.";
        assert billid != null : "fx:id=\"billid\" was not injected: check your FXML file 'fifthproject.fxml'.";
        assert customerid != null : "fx:id=\"customerid\" was not injected: check your FXML file 'fifthproject.fxml'.";
        assert datepicker1 != null : "fx:id=\"datepicker1\" was not injected: check your FXML file 'fifthproject.fxml'.";
        assert datepicker2 != null : "fx:id=\"datepicker2\" was not injected: check your FXML file 'fifthproject.fxml'.";
        assert doneid != null : "fx:id=\"doneid\" was not injected: check your FXML file 'fifthproject.fxml'.";
        assert imgid != null : "fx:id=\"imgid\" was not injected: check your FXML file 'fifthproject.fxml'.";
        assert labelid != null : "fx:id=\"labelid\" was not injected: check your FXML file 'fifthproject.fxml'.";
    	con=MySqlConnector.doConnect();
    	if(con==null)
    		System.out.println("connector problem");
    	else 
    		System.out.println("Connected");
    }

}
