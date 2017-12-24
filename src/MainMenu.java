import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;

public class MainMenu {
	
	protected ImageView title, startGame, highscores, options, exitGame;
	protected Rectangle background;
	
	private double titleOpacity = 0, startGameOpacity = 0, highscoresOpacity = 0, optionsOpacity = 0, exitGameOpacity = 0; 
	
	private boolean hasTransitioned = false, hasChosen = false;
	
	private int choiceIndex = 0;
	private int blinkerCounter = 30;
	private boolean keyRelease = true;
	
	public MainMenu() {
		title = new ImageView(new Image("File:res\\BrickBreaker.png"));
		title.setOpacity(titleOpacity);
		title.setX(Main.WIDTH/2 - 374/2);
		title.setY(340);
		
		
		
		startGame = new ImageView(new Image("File:res\\StartGame.png"));
		startGame.setX(Main.WIDTH/2 - 147/2);
		startGame.setY(250);
		startGame.setOpacity(startGameOpacity);
		
		highscores = new ImageView(new Image("File:res\\highscores.png"));
		highscores.setX(Main.WIDTH/2 - 147/2);
		highscores.setY(300);
		highscores.setOpacity(highscoresOpacity);
		
		
		options = new ImageView(new Image("File:res\\Options.png"));
		options.setX(Main.WIDTH/2 - 102/2);
		options.setY(350);
		options.setOpacity(optionsOpacity);
		
		exitGame = new ImageView(new Image("File:res\\ExitGame.png"));
		exitGame.setX(Main.WIDTH/2 - 132/2);
		exitGame.setY(400);
		exitGame.setOpacity(exitGameOpacity);
		
		
		background = new Rectangle(480, 640);
		background.setFill(Color.rgb(40, 40, 40));
	}
	
	protected void update() {
		if (!hasTransitioned) {
			transition();
		} else if (!hasChosen){
			
			control();
			blinkerCounter -= 1;
			if(blinkerCounter <= 0) {
				selections();
				blinkerCounter = 30;
			}
			
		}
		
		
		
		title.setOpacity(titleOpacity);
		startGame.setOpacity(startGameOpacity);
		highscores.setOpacity(highscoresOpacity);
		options.setOpacity(optionsOpacity);
		exitGame.setOpacity(exitGameOpacity);
	
		
		
	}
	
	private void transition() {
		if (title.getY() != 20 ) {
			title.setY(title.getY() - 5);
			
			if(titleOpacity != 100) {
				titleOpacity += .02;
			}
		} else if(exitGameOpacity < 1 ){
			
			startGameOpacity += .015;
			highscoresOpacity += .015;
			optionsOpacity += .015;
			exitGameOpacity += .015;
			
		} else {
			hasTransitioned = true;
		}
		
	}
	
	private void control() {
		
		if (keyRelease) {
			if(Keyboard.upKey && choiceIndex != 0) {
				choiceIndex -= 1;
				blinkerCounter = 0;
				keyRelease = false;
				
			} else if(Keyboard.downKey) {
				choiceIndex += 1;
				blinkerCounter = 0;
				keyRelease = false;
			
			} else if(Keyboard.enterKey) {
				if(choiceIndex == 0) {
					Main.gameStart();
				} else if(choiceIndex == 3) {
					System.out.println("\n-------\nRuntime ended");
					System.exit(0);
					return;
				}
			}
			
			
			
		} else if(!Keyboard.upKey && !Keyboard.downKey) {
			keyRelease = true;
			
		} 
		
		

		
	}
	
	
	private void selections() {
		if (choiceIndex == 0) {
			if (startGameOpacity >= 1) {
				startGameOpacity = 0;
			} else {
				startGameOpacity = 1;
			}
			
		} else {
			startGameOpacity = 1;
		}
		
		
		if (choiceIndex == 1) {
			if (highscoresOpacity >= 1) {
				highscoresOpacity = 0;
			} else {
				highscoresOpacity = 1;
			}
		} else {
			highscoresOpacity = 1;
		}
		
		
		if (choiceIndex == 2) {
			if (optionsOpacity >= 1) {
				optionsOpacity = 0;
			} else {
				optionsOpacity = 1;
			}
		} else {
			optionsOpacity = 1;
		}
		
		
		if (choiceIndex == 3) {
			if (exitGameOpacity >= 1) {
				exitGameOpacity = 0;
			} else {
				exitGameOpacity = 1;
			}
		} else {
			exitGameOpacity = 1;
		}
		
	}
	
	

}
