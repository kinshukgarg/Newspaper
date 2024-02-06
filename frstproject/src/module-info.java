module frstproject {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens fp1 to javafx.graphics, javafx.fxml;
	opens fp2 to javafx.graphics, javafx.fxml;
	opens fp3 to javafx.graphics, javafx.fxml;
	opens fp4 to javafx.graphics, javafx.fxml,javafx.controls;
	opens fp5 to javafx.graphics, javafx.fxml;
	opens fp6 to javafx.graphics, javafx.fxml,javafx.base;
	opens fp7 to javafx.graphics, javafx.fxml,javafx.base;
	opens fp9 to javafx.graphics, javafx.fxml,javafx.base;
	opens fp8 to javafx.graphics, javafx.fxml;
	opens fp10 to javafx.graphics, javafx.fxml;
	opens fp13 to javafx.graphics, javafx.fxml;
	
}
