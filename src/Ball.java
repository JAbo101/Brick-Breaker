import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ball {
	
	protected Rectangle ball;
	
	private final int WIDTH = 10;
	private final int HEIGHT = 10;
	
	private int x = Main.WIDTH/2 - 5, y = 220;
	
	public Ball() {
		ball = new Rectangle(10,10);
		ball.setFill(Color.DARKRED);
		
		
		
		ImageView pressSpace = new ImageView(new Image("File:res\\pressSpaceInstruction.png"));
	}
	
	protected void update() {
		
	}

}
