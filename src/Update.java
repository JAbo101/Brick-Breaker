import javafx.animation.AnimationTimer;

public class Update extends AnimationTimer {
	
	private Bumper player;
	private MainMenu menu;
	
	public Update(Bumper player) {
		this.player = player;
	}
	
	public Update(MainMenu menu) {
		this.menu = menu;
	}
	
	//Method is run 60 frames per second
	@Override
	public void handle(long now) {
		
		if (menu != null) {
			menu.update();
			return;
		}
		
		if (player != null) {
			player.update();
		} 
		
		
	}

}
