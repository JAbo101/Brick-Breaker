import javafx.animation.AnimationTimer;

public class Update extends AnimationTimer {
	
	private Bumper player;
	private MainMenu menu;
	private Ball ball;
	
	private boolean menuUpdate = false, gameUpdate = false;
	
	public Update(Bumper player, Ball ball) {
		this.player = player;
		this.ball = ball;
		gameUpdate = true;
	}
	
	public Update(MainMenu menu, Bumper cpuBumper, Ball cpuBall) {
		
		this.player = cpuBumper;
		this.ball = cpuBall;
		this.menu = menu;
		menuUpdate = true;
	}
	
	//Method is run 60 frames per second
	@Override
	public void handle(long now) {
		
		if (gameUpdate) {
			player.update();
			ball.update(player.x);
			return;
		} 
		
		if (menuUpdate) {
			menu.update();
			player.updateCPU(ball.x, ball.y, menu.hasTransitioned);
			ball.cpuUpdate(player.x, menu.hasTransitioned);
			return;
		}
	
		
	}

}
