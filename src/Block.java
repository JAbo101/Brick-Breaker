import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block {
	
	private int hardness;
	private int colorLevel;
	protected int x, y;
	protected Rectangle unit;
	
	public Block(int x, int y) {
		unit = new Rectangle(40,40);
		
		Random rand = new Random();
		this.hardness = rand.nextInt(10);
		rand = null;
		setColor();
		
		this.x = x; 
		this.y = y;
		unit.setTranslateX(this.x);
		unit.setTranslateY(this.y);
	}
	
	private void setColor() {
		if(hardness == 0 || hardness == 1 || hardness == 2 || hardness == 3 || colorLevel == 1) {
			unit.setFill(Color.rgb(255, 255, 255));
			colorLevel = 1;
		} else if(hardness == 4 || hardness == 5 || hardness == 6 || colorLevel == 2) {
			unit.setFill(Color.rgb(255, 200, 200));
			colorLevel = 2;
		} else if(hardness == 7 || hardness == 8 || colorLevel == 3) {
			unit.setFill(Color.rgb(255, 100, 100));
			colorLevel = 3;
		} else if(hardness == 9) {
			unit.setFill(Color.rgb(150, 0, 0));
			colorLevel = 4;
		}
	}
	
	protected String onHit() {
		colorLevel -= 1;
		
		if(colorLevel == 0 ) {
			unit.setVisible(false);
			//unit = null;
			return "BROKEN";
		}
		
		setColor();
		return "";
		
	}
	
	
}