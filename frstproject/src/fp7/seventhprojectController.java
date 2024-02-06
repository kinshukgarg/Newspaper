package fp7;

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class seventhprojectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> areaid;

    @FXML
    private Button exportid;

    @FXML
    private Button filter1;

    @FXML
    private Button filter2;

    @FXML
    private ComboBox<String> paperid;

    @FXML
    private TableView<simpleBean> tableid;
    Connection con;
    PreparedStatement pst;

    @FXML
    void exportaction(ActionEvent event) {

    }

    @FXML
    void filter1action(ActionEvent event) {
    	tableid.getColumns().clear();
    	TableColumn<simpleBean, String> mobile=new TableColumn<simpleBean, String>("mobile no ");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	
    	
    	TableColumn<simpleBean, String> name=new TableColumn<simpleBean, String>("customer name ");
    	name.setCellValueFactory(new PropertyValueFactory<>("cname")); 
    	
    	TableColumn<simpleBean, String> paper=new TableColumn<simpleBean, String>("selected paper ");
    	paper.setCellValueFactory(new PropertyValueFactory<>("spapers")); 
    	TableColumn<simpleBean, String> area=new TableColumn<simpleBean, String>("Selected area ");
    	area.setCellValueFactory(new PropertyValueFactory<>("area")); 
    	
    	TableColumn<simpleBean, String> hawker=new TableColumn<simpleBean, String>("hawker name ");
    	hawker.setCellValueFactory(new PropertyValueFactory<>("hawker")); 
    	
    	TableColumn<simpleBean, String> email=new TableColumn<simpleBean, String>("Email ");
    	email.setCellValueFactory(new PropertyValueFactory<>("email")); 
    	
    	TableColumn<simpleBean, String> address=new TableColumn<simpleBean, String>("Address ");
    	address.setCellValueFactory(new PropertyValueFactory<>("address")); 
    	
    	TableColumn<simpleBean, String> dos=new TableColumn<simpleBean, String>("Date ");
    	dos.setCellValueFactory(new PropertyValueFactory<>("dos")); 
    	
    	tableid.getColumns().addAll(new ArrayList<>(Arrays.asList(area,mobile,name,paper,hawker,email,address,dos)));
    	tableid.setItems(Fetchdetail());
    	
    	
    

    }
    ObservableList<simpleBean> Fetchdetail() {  
      	 ObservableList<simpleBean> ary=FXCollections.observableArrayList();
      
      	try
   	{   
       
   		pst=con.prepareStatement("select* from customers where area=?");
   	
   	
   		 String selectedArea=areaid.getValue();
   		 pst.setString(1, selectedArea);
   			ResultSet rs=pst.executeQuery();
      
   		while(rs.next())
   		{
   			 String mb= rs.getString("mobile");
   		   			
   		   			 String name=rs.getString("cname");
   		   			
   		   			   
   					
   					String sp=rs.getString("spapers");
   					String ar=rs.getString("area");
   			    	
   			    	String hawk=rs.getString("hawker");
   			    	String mail=rs.getString("email");
   			    	String ad= rs.getString("address");
   			        String dj =String.valueOf(rs.getDate("dos").toLocalDate());
   		   			 simpleBean ref=new simpleBean(mb,name,sp,ar,hawk,mail,ad,dj);
   		   			 ary.add(ref);
   		}
   	
   		
   	}
      	 
      	 catch(Exception ex)
      	 {
      		 ex.printStackTrace();
      	 }
   		
   		return ary;
    }

    @FXML
    void filter2action(ActionEvent event) {
    	tableid.getColumns().clear();
    	TableColumn<simpleBean, String> mobile=new TableColumn<simpleBean, String>("mobile no ");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	
    	
    	TableColumn<simpleBean, String> name=new TableColumn<simpleBean, String>("customer name ");
    	name.setCellValueFactory(new PropertyValueFactory<>("cname")); 
    	
    	TableColumn<simpleBean, String> paper=new TableColumn<simpleBean, String>("selected paper ");
    	paper.setCellValueFactory(new PropertyValueFactory<>("spapers")); 
    	
    	TableColumn<simpleBean, String> area=new TableColumn<simpleBean, String>("Selected area ");
    	area.setCellValueFactory(new PropertyValueFactory<>("area")); 
    	
    	TableColumn<simpleBean, String> hawker=new TableColumn<simpleBean, String>("hawker name ");
    	hawker.setCellValueFactory(new PropertyValueFactory<>("hawker")); 
    	
    	TableColumn<simpleBean, String> email=new TableColumn<simpleBean, String>("Email ");
    	email.setCellValueFactory(new PropertyValueFactory<>("email")); 
    	
    	TableColumn<simpleBean, String> address=new TableColumn<simpleBean, String>("Address ");
    	address.setCellValueFactory(new PropertyValueFactory<>("address")); 
    	
    	TableColumn<simpleBean, String> dos=new TableColumn<simpleBean, String>("Date ");
    	dos.setCellValueFactory(new PropertyValueFactory<>("dos")); 
    	
    	tableid.getColumns().addAll(new ArrayList<>(Arrays.asList(area,mobile,name,paper,hawker,email,address,dos)));
    	tableid.setItems(Fetchinfo());
    	

    }
    ObservableList<simpleBean> Fetchinfo() {  
      	 ObservableList<simpleBean> arry=FXCollections.observableArrayList();
      
      	try
   	{   

   		pst=con.prepareStatement("select * from customers where customers.spapers like '%"+paperid.getValue()+"%'");
   		System.out.println("query executed");
   		 
   			ResultSet rs=pst.executeQuery();
   		while(rs.next())
   		{   
   			 String mb= rs.getString("mobile");
   		   			
   		   			 String name=rs.getString("cname");
   		   		 String sp=rs.getString("spapers");
   					String ar=rs.getString("area");
   			    	
   			    	String hawk=rs.getString("hawker");
   			    	String mail=rs.getString("email");
   			    	String ad= rs.getString("address");
   			        String dj =String.valueOf(rs.getDate("dos").toLocalDate());
   		   			 simpleBean ref=new simpleBean(mb,name,sp,ar,hawk,mail,ad,dj);
   		   			 arry.add(ref);
   		}
   	
   		
   	}
      	 
      	 catch(Exception ex)
      	 {
      		 ex.printStackTrace();
      	 }
   		
   		return arry;
   	
    }
    @FXML
    void paperaction(ActionEvent event) {
    	 
      
      }
    

    @FXML
    void initialize() {
        assert areaid != null : "fx:id=\"areaid\" was not injected: check your FXML file 'seventhproject.fxml'.";
        assert exportid != null : "fx:id=\"exportid\" was not injected: check your FXML file 'seventhproject.fxml'.";
        assert filter1 != null : "fx:id=\"filter1\" was not injected: check your FXML file 'seventhproject.fxml'.";
        assert filter2 != null : "fx:id=\"filter2\" was not injected: check your FXML file 'seventhproject.fxml'.";
        assert paperid != null : "fx:id=\"paperid\" was not injected: check your FXML file 'seventhproject.fxml'.";
        assert tableid != null : "fx:id=\"tableid\" was not injected: check your FXML file 'seventhproject.fxml'.";
        con=MySqlConnector.doConnect();
    	if(con==null)
    		System.out.println("connector problem");
    	else 
    		System.out.println("Connected");
    	 ArrayList<String>items3=new ArrayList<String>(Arrays.asList("ajit road","model town","adarsh nagar","namdev road","ganesha basti","kheta basti","pearl city","Mohammad road"));
         areaid.getItems().addAll(items3);
        
         ArrayList<String>items=new ArrayList<String>(Arrays.asList("Dainik Jagran","The Tribune","Punjabi Tribune","Punjab kesari","Jag Bani","Ajit","Azad Soch"));
         paperid.getItems().addAll(items);
    }

}

