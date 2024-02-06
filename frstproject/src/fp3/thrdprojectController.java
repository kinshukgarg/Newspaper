package fp3;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import fp3.MySqlConnector;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class thrdprojectController {
	ArrayList<String>items=new ArrayList<String>(Arrays.asList("Dainik Jagran","The Tribune","Punjabi Tribune",
			"Punjab kesari","Jag Bani","Ajit","Azad Soch"));
	ArrayList<Float>items2=new ArrayList<Float>(Arrays.asList(4.5f,5.0f,3.5f,5.0f,4.0f,4.5f,5.0f));

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addressid;

    @FXML
    private ComboBox<String> areasid;

    @FXML
    private DatePicker dateid;

    @FXML
    private TextField emailid;

    @FXML
    private Button fetchid;

    @FXML
    private TextField hawkerid;

    @FXML
    private ImageView img1;

    @FXML
    private Label lableid;

    @FXML
    private ListView<String> list1;

    @FXML
    private ListView<Float> list2;

    @FXML
    private ListView<String> list3;

    @FXML
    private ListView<Float> list4;

    @FXML
    private TextField mobileid;

    @FXML
    private TextField nameid;

    @FXML
    private Button subscribeid;

    @FXML
    private Button unsubscribeid;

    @FXML
    private Button updateid;
    
    Connection con;
    PreparedStatement pst;

    @FXML
    void areasaction(ActionEvent event) {
    	 areasid.getSelectionModel().getSelectedItem();
   	  String combo=areasid.getSelectionModel().getSelectedItem();
   	if(combo.equals("ajit road"))
   	{
   		hawkerid.setText("manish");
   	}
      if(combo.equals("model town"))
   	{
   	hawkerid.setText("manish ");
   	}
   	 if(combo.equals("adarsh nagar"))
   	{
   		hawkerid.setText("shankar");
   	}
       if(combo.equals("namdev road"))
   		 
   	{
   		hawkerid.setText("sahil");
   	}
       if(combo.equals("ganesha basti"))
   	{
   		hawkerid.setText("sahil");
   	}
       if(combo.equals("kheta bast"))
   	{
   		hawkerid.setText("manoj");
   	}
   	 if(combo.equals("pearl city"))
   	{
   		hawkerid.setText("manoj");
   	}
   	 if(combo.equals("Mohammad road"))
   	{
   		hawkerid.setText("shrma ji");
   	}
    }

    @FXML
    void doselectedclick(MouseEvent event) {
    	 if(event.getClickCount()==1) {
    		 list2.getSelectionModel().select(list1.getSelectionModel().getSelectedIndex());
   		  
   		  
   	  }
   	  else if(event.getClickCount()==2){
   		list3.getItems().add( list1.getSelectionModel().getSelectedItem());
   		list4.getItems().add( list2.getSelectionModel().getSelectedItem());
   		
   	  }
    }

    @FXML
    void fetchaction(ActionEvent event) {
    	System.out.print("hyyy");
    	try {
      		
    		System.out.println(mobileid.getText());
      		pst=con.prepareStatement("select * from customers where mobile=?");
      	    
      		pst.setString(1,mobileid.getText());
      		
      		ResultSet table =pst.executeQuery();
      		
      		while(table.next())
      		{
      			System.out.print("hyyy");
      			String  mb=table.getString("mobile");
      			ObservableList<String>items=list3.getItems();
      		    String a=table.getString("cname");
      		    
      			items.add(table.getString("spapers"));
      	    	String ar=table.getString("area");
      	    	String hawk=table.getString("hawker");
      	    	String mail=table.getString("email");
      	    	String ad= table.getString("address");
      	    	java.sql.Date dobb=table.getDate("dos");
      	    	mobileid.setText(mb);
      	    	nameid.setText(a);
      	    	hawkerid.setText(hawk);
      	    	list3.setItems(items);
      	    	areasid.setPromptText(ar);
      	    	emailid.setText(mail);
      	    	addressid.setText(ad);
      	    	dateid.setValue(dobb.toLocalDate());
      	    	
      		}
        }
      		catch(Exception exp )
          	
          	{
          		exp.printStackTrace();
          	}
    }

    @FXML
    void hawkeraction(ActionEvent event) {

    }

    @FXML
    void mobileaction(ActionEvent event) {

    }

    @FXML
    void nameaction(ActionEvent event) {

    }

    @FXML
    void subscribeaction(ActionEvent event)throws SQLException {
    	
    	String mb=String.valueOf(mobileid.getText());
    	ObservableList<String>items=list3.getItems();
    	
     	LocalDate ld=dateid.getValue();
     	String ca= areasid.getSelectionModel().getSelectedItem();
     	java.sql.Date dt=java.sql.Date.valueOf(ld);
     	ObservableList<Float>price=list4.getItems();
     	try {
     		pst=con.prepareStatement("insert into customers values(?,?,?,?,?,?,?,?,?)");
     		pst.setString(1, mb);
     		pst.setString(2,nameid.getText());
     		String res=" ";
     		for(String item:items)
        	{
     			res+=item+",";
        	}
     	    pst.setString(3, res);
     		pst.setString(4,ca);
     		pst.setString(5,hawkerid.getText());
     		pst.setString(6, emailid.getText());
     		pst.setString(7, addressid.getText());
     		pst.setDate(8,dt);
     		
     		String pr="";
     		for(Float prc:price ) {
     			pr=pr+prc+",";
     			
     		}
     		pst.setString(9,String.valueOf(pr));
     		 
     		
     		pst.executeUpdate();
     		lableid.setText("records saved......");
     		System.out.println("records saved");
     		
     	}
     	catch(SQLException exp )
     	
     	{
     		exp.printStackTrace();
     	}
    }

    @FXML
    void unsubscribeaction(ActionEvent event) {
try {
    		
    		pst=con.prepareStatement("delete from customers where cname=?");
    		pst.setString(1,nameid.getText());
    		int count=pst.executeUpdate();
    		if(count!=0)
    		{	lableid.setText("records deleted.........");
    		System.out.println("records deleted");
    		}
    		else
    		System.out.println("invalid name");
    		
    	}
    	catch(Exception exp )
    	
    	{
    		System.out.println(exp.toString());
    	}
    }

    @FXML
    void updateaction(ActionEvent event) {
    	String mb=String.valueOf(mobileid.getText());
        ObservableList<String>items=list3.getItems();
    	
     	LocalDate ld=dateid.getValue();
     	String ca= areasid.getSelectionModel().getSelectedItem();
     	java.sql.Date dt=java.sql.Date.valueOf(ld);
    	try {
    		pst=con.prepareStatement("update customers set mobile=?,spapers=? ,area =?,hawker =?,email =?,address =?,dos =? where cname=?");
    		pst.setString(1, mb);
    		String res=" ";
     		for(String item:items)
        	{
     			res+=item+",";
        	}
     		
     	   pst.setString(2, res);
     		pst.setString(3,ca);
     		pst.setString(4,hawkerid.getText());
     		pst.setString(5, emailid.getText());
     		pst.setString(6, addressid.getText());
     		pst.setDate(7,dt);
     		pst.setString(8,nameid.getText());
    		pst.executeUpdate();
    		lableid.setText("records update");
    		System.out.println("records updated");
    		
    	}
    	catch(SQLException exp )
    	
    	{
    		exp.printStackTrace();
    	}
    }

    @FXML
    void initialize() {
       
        con=MySqlConnector.doConnect();
    	if(con==null)
    		System.out.println("connector problem");
    	else 
    		System.out.println("Connected");
    	list1.getItems().addAll(items);
        list2.getItems().addAll(items2);
    	  list1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
          list2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);  
          
          ArrayList<String>items3=new ArrayList<String>(Arrays.asList("ajit road","model town","adarsh nagar","namdev road",
        		  "ganesha basti","kheta basti","pearl city","Mohammad road"));
          areasid.getItems().addAll(items3);
    }

}
