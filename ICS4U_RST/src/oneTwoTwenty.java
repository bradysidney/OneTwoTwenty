import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class oneTwoTwenty {
	
	static final int GAP = 15;
	static final int LARGE_FONT = 30;
	static final int MEDIUM_FONT = 22;
	static final int SMALL_FONT = 14;
	static final int SCREEN_WIDTH = 1920;
	static final int SCREEN_HEIGHT = 1080;
	private Square[] box;
	private GridPane root; 
	
	public void start(Stage myStage) throws Exception {
		root = new GridPane();
		root.setHgap(GAP);
		root.setVgap(GAP);
		root.setPadding(new Insets(GAP, GAP, GAP, GAP));
		root.setAlignment(Pos.CENTER);
		
		box = new Square[20];
		
		for (int row = 0; row <= 19; row++) {
			box[row] = new Square();
			box[row].setOnAction(event -> playSquare(event));
			root.add(box[row], row);
		}
	}
	
	
	
	
	
}	