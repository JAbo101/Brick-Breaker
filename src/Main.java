import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Stage window;
	private final String TITLE = "Brick Breaker";
	protected static final int WIDTH = 480;
	protected static final int HEIGHT = 640;
	
	//Used to init start method 
	public static void main(String[] args) {
		System.out.println("Application Running");
		launch(args);
		
		return;
	}
	
	
	@Override
	public void start(Stage primarystage) throws Exception {
		window = primarystage;
		window.setTitle(TITLE);
		window.setResizable(false);
		window.setWidth(WIDTH);
		window.setHeight(HEIGHT);
		
		//Game init
		gameStart();
		window.show();
	
		//On close
		window.setOnCloseRequest(event -> System.out.println("\n-------\nRuntime ended"));
	}
	
	private void titleScreen() {
		return;
	}
	
	private void gameStart() {
		Pane layout = new Pane();
		
		//background
		Rectangle background = new Rectangle(480, 640);
		background.setFill(Color.rgb(40, 40, 40));
		
		//player
		Bumper bumper = new Bumper();
		
		//Adds objects to layout
		layout.getChildren().addAll(background, bumper.player);
		
		Scene gameScene = new Scene(layout);
		
		//Method References to handle key presses
		gameScene.setOnKeyPressed(Keyboard::onPressed);
		gameScene.setOnKeyReleased(Keyboard::onReleased);
		
		Update timer = new Update(bumper);
		timer.start();
		
		window.setScene(gameScene);
	}
	
	private void gameOver() {
		return;
	}
	
	
	
	

}
