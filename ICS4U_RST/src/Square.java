import javafx.scene.control.Button;

public class Square extends Button{
	
	public static Square getValue;
	private int value;
	oneTwoTwenty randomNum;
	
	public Square() {
		super();
	}
	
	public void playSquare(int randomNum) {
		value = randomNum;
		
	}
	
	public int getValue() {
		return value;
	}
}