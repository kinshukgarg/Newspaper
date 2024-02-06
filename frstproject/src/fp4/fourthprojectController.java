package fp4;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class fourthprojectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> customerid;

    @FXML
    private DatePicker datepicker1;

    @FXML
    private DatePicker datepicker2;

    @FXML
    private Button fetchid;

    @FXML
    private Button genbill;

    @FXML
    private Label labelid;

    @FXML
    private TextField miss;

    @FXML
    private TextField paperid;

    @FXML
    private TextField prices;

    @FXML
    private TextField totalbill;

    @FXML
    private TextField totalprices;
PreparedStatement pst;
Connection con;
    @FXML
    void fetchaction(ActionEvent event) {
    	 try {
       		
       		pst=con.prepareStatement("select * from customers where mobile=?");
       		String cm= customerid.getSelectionModel().getSelectedItem();
       		pst.setString(1,cm);
       		ResultSet table =pst.executeQuery();
       		
       		while(table.next())
       		{
       			String sp=table.getString("spapers");
       	    	paperid.setText(sp);
       	    	String sprc=table.getString("sprices");
       	    	 prices.setText(sprc);
       	   	java.sql.Date dobb=table.getDate("dos");
       	  datepicker1.setValue(dobb.toLocalDate());
       	  String text=prices.getText();
       	  String[]txt=text.split(",");
       	  float sum=0;
       	for(String s : txt)
       	{
       		sum+=Float.parseFloat(s.trim());
       		}
       	totalprices.setText(Float.toString(sum));
       		}
         }
       		catch(Exception exp )
           	
           	{
           		exp.printStackTrace();
           	}
    }

    @FXML
    void genaction(ActionEvent event) {
    	LocalDate frstdate=datepicker1.getValue();
    	LocalDate secddate=datepicker2.getValue();
    	long daysBtwn=ChronoUnit.DAYS.between(frstdate, secddate);
    	System.out.println(daysBtwn);
    
    	LocalDate ld=datepicker1.getValue();
    	java.sql.Date dt=java.sql.Date.valueOf(ld);
    	LocalDate A=datepicker2.getValue();
    	java.sql.Date B=java.sql.Date.valueOf(A);
        String tp= totalprices.getText();
    	float sum=Float.parseFloat(tp)*daysBtwn;
    	totalbill.setText(Float.toString(sum));
    	try {
    	pst=con.prepareStatement("insert into bills values(?,?,?,?,?)");
    	pst.setString(1,customerid.getSelectionModel().getSelectedItem());
    	pst.setDate(2,dt);
    	pst.setDate(3, B);
    	pst.setString(4,totalbill.getText());
    	pst.setString(5, null);
    	pst.executeUpdate();
    	System.out.println("Record saved....");
    	labelid.setText("record saved");
    	}
    	catch(SQLException exp)
    	{
    		exp.printStackTrace();
    	}
    	
    }

    @FXML
    void totalbillaction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert customerid != null : "fx:id=\"customerid\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert datepicker1 != null : "fx:id=\"datepicker1\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert datepicker2 != null : "fx:id=\"datepicker2\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert fetchid != null : "fx:id=\"fetchid\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert genbill != null : "fx:id=\"genbill\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert labelid != null : "fx:id=\"labelid\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert miss != null : "fx:id=\"miss\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert paperid != null : "fx:id=\"paperid\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert prices != null : "fx:id=\"prices\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert totalbill != null : "fx:id=\"totalbill\" was not injected: check your FXML file 'fourthproject.fxml'.";
        assert totalprices != null : "fx:id=\"totalprices\" was not injected: check your FXML file 'fourthproject.fxml'.";
        con=MySqlConnector.doConnect();
    	if(con==null)
    		System.out.println("connector problem");
    	else 
    		System.out.println("Connected");
    	try{
    		pst=con.prepareStatement("select distinct mobile from customers");
    		
    		ResultSet table =pst.executeQuery();
    
    	while(table.next()) {
    		String mb=table.getString("mobile");
    		customerid.getItems().add((mb));
    	 }
    	
    	}
    	catch(Exception exp)
    	{
    		System.out.println(exp);
        }

    }

}
