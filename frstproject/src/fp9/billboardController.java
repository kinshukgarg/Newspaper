package fp9;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class billboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button billid;

    @FXML
    private Button exportid;

    @FXML
    private TextField mobileid;

    @FXML
    private RadioButton paid;

    @FXML
    private RadioButton penid;

    @FXML
    private Button searchid;

    @FXML
    private TableView<planeBean> tableid;

    @FXML
    private TextField totalid;

    @FXML
    void billaction(ActionEvent event) {
    	tableid.getColumns().clear();
    	TableColumn<planeBean, String> mobile=new TableColumn<planeBean, String>("mobile no ");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	
    	TableColumn<planeBean, String> datefrom=new TableColumn<planeBean, String>("Date From ");
    	datefrom.setCellValueFactory(new PropertyValueFactory<>("datefrom"));
    	

    	TableColumn<planeBean, String> dateto=new TableColumn<planeBean, String>("Date to");
    	dateto.setCellValueFactory(new PropertyValueFactory<>("dateto"));
    	

    	TableColumn<planeBean, String> bill=new TableColumn<planeBean, String>("Bill ");
    	bill.setCellValueFactory(new PropertyValueFactory<>("bill"));
    	

    	TableColumn<planeBean, String> billstatus=new TableColumn<planeBean, String>("Bill status");
    	billstatus.setCellValueFactory(new PropertyValueFactory<>("billstatus"));
    	
    	tableid.getColumns().addAll(new ArrayList<>(Arrays.asList(mobile,datefrom,dateto,bill,billstatus)));
    	tableid.setItems(Fetchin());

    }
    ObservableList<planeBean>Fetchin(){
    	 ObservableList<planeBean> ary=FXCollections.observableArrayList();
    	 try {
 			
				pst=con.prepareStatement("select * from bills where bills.mobile like '%"
				+mobileid.getText()+"%'");
		   		System.out.println("query executed");
		   		ResultSet rs=pst.executeQuery();
  
		    
			while(rs.next())
			{   String bs=rs.getString("billstatus");
				String mb=rs.getString("mobile");
				String ds=rs.getString("datefrom");
			String dt=	rs.getString("dateto");
			float bil=	Float.parseFloat(rs.getString("bill"));
      float totalbill=0;
		      totalbill+=bil;
		  totalid.setText(Float.toString(totalbill));
		 planeBean ref=new planeBean(mb,ds,dt,Float.toString(bil),bs);
			 ary.add(ref);	
			}
			
		}
	catch(Exception exp)
	{
		exp.printStackTrace();
	}
		
	
	return ary;
    }

    @FXML
    void exportaction(ActionEvent event) {

    }

    @FXML
    void paaction(ActionEvent event) {

    }

    @FXML
    void penaction(ActionEvent event) {

    }

    @FXML
    void searchaction(ActionEvent event) {
    	tableid.getColumns().clear();
    	TableColumn<planeBean, String> mobile=new TableColumn<planeBean, String>("mobile no ");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	
    	TableColumn<planeBean, String> datefrom=new TableColumn<planeBean, String>("Date From ");
    	datefrom.setCellValueFactory(new PropertyValueFactory<>("datefrom"));
    	

    	TableColumn<planeBean, String> dateto=new TableColumn<planeBean, String>("Date to");
    	dateto.setCellValueFactory(new PropertyValueFactory<>("dateto"));
    	

    	TableColumn<planeBean, String> bill=new TableColumn<planeBean, String>("Bill ");
    	bill.setCellValueFactory(new PropertyValueFactory<>("bill"));
    	

    	TableColumn<planeBean, String> billstatus=new TableColumn<planeBean, String>("Bill status");
    	billstatus.setCellValueFactory(new PropertyValueFactory<>("billstatus"));
    	
    	tableid.getColumns().addAll(new ArrayList<>(Arrays.asList(mobile,datefrom,dateto,bill,billstatus)));
    	tableid.setItems(Fetchinfo());
    	
    	
    }
    
    Connection con;
    PreparedStatement pst;
  
     ObservableList<planeBean> Fetchinfo() {
    	 
    	 ObservableList<planeBean> arry=FXCollections.observableArrayList();
    	 if(paid.isSelected())
			{  
		try
		{  
			
			pst=con.prepareStatement("select * from bills where bills.billstatus like '%1%'");
	   		System.out.println("query executed");
	   		ResultSet rs=pst.executeQuery();
	   	
	   	  
   			while(rs.next())
   			{   String bs=rs.getString("billstatus");
   				String mb=rs.getString("mobile");
   				String ds=rs.getString("datefrom");
   			String dt=	rs.getString("dateto");
   			
   			float bil=	Float.parseFloat(rs.getString("bill"));
         float totalbill=0;
		      totalbill+=bil;
		  
  			
   		 	totalid.setText(Float.toString(totalbill));
   		 planeBean ref=new planeBean(mb,ds,dt,Float.toString(bil),bs);
   			 arry.add(ref);	
   			}
   	
		}
	catch(Exception exp)
	{
		exp.printStackTrace();
	}
			}
	
	
	 
			
			else if(penid.isSelected())
			{  
				try {
			
					pst=con.prepareStatement("select * from bills where bills.billstatus like '%0%'");
			   		System.out.println("query executed");
			   		ResultSet rs=pst.executeQuery();

			  	 
	   			while(rs.next())
	   			{   String bs=rs.getString("billstatus");
	   				String mb=rs.getString("mobile");
	   				String ds=rs.getString("datefrom");
	   			String dt=	rs.getString("dateto");
	   			
	   			float bil=	Float.parseFloat(rs.getString("bill"));
				     float totalbill=0;
			      totalbill+=bil;
            totalid.setText(Float.toString(totalbill));
	   		 planeBean ref=new planeBean(mb,ds,dt,Float.toString(bil),bs);
	   			 arry.add(ref);	
	   			}
	   		
			}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
			}
		
		return arry;
    }

    @FXML
    void initialize() {
        assert billid != null : "fx:id=\"billid\" was not injected: check your FXML file 'billboard.fxml'.";
        assert exportid != null : "fx:id=\"exportid\" was not injected: check your FXML file 'billboard.fxml'.";
        assert mobileid != null : "fx:id=\"mobileid\" was not injected: check your FXML file 'billboard.fxml'.";
        assert paid != null : "fx:id=\"paid\" was not injected: check your FXML file 'billboard.fxml'.";
        assert penid != null : "fx:id=\"penid\" was not injected: check your FXML file 'billboard.fxml'.";
        assert searchid != null : "fx:id=\"searchid\" was not injected: check your FXML file 'billboard.fxml'.";
        assert tableid != null : "fx:id=\"tableid\" was not injected: check your FXML file 'billboard.fxml'.";
        assert totalid != null : "fx:id=\"totalid\" was not injected: check your FXML file 'billboard.fxml'.";
    	con=MySqlConnector.doConnect();
    	if(con==null)
    		System.out.println("connector problem");
    	else 
    		System.out.println("Connected");
    }

}
