import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class oneTwoTwenty extends Application{
	
	static final int GAP = 15;
	static final int LARGE_FONT = 30;
	static final int MEDIUM_FONT = 22;
	static final int SMALL_FONT = 4;
	static final int SCREEN_WIDTH = 1600;
	static final int SCREEN_HEIGHT = 900;
	private Square[] box, topBox;
	private GridPane menu, root, inst;
	Tab instTab, menuTab, gameTab;
	public int randomNum;
	private Label lblNumber;
	public Button btnRandomNum, btnReset, btnInst, btnPlay, btnMenu, btnInst2, btnGame2, btnMenu2, btnPlay2;
	TabPane tabs = new TabPane();
	
	public void start(Stage myStage) throws Exception {
		menu = new GridPane();
		root = new GridPane();
		inst = new GridPane();
		root.setHgap(GAP);
		root.setVgap(GAP);
		root.setPadding(new Insets(GAP, GAP, GAP, GAP));
		inst.setHgap(GAP);
    	inst.setVgap(GAP);
		inst.setPadding(new Insets(GAP, GAP, GAP, GAP));
		menu.setHgap(GAP);
    	menu.setVgap(GAP);
		menu.setPadding(new Insets(GAP, GAP, GAP, GAP));
		
		Tab menuTab = new Tab("MENU");
		Tab gameTab = new Tab("GAME");
		Tab instTab = new Tab("INSTRUCTIONS");
		
		menuTab.setClosable(false);
		gameTab.setClosable(false);
		instTab.setClosable(false);
		
		root.setAlignment(Pos.CENTER);
		inst.setAlignment(Pos.CENTER);
		menu.setAlignment(Pos.CENTER);
		menu.setGridLinesVisible(false);
		
		topBox = new Square[20];
		box = new Square[20];
		
		for (int row = 0; row <= 19; row++) {
			
			box[row] = new Square();
			topBox[row] = new Square();
			box[row].setFont(Font.font("Courier New"));
			topBox[row].setFont(Font.font("Courier New"));
			
			topBox[row].setMinWidth(Region.USE_PREF_SIZE);
			topBox[row].setPrefWidth(50);
			
			box[row].setMinWidth(Region.USE_PREF_SIZE);
			box[row].setPrefWidth(50);
			
			box[row].setOnAction(event -> playSquare(event, true));
			root.add(box[row], row, 2);
			root.add(topBox[row], row, 1);
			topBox[row].setText(Integer.toString(row + 1));
			box[row].setDisable(true);
		}
		
		btnMenu = new Button("MENU");
		btnMenu.setOnAction(event -> switchMenu(event));
		btnMenu.setMinWidth(115);
		btnMenu.setFont(Font.font("Courier New"));
		inst.add(btnMenu, 0, 5, 4, 1);
		btnMenu.setTextAlignment(TextAlignment.CENTER);
		
		btnMenu2 = new Button("MENU");
		btnMenu2.setOnAction(event -> switchMenu(event));
		btnMenu2.setMinWidth(115);
		btnMenu2.setFont(Font.font("Courier New"));
		root.add(btnMenu2, 14, 4, 2, 1);
		btnMenu2.setTextAlignment(TextAlignment.CENTER);
		
		btnReset = new Button("RESTART");
		btnReset.setOnAction(event -> gameReset(true));
		btnReset.setMinWidth(115);
		btnReset.setFont(Font.font("Courier New"));
		root.add(btnReset, 16, 4, 2, 1);
		
		btnInst2 = new Button("INSTRUCTIONS");
		btnInst2.setOnAction(event -> switchInst(event));
		btnInst2.setMinWidth(115);
		btnInst2.setFont(Font.font("Courier New"));
		root.add(btnInst2, 18, 4, 2, 1);
		btnInst2.setTextAlignment(TextAlignment.CENTER);
		
		btnRandomNum = new Button("NEW NUMBER");
		btnRandomNum.setOnAction(event -> generateRandomNumber(false));
		btnRandomNum.setMinWidth(115);
		btnRandomNum.setFont(Font.font("Courier New"));
		root.add(btnRandomNum,  0, 4, 2, 1);
		
		btnInst = new Button("INSTRUCTIONS");
		btnInst.setOnAction(event -> switchInst(event));
		btnInst.setMinWidth(115);
		btnInst.setFont(Font.font("Courier New"));
		menu.add(btnInst, 0, 3, 4, 1);
		btnInst.setTextAlignment(TextAlignment.CENTER);
		
		btnPlay = new Button("PLAY");
		btnPlay.setOnAction(event -> switchPlay(event));
		btnPlay.setMinWidth(115);
		btnPlay.setFont(Font.font("Courier New"));
		menu.add(btnPlay, 0, 2, 4, 1);
		btnPlay.setTextAlignment(TextAlignment.CENTER);
		
		btnPlay2 = new Button("PLAY");
		btnPlay2.setOnAction(event -> switchPlay(event));
		btnPlay2.setMinWidth(115);
		btnPlay2.setFont(Font.font("Courier New"));
		inst.add(btnPlay2, 0, 4, 4, 1);
		btnPlay2.setTextAlignment(TextAlignment.CENTER);
		
		lblNumber = new Label();
		lblNumber.setFont(Font.font(MEDIUM_FONT));
		lblNumber.setText("");
		lblNumber.setFont(Font.font("Courier New", 30));
		root.add(lblNumber, 0, 6, 4, 1);
		
		Label lblInst = new Label(instructions());
		lblInst.setFont(Font.font(MEDIUM_FONT));
		lblInst.setFont(Font.font("Courier New", 30));
		lblInst.setTextAlignment(TextAlignment.CENTER);
		inst.add(lblInst, 0, 2);
		
		Image logo = new Image(getClass().getResource("/images/logo").toString());
		ImageView imgLogo = new ImageView(logo);
		imgLogo.setFitWidth(1026.415/7);
		imgLogo.setFitHeight(909.378/7);
		menu.add(imgLogo, 0, 0);
		GridPane.setHalignment(imgLogo, HPos.CENTER);
		
		Image logo2 = new Image(getClass().getResource("/images/logo").toString());
		ImageView imgLogo2 = new ImageView(logo);
		imgLogo2.setFitWidth(1026.415/7);
		imgLogo2.setFitHeight(909.378/7);
		inst.add(imgLogo2, 0, 0);
		GridPane.setHalignment(imgLogo2, HPos.CENTER);
		
		gameTab.setContent(root);
		instTab.setContent(inst);
		menuTab.setContent(menu);
		tabs.getTabs().addAll(menuTab, gameTab, instTab);
		
		Scene scene = new Scene(tabs, 1600, 900);
	
		myStage.setTitle("OneTwoTwenty");
		myStage.setScene(scene);
		myStage.show();
	}
	
	private void playSquare(ActionEvent event, boolean visible) {
	
		Square filled = (Square) event.getSource();
		filled.playSquare(randomNum);
		
		for (int row = 0; row <= 19; row++) {
			
			box[row].setDisable(visible);
		
			}
		btnRandomNum.setDisable(false);
		
	}
	
	private void winCheck() {
		for (int row = 0; row < 20; row++) {
			//TODO: IMPLEMENT ALGORITHM TO CHECK IF NEXT NUMBER IS GREATER THAN PREVIOUS, IF YES THEN GAME GOES TILL 20 BOXES OCCUPIED, IF NO THEN GAME LOSS
		}
		
	}
	
	public void gameReset(boolean visible) {
			
			for (int row = 0; row <= 19; row++) {
				root.getChildren().remove(box[row]);
				box[row].resetSquare();
				root.add(box[row], row, 2);
			
				topBox[row].setMaxWidth(Region.USE_PREF_SIZE);
				topBox[row].setPrefWidth(50);
				
				box[row].setMaxWidth(Region.USE_PREF_SIZE);
				box[row].setPrefWidth(50);
				
				box[row].setDisable(true);
			}
			
			lblNumber.setText("");
			btnRandomNum.setDisable(false);

	}
	
	public int randomNum() {
		int min = 000; 
	    int max = 999; 
	    
	    return (int) (Math.random() * (max - min + 1) + min);
	    
	}
    
	private void generateRandomNumber(boolean visible) {
        randomNum = randomNum();
        lblNumber.setText(Integer.toString(randomNum));
        btnRandomNum.setDisable(true);
        
		for (int row = 0; row <= 19; row++) {
			
			box[row].setDisable(visible);
		
			if (box[row].getFill() == true) {
				box[row].setDisable(true);
			}
		}
	}
	
	public String instructions() {
		return ("You will be given a random number ranging from 000-999\r\n"
				+ "You will choose a box on the table to place your number\r\n"
				+ "The goal is to fill all 20 boxes on the table from lowest to highest\r\n"
				+ "If you cannot place a number in the pattern then the game is over\r\n"
				+ "");
	}
	
	private void switchInst(ActionEvent event) {
		tabs.getSelectionModel().select(2);
	}
	
	private void switchPlay(ActionEvent event) {
		tabs.getSelectionModel().select(1);
	}
	
	private void switchMenu(ActionEvent event) {
		tabs.getSelectionModel().select(0);
	}
	
	public static void main(String[] args) {
        launch(args);
    }


}	