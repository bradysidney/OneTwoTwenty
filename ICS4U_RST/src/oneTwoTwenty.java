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
	public int randomNum;
	private Label lblNumber;
	
	//TODO: Set each box as a button with a label inside, replace label text with random num when button is clicked
	//Create an array of buttons and labels placed in each box
	
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
		
	
		Button btnReset = new Button("RESET");
		btnReset.setOnAction(event -> gameReset());
		root.add(btnReset, 0, 4, 1, 1);
		
		lblNumber = new Label();
		lblNumber.setFont(Font.font(FONT));
		root.add(lblNumber, 0, 4, 1, 2);
	
		Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
		myStage.setTitle("OneTwoTwenty");
		myStage.setScene(scene);
		myStage.show();
	}
	
	private void playSquare(ActionEvent event) {

		Square temp = (Square.getValue)

		if (temp.getValue() == Square.getValue()) {
			temp.playSquare(Square.getValue());
		}

	}
	
	private void winCheck() {
		for (int row = 0; row < 20; row++) {
			//TODO: IMPLEMENT ALGORITHM TO CHECK IF NEXT NUMBER IS GREATER THAN PREVIOUS, IF YES THEN GAME GOES TILL 20 BOXES OCCUPIED, IF NO THEN GAME LOSS
		}
		
	}
	
	public void gameReset() {
			
			for (int row = 0; row <= 19; row++) {
				root.getChildren().remove(box[row]);
				box[row] = new Square();
				box[row].setOnAction(event -> playSquare(event));
				root.add(box[row], row);
			
			}
			
			lblNumber.setText("___");
	}
	
	public int randomNum() {
		int min = 000; 
	    int max = 999; 
	    
	    randomNum = (int)Math.floor(Math.random() * (max - min + 1) + min);
	    
	    return randomNum;
	}
    
    
	public static void main(String[] args) {
        launch(args);
    }


}	