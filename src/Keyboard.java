import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Keyboard {
	
	protected static boolean rightKey = false;
	protected static boolean leftKey = false;
	protected static boolean upKey = false;
	protected static boolean downKey = false;
	protected static boolean enterKey = false;
	protected static boolean spaceKey = false;
	//add Up and down
	
	
	protected static void onPressed(KeyEvent event) {
		if(event.getCode() == KeyCode.RIGHT) {
			rightKey = true;
			
		}
		
		if(event.getCode() == KeyCode.LEFT) {
			leftKey = true;
			
		}
		
		if(event.getCode() == KeyCode.UP) {
			upKey = true;
			
		}
		
		if(event.getCode() == KeyCode.DOWN) {
			downKey = true;
		}
		
		if(event.getCode() == KeyCode.ENTER) {
			enterKey = true;
		}
		
		if(event.getCode() == KeyCode.SPACE) {
			spaceKey = true;
		}
		
	
	}
	
	
	
	protected static void onReleased(KeyEvent event) {
		if(event.getCode() == KeyCode.RIGHT) {
			rightKey = false;
			
		}
		
		if(event.getCode() == KeyCode.LEFT) {
			leftKey = false;
		}
		
		if(event.getCode() == KeyCode.UP) {
			upKey = false;
		}
		
		if(event.getCode() == KeyCode.DOWN) {
			downKey = false;
		}
		
		if(event.getCode() == KeyCode.ENTER) {
			enterKey = false;
		}
		
		if(event.getCode() == KeyCode.SPACE) {
			spaceKey = false;
		}
		
	}
	

}
