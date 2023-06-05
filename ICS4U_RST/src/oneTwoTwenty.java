import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
	
	gamePlayer player;
	
	TextField placement;
	Button btnNewNum, btnRestart, btnExit

	public void start(Stage myStage) throws Exception {
		
GridPane root = new GridPane();
    	
    	root.setHgap(GAP);
    	root.setVgap(GAP);
		root.setPadding(new Insets(GAP, GAP, GAP, GAP));
		
		GridPane inst = new GridPane();
    	
    	inst.setHgap(GAP);
    	inst.setVgap(GAP);
		inst.setPadding(new Insets(GAP, GAP, GAP, GAP));
		
		TabPane tabs = new TabPane();
		
		Tab gameTab = new Tab("Game");
		Tab instTab = new Tab("Instructions");
		
		gameTab.setClosable(false);
		instTab.setClosable(false);
		
		player = new gamePlayer();
		
	}
	
}