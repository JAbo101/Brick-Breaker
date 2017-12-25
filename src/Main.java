import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Stage window;
	private final String TITLE = "Brick Breaker";
	protected static final int WIDTH = 480;
	protected static final int HEIGHT = 640;
	
	protected static boolean mainMenu = false;
	protected static boolean inGame = false;
	
	private static Update menuTimer, gameTimer;
	private static Pane titleLayout, gameLayout;
	private static Scene mainMenuScene, gameScene;
	private static MainMenu menu;
	
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
		
		titleScreen();
		
		//Game init
		//gameStart();
		window.show();
	
		//On close
		window.setOnCloseRequest(event -> System.out.println("\n-------\nRuntime ended"));
	}
	
	private static void titleScreen() {
		titleLayout = new Pane();
		
		menu = new MainMenu();
		Ball cpuBall = new Ball(true);
		Bumper cpuBumper = new Bumper(true);
		
		titleLayout.getChildren().addAll(menu.background, cpuBall.ball, menu.title, menu.startGame, menu.highscores, menu.options, menu.exitGame, cpuBumper.player);
		
		mainMenuScene = new Scene(titleLayout);
		mainMenuScene.setOnKeyPressed(Keyboard::onPressed);
		mainMenuScene.setOnKeyReleased(Keyboard::onReleased);
		
		
		menuTimer = new Update(menu, cpuBumper, cpuBall);
		
		menuTimer.start();
		window.setScene(mainMenuScene);
		
	}
	
	
	protected static void gameStart() {
		try {
			//Cleans up Menu from memory
			titleLayout = null;
			mainMenuScene = null;
			menu = null;
			
			menuTimer.stop();
			menuTimer = null;
			
			System.gc();
		}catch(Exception e) {};
		
		
		Pane gameLayout = new Pane();
		
		//background
		Rectangle background = new Rectangle(480, 640);
		background.setFill(Color.rgb(40, 40, 40));
		
		//player
		Bumper bumper = new Bumper();
		Ball ball = new Ball();
		
		//Adds objects to layout
		gameLayout.getChildren().addAll(background, bumper.player, ball.ball, ball.pressSpace);
		
		Scene gameScene = new Scene(gameLayout);
		
		//Method References to handle key presses
		gameScene.setOnKeyPressed(Keyboard::onPressed);
		gameScene.setOnKeyReleased(Keyboard::onReleased);
		
		gameTimer = new Update(bumper, ball);
		gameTimer.start();
		
		window.setScene(gameScene);
	}
	
	private void gameOver() {
		return;
	}
	
	
	
	

}
