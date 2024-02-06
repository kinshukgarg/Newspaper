package fp2;

import java.io.File;

import java.io.FileNotFoundException;
import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.io.FileInputStream;
import javafx.scene.control.DatePicker;

import fp1.MySqlConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.time.LocalDate;

public class scndprojectController {
	  
	   @FXML
	    private Label updateidd;
	   @FXML
	    private Label picpathid;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addressid;

    @FXML
    private ImageView adhaarid;

    @FXML
    private TextField allocatedid;

    
    @FXML
    private ImageView childid;
    @FXML
    private DatePicker datepicker;

    @FXML
    private ImageView cycleid;

    @FXML
    private Button enrollid;

    @FXML
    private Button fireid;

    @FXML
    private TextField mobileid;


    @FXML
    private ComboBox<String> areasid;
    @FXML
    private ComboBox<String> nameid;
    @FXML
    private Button newid;

    @FXML
    private Button picid;

    @FXML
    private Button searchid;

    @FXML
    private Button updateid;
    Connection con;
    PreparedStatement pst;
    @FXML
    void nameaction(ActionEvent event) {
    try {
    	pst=con.prepareStatement("select distinct hname from hawkers");
    	ResultSet table=pst.executeQuery();
    	while(table.next())
    	{
    		String name=table.getString("hname");
    		System.out.print(name);
    		nameid.getItems().add(name);
    	}
    }
    catch(Exception exp)
    {
    	System.out.print(exp);
    }
    }

    @FXML
    void areasaction(ActionEvent event) {
    	String area=areasid.getSelectionModel().getSelectedItem()+",";
        
    	if(areasid.getSelectionModel().getSelectedItem()!=null)
    		allocatedid.setText(allocatedid.getText()+area);
    }
    @FXML
    void addressaction(ActionEvent event) {

    }

    @FXML
    void allocatedaction(ActionEvent event) {

    }

    

    @FXML
    void enrollaction(ActionEvent event) {
    String ch=nameid.getSelectionModel().getSelectedItem();
    String mb=String.valueOf(mobileid.getText());
    LocalDate Id=datepicker.getValue();
    java.sql.Date dt=java.sql.Date.valueOf(Id);
    try {
    	pst=con.prepareStatement("insert into hawkers values(?,?,?,?,?,?)");
    	pst.setString(1,ch);
    	pst.setString(2,mb);
    	pst.setString(3,addressid.getText());
    	pst.setString(4,allocatedid.getText());
    	pst.setString(5,picpathid.getText());
    	pst.setDate(6, dt);
    	pst.executeUpdate();
    	updateidd.setText("records saved");
    	
    }
    catch(SQLException exp)
    {
    	exp.printStackTrace();
    }
    }

    @FXML
    void fireaction(ActionEvent event) {
    	try {
    		String ch= nameid.getSelectionModel().getSelectedItem();
    		pst=con.prepareStatement("delete from hawkers where hname=?");
    		pst.setString(1, ch);
    		int count=pst.executeUpdate();
    		if(count!=0)
    		updateidd.setText("records deleted");
    		else
    			updateidd.setText("invalid id");
    			
    		
    	}
    	catch(Exception exp )
    	
    	{
    		System.out.println(exp.toString());
    	}
    }

    @FXML
    void mobileaction(ActionEvent event) {

    }

   

    @FXML
    void newaction(ActionEvent event) {
    	datepicker.getEditor().clear();
    	 mobileid.clear();
    	 addressid.clear();
    	allocatedid.clear();
    	areasid.getItems().clear();
    	nameid.getItems().clear();
    }

    @FXML
    void picaction(ActionEvent event)throws FileNotFoundException {
    FileChooser fileChooser=new FileChooser();
    fileChooser.setTitle("open resource file");
    fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));
    File selectedFile=fileChooser.showOpenDialog(null);
    if(selectedFile!=null)
    {
    	picpathid.setText(selectedFile.getPath());
    	Image img=new Image(selectedFile.toURI().toString());
    	System.out.print(selectedFile.toURI().toString());
    	adhaarid.setImage(new Image(new FileInputStream(selectedFile)));
    	
    }
    else
    {
    	picpathid.setText("no photo");
    }
    }

    @FXML
    void searchaction(ActionEvent event) {
try {
    		
    		pst=con.prepareStatement("select * from hawkers where hname=?");
    		String ch= nameid.getSelectionModel().getSelectedItem();
    		
    		pst.setString(1, ch);
    		ResultSet table =pst.executeQuery();
    		while(table.next())
    		{
    			String  mb=table.getString("mobile");
    	    	String ca= table.getString("address");
    	    	String area=table.getString("alloareas");
    	    	String picpath=table.getString("picpath");
    	    	java.sql.Date dobb=table.getDate("doj");
    	    	mobileid.setText(mb);
    	    	addressid.setText(ca);
    	    	allocatedid.setText(area);
    	    	picpathid.setText(picpath);
    	    	datepicker.setValue(dobb.toLocalDate());
    	    	adhaarid.setImage(new Image(new FileInputStream(picpath)));
    	    	
    		}
    	}
    	catch(Exception exp )
    	
    	{
    		exp.printStackTrace();
    	}
    }

    @FXML
    void updateaction(ActionEvent event) {
    String ch=nameid.getSelectionModel().getSelectedItem();
    String mb=String.valueOf(mobileid.getText());
    LocalDate Id=datepicker.getValue();
    java.sql.Date dt=java.sql.Date.valueOf(Id);
    try {
    	pst=con.prepareStatement("update hawkers set mobile=?,address=?,alloarea=?,picpath=?,doj=?where hname=?");
    	pst.setString(1, mb);
    	pst.setString(2,addressid.getText());
    	pst.setString(3,allocatedid.getText());
    	pst.setString(4,picpathid.getText());
    	pst.setDate(5,dt);
    	pst.setString(6, ch);
    	pst.executeUpdate();
    	updateidd.setText("records update");
    	
    	
    }
    catch(SQLException exp)
    {
    	exp.printStackTrace();
    }
    }

    @FXML
    void initialize() {
        assert addressid != null : "fx:id=\"addressid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert adhaarid != null : "fx:id=\"adhaarid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert allocatedid != null : "fx:id=\"allocatedid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert areasid != null : "fx:id=\"areasid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert childid != null : "fx:id=\"childid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert cycleid != null : "fx:id=\"cycleid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert enrollid != null : "fx:id=\"enrollid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert fireid != null : "fx:id=\"fireid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert mobileid != null : "fx:id=\"mobileid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert nameid != null : "fx:id=\"nameid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert newid != null : "fx:id=\"newid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert picid != null : "fx:id=\"picid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert searchid != null : "fx:id=\"searchid\" was not injected: check your FXML file 'scndproject.fxml'.";
        assert updateid != null : "fx:id=\"updateid\" was not injected: check your FXML file 'scndproject.fxml'.";
        con=MySqlConnector.doConnect();
    	if(con==null)
    			System.out.println("Connection Problem");
    	else
    		System.out.println("Connected");
    	ArrayList<String>items=new ArrayList<String>(Arrays.asList("ajit road ","model town ","adarsh nagar ","namdev road ","ganesha basti ","kheta basti","pearl city","Mohammad road"));
        areasid.getItems().addAll(items);
    }

}
