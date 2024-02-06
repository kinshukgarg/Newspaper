package fp6;

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import fp5.MySqlConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class sixprojectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button fetchid;

    @FXML
    private TableView<hawkerBean> tableid;

    @FXML
    void showall(ActionEvent event)
    {
TableColumn<hawkerBean,String>name=new TableColumn<hawkerBean,String>("Hawker Name");
name.setCellValueFactory(new PropertyValueFactory<>("hname"));
TableColumn<hawkerBean,String>mobile=new TableColumn<hawkerBean,String>("Hawker mobile no");
mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
TableColumn<hawkerBean,String>alloareas=new TableColumn<hawkerBean,String>("allocated areas");
alloareas.setCellValueFactory(new PropertyValueFactory<>("alloareas"));
TableColumn<hawkerBean,String>doj=new TableColumn<hawkerBean,String>("date of joining");
doj.setCellValueFactory(new PropertyValueFactory<>("doj"));

   tableid.getColumns().addAll(new ArrayList<>(Arrays.asList(name,mobile,alloareas,doj)));
    doj.setCellValueFactory(new PropertyValueFactory<>("doj"));
   tableid.setItems(FetchAllhawkers());
    }
    Connection con;
    PreparedStatement pst;
    ObservableList<hawkerBean>FetchAllhawkers()
    {
    	ObservableList<hawkerBean> ary=FXCollections.observableArrayList();
    	try {
    		pst=con.prepareStatement("select * from hawkers");
    		ResultSet table=pst.executeQuery();
    		while(table.next())
    		{
    			String mno=table.getString("mobile");
    			String name=table.getString("hname");
    			String DOJ=String.valueOf(table.getDate("doj").toLocalDate());
    			String alloarea=table.getString("alloareas");
    			hawkerBean ref=new hawkerBean(name,mno,alloarea,DOJ);
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
    void initialize() {
       
        con=MySqlConnector.doConnect();
    	if(con==null)
    		System.out.println("connector problem");
    	else 
    		System.out.println("Connected");
    }

}
