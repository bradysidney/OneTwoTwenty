import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import simpleIO.Console;

public class oneTwoTwenty extends Application{
	
	static final int GAP = 15;
	static final int LARGE_FONT = 30;
	static final int MEDIUM_FONT = 22;
	static final int SMALL_FONT = 4;
	static final int SCREEN_WIDTH = 1600;
	static final int SCREEN_HEIGHT = 900;
	private Square[] box, topBox;
	private GridPane menu, game, inst, score;
	Tab instTab, menuTab, gameTab, scoresTab;
	public int randomNum;
	private Label lblNumber, lblLoser, lblLoser2, lblScore, lblGetUser, lblUser, winMsg;
	public Button btnRandomNum, btnReset, btnInst, btnPlay, btnMenu, btnInst2, btnGame2, btnMenu2, btnPlay2, btnSubmit;
	TabPane tabs = new TabPane();
	private int userScore;
    private TextField txtUsername;
	
	public void start(Stage myStage) throws Exception {
		menu = new GridPane();
		game = new GridPane();
		inst = new GridPane();
		score = new GridPane();
		game.setHgap(GAP);
		game.setVgap(GAP);
		game.setPadding(new Insets(GAP, GAP, GAP, GAP));
		inst.setHgap(GAP);
    	inst.setVgap(GAP);
		inst.setPadding(new Insets(GAP, GAP, GAP, GAP));
		menu.setHgap(GAP);
    	menu.setVgap(GAP);
		menu.setPadding(new Insets(GAP, GAP, GAP, GAP));
		score.setHgap(GAP);
    	score.setVgap(GAP);
		score.setPadding(new Insets(GAP, GAP, GAP, GAP));
		
		Tab menuTab = new Tab("MENU");
		Tab gameTab = new Tab("GAME");
		Tab instTab = new Tab("INSTRUCTIONS");
		Tab scoresTab = new Tab("SCORES");
		
		menuTab.setClosable(false);
		gameTab.setClosable(false);
		instTab.setClosable(false);
		scoresTab.setClosable(false);
				
		game.setAlignment(Pos.CENTER);
		inst.setAlignment(Pos.CENTER);
		menu.setAlignment(Pos.CENTER);
		score.setAlignment(Pos.CENTER);
		menu.setGridLinesVisible(false);
		inst.setGridLinesVisible(false);
		game.setGridLinesVisible(false);
		score.setGridLinesVisible(false);
		
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
			game.add(box[row], row, 2);
			game.add(topBox[row], row, 1);
			topBox[row].setText(Integer.toString(row + 1));
			box[row].setDisable(true);
		}
		
		lblGetUser = new Label();
		lblGetUser.setFont(Font.font(MEDIUM_FONT));
		lblGetUser.setText("ENTER USERNAME:");
		lblGetUser.setFont(Font.font("Courier New", 15));
		menu.add(lblGetUser, 0, 2);
		GridPane.setHalignment(lblGetUser, HPos.CENTER);
		
		txtUsername = new TextField();
		txtUsername.setPromptText("(optional)");
		txtUsername.setFont(Font.font("Courier New"));
		txtUsername.setPrefWidth(140);
		GridPane.setHalignment(txtUsername, HPos.CENTER);
		menu.add(txtUsername, 0, 3);
		
		btnSubmit = new Button("PLAY");
		btnSubmit.setOnAction(event -> {switchPlay(event); showUser();});
		btnSubmit.setMinWidth(140);
		btnSubmit.setFont(Font.font("Courier New"));
		menu.add(btnSubmit, 0, 4);
		btnSubmit.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(btnSubmit, HPos.CENTER);
		
		btnMenu = new Button("MENU");
		btnMenu.setOnAction(event -> switchMenu(event));
		btnMenu.setMinWidth(115);
		btnMenu.setFont(Font.font("Courier New"));
		inst.add(btnMenu, 0, 5);
		btnMenu.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(btnMenu, HPos.CENTER);
		
		btnMenu2 = new Button("MENU");
		btnMenu2.setOnAction(event -> switchMenu(event));
		btnMenu2.setMinWidth(115);
		btnMenu2.setFont(Font.font("Courier New"));
		game.add(btnMenu2, 14, 4, 2, 1);
		btnMenu2.setTextAlignment(TextAlignment.CENTER);
		
		btnReset = new Button("RESTART");
		btnReset.setOnAction(event -> gameReset(true));
		btnReset.setMinWidth(115);
		btnReset.setFont(Font.font("Courier New"));
		game.add(btnReset, 16, 4, 2, 1);
		
		btnInst2 = new Button("INSTRUCTIONS");
		btnInst2.setOnAction(event -> switchInst(event));
		btnInst2.setMinWidth(115);
		btnInst2.setFont(Font.font("Courier New"));
		game.add(btnInst2, 18, 4, 2, 1);
		btnInst2.setTextAlignment(TextAlignment.CENTER);
		
		btnRandomNum = new Button("NEW NUMBER");
		btnRandomNum.setOnAction(event -> generateRandomNumber(false));
		btnRandomNum.setMinWidth(115);
		btnRandomNum.setFont(Font.font("Courier New"));
		game.add(btnRandomNum,  0, 4, 2, 1);
		
		btnInst = new Button("INSTRUCTIONS");
		btnInst.setOnAction(event -> switchInst(event));
		btnInst.setMinWidth(140);
		btnInst.setFont(Font.font("Courier New"));
		menu.add(btnInst, 0, 5);
		btnInst.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(btnInst, HPos.CENTER);
		
		btnPlay2 = new Button("PLAY");
		btnPlay2.setOnAction(event -> switchPlay(event));
		btnPlay2.setMinWidth(115);
		btnPlay2.setFont(Font.font("Courier New"));
		inst.add(btnPlay2, 0, 4);
		btnPlay2.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(btnPlay2, HPos.CENTER);
		
		lblNumber = new Label();
		lblNumber.setFont(Font.font(MEDIUM_FONT));
		lblNumber.setText("");
		lblNumber.setFont(Font.font("Courier New", 40));
		game.add(lblNumber, 0, 0, 20, 1);
		GridPane.setHalignment(lblNumber, HPos.CENTER);
		
		lblLoser = new Label();
		lblLoser.setFont(Font.font(60));
		lblLoser.setText("");
		lblLoser.setFont(Font.font("Courier New", 40));
		lblLoser.setTextFill(Color.RED);
		game.add(lblLoser, 0, 0, 20, 1);
		GridPane.setHalignment(lblLoser, HPos.CENTER);
		
		lblLoser2 = new Label();
		lblLoser2.setFont(Font.font(60));
		lblLoser2.setText("");
		lblLoser2.setFont(Font.font("Courier New", 40));
		game.add(lblLoser2, 0, 0, 20, 38);
		GridPane.setHalignment(lblLoser2, HPos.CENTER);
		
		winMsg = new Label();
		winMsg.setFont(Font.font("Courier New", 100));
		winMsg.setTextFill(Color.GREEN);
		game.add(winMsg,  0, 0, 20, 1);
		GridPane.setHalignment(winMsg, HPos.CENTER);
		winMsg.setTextAlignment(TextAlignment.CENTER);
		
		Label lblInst = new Label(instructions());
		lblInst.setFont(Font.font(MEDIUM_FONT));
		lblInst.setFont(Font.font("Courier New", 30));
		lblInst.setTextAlignment(TextAlignment.CENTER);
		inst.add(lblInst, 0, 3);
		GridPane.setHalignment(lblInst, HPos.CENTER);
		
		lblUser = new Label();
		lblUser.setFont(Font.font(MEDIUM_FONT));
		lblUser.setFont(Font.font("Courier New"));
		lblUser.setTextAlignment(TextAlignment.LEFT);
		game.add(lblUser, 2, 4, 2, 1);
		
		lblScore = new Label("SCORE: 0");
		lblScore.setFont(Font.font("Courier New"));
		lblScore.setMinWidth(115);
		game.add(lblScore, 4, 4, 2, 1);
		
		Image logo = new Image(getClass().getResource("/images/logo").toString());
		ImageView imgLogo = new ImageView(logo);
		imgLogo.setFitWidth(1026.415/7);
		imgLogo.setFitHeight(909.378/7);
		menu.add(imgLogo, 0, 0);
		GridPane.setHalignment(imgLogo, HPos.CENTER);
		
		Image logo2 = new Image(getClass().getResource("/images/logo").toString());
		ImageView imgLogo2 = new ImageView(logo2);
		imgLogo2.setFitWidth(1026.415/7);
		imgLogo2.setFitHeight(909.378/7);
		inst.add(imgLogo2, 0, 1);
		GridPane.setHalignment(imgLogo2, HPos.CENTER);
		
		gameTab.setContent(game);
		instTab.setContent(inst);
		menuTab.setContent(menu);
		scoresTab.setContent(score);
		tabs.getTabs().addAll(menuTab, gameTab, instTab, scoresTab);
		
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
		
		lossCheck();
		
		userScore();
		
		if (userScore == 20) {
			for (int row = 0; row <= 19; row++) {
				game.getChildren().remove(box[row]);
				box[row].resetSquare();
				game.add(box[row], row, 2);
			
				topBox[row].setMaxWidth(Region.USE_PREF_SIZE);
				topBox[row].setPrefWidth(50);
				
				box[row].setMaxWidth(Region.USE_PREF_SIZE);
				box[row].setPrefWidth(50);
				
				box[row].setDisable(true);

			}
			
			winMsg.setText("WINNER WINNER\nCHICKEN DINNER!");
			lblLoser2.setText("Press RESTART To Continue.");
			lblLoser2.setDisable(false);
			lblNumber.setText("");
			lblLoser.setText("");
			btnRandomNum.setDisable(true);
			userScore = 0;
			lblScore.setText("SCORE: " + userScore);
		}

	}
	
	private void userScore() {

		userScore++;
		
		lblScore.setText("SCORE: " + userScore);
		Console.print(userScore);

	}
	
	private void lossCheck() {

			
		for (int i = 0; i < 19; i++) {
			
			boolean fails = false;
			
			for (int j = 0; j < i; j++) {
				
				if (box[j].getValue() > box[i].getValue() && box[i].getValue() != 0 && box[j].getValue() != 0) {
					
					fails = true;
					Console.print("fails");
					break;
					
				}
				
			}
			
			if (fails == false) {
				
				for (int j = i + 1; j < 20; j++) {
								
					if (box[j].getValue() < box[i].getValue() && box[i].getValue() != 0 && box[j].getValue() != 0) {
						
						fails = true;
						Console.print("fails");
						break;
						
					}
					
				}
			}

			if (fails) {
				
				game.getChildren().remove(box[i]);
				box[i].resetSquare();
				game.add(box[i], i, 2);
		
				topBox[i].setMaxWidth(Region.USE_PREF_SIZE);
				topBox[i].setPrefWidth(50);
				
				box[i].setMaxWidth(Region.USE_PREF_SIZE);
				box[i].setPrefWidth(50);
				
				box[i].setDisable(true);
				
				lblNumber.setText("");
				btnRandomNum.setDisable(true);
				
				userScore--;
				
				lblLoser.setText("You Lose");
				lblLoser2.setText("Press RESTART To Continue.");
			}
			
		}
		
	}
	
	public void gameReset(boolean visible) {
			
			for (int row = 0; row <= 19; row++) {
				game.getChildren().remove(box[row]);
				box[row].resetSquare();
				game.add(box[row], row, 2);
			
				topBox[row].setMaxWidth(Region.USE_PREF_SIZE);
				topBox[row].setPrefWidth(50);
				
				box[row].setMaxWidth(Region.USE_PREF_SIZE);
				box[row].setPrefWidth(50);
				
				box[row].setDisable(true);

			}
			
			lblNumber.setText("");
			lblLoser.setText("");
			lblLoser2.setText("");
			btnRandomNum.setDisable(false);
			userScore = 0;
			lblScore.setText("SCORE: " + userScore);
			winMsg.setText("");

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
	
	private void showUser() {

		if (txtUsername.getText().length() == 0) {
			lblUser.setText("User: ANON");
			return;
		} 
		
		lblUser.setText("User: " + txtUsername.getText());
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}	