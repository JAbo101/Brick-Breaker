import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

	public class Bumper {
	
		protected Rectangle player;
		private final int WIDTH = 120;
		private final int HEIGHT = 20;
		
		protected int x = Main.WIDTH/2 - this.WIDTH/2;
		protected int y = Main.HEIGHT/2 + 220;
		private int speed = 5;
		
		private boolean hasBegun = false;
		protected boolean isCPU = false;
		
	public Bumper() {
		player = new Rectangle(WIDTH, HEIGHT);
		player.setFill(Color.WHITE);
		
		player.setTranslateX(x);
		player.setTranslateY(y);		
	}
	
	public Bumper(Boolean isCPU) {
		player = new Rectangle(WIDTH, HEIGHT);
		player.setFill(Color.WHITE);
		
		player.setTranslateX(x);
		player.setTranslateY(y);	
		
		isCPU = true;
	}
	
	
	
	
	
	//Called every frame by Update Class
	protected void update() {
		if(!hasBegun) {
			if(Keyboard.spaceKey) {
				hasBegun = true;
			}
		} else {
			player.setTranslateX(x);
			player.setTranslateY(y);
			
			movement();
		}
		
	
	 }
	
	private void movement() {
		if (Keyboard.rightKey && x <= 354) {
			x += speed;
		}
		
		if(Keyboard.leftKey && x >= 0) {
			x -= speed;
		}
	}
	
	protected void updateCPU(int ballX, int ballY, boolean hasTransitioned) {
		if (!hasTransitioned) {
			player.setOpacity(0);
		} else {
			player.setOpacity(1);
			player.setTranslateX(x);
			player.setTranslateY(y);
			
			if(ballX > 60 && ballX < 420) {
				x = ballX - 60;
			}
		}
		
		
	}

}
