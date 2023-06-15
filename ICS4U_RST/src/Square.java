import javafx.scene.control.Button;
import simpleIO.Console;

public class Square extends Button {
    private int value;
    private boolean isFilled = false;

    public Square() {
        super();
    }

    public void playSquare(int randomNum) {
        value = randomNum;
        this.setText(Integer.toString(value));
        Console.print(value);
        
        isFilled = true;
    }

    public int getValue() {
        return value;
    }
    
    public boolean getFill() {
    	return isFilled;
    }
    
    public void resetSquare() {
    	isFilled = false;
    	this.setText("");
    }
}