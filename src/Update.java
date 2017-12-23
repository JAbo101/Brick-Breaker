import javafx.animation.AnimationTimer;

public class Update extends AnimationTimer {
	
	private Bumper player;
	
	public Update(Bumper player) {
		this.player = player;
	}
	
	//Method is run 60 frames per second
	@Override
	public void handle(long now) {
		player.update();
		
	}

}
