import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ball {
	
	protected Rectangle ball;
	
	private final int WIDTH = 10;
	private final int HEIGHT = 10;
	
	protected int x = Main.WIDTH/2 - 5, y = Main.HEIGHT/2 + 210;
	private int xDirection;
	private int yDirection = -5;
	private int[] directions = {-5,5};
	
	protected ImageView pressSpace;
	private int msgBlinker = 30;
	private double msgOpacity = 1;
	
	private boolean hasBegun = false;
	private int paddleX;
	
	private ArrayList<Block> blocks;
	private ArrayList<Block> broken = new ArrayList<Block>();
	
	public Ball(ArrayList<Block> blocks) {
		ball = new Rectangle(10,10);
		ball.setFill(Color.DARKRED);
		
		ball.setTranslateX(x);
		ball.setTranslateY(y);
		
		
		pressSpace = new ImageView(new Image("File:res\\pressSpaceInstruction.png"));
		pressSpace.setX(Main.WIDTH/2 - 297/2);
		pressSpace.setY(Main.HEIGHT/2 + 140);
		
		pressSpace.setScaleX(.5);
		pressSpace.setScaleY(.5);
		
		this.blocks = blocks;
		
	}
	
	public Ball(Boolean isCPU) {
		ball = new Rectangle(10,10);
		ball.setFill(Color.DARKRED);
		
		ball.setTranslateX(x);
		ball.setTranslateY(y);
		 
		Random rand = new Random();
		xDirection = directions[rand.nextInt(2)];
		
		hasBegun = true;
	}
	
	protected void update(int paddleX) {
		if(!hasBegun) {
			if(Keyboard.spaceKey) {
				
				pressSpace.setVisible(false);
				Random rand = new Random();
				xDirection = directions[rand.nextInt(2)];
				hasBegun = true;
			}
			
			pressSpace.setOpacity(msgOpacity);
			msgBlinker -= 1;
			
			if(msgBlinker == 0) {
				
				if(msgOpacity == 1) {
					msgOpacity = 0;
				} else {
					msgOpacity = 1;
				}
				msgBlinker = 30;
				
			}
			return;
			
		} else {
			pressSpace.setOpacity(0);
			this.paddleX = paddleX;
			y += yDirection;
			x += xDirection;
				
			ball.setTranslateX(x);
			ball.setTranslateY(y);
			wallCollision();
			paddleCollision();
			
			blockCollision();
		}
	}
	
	protected void cpuUpdate(int paddleX, boolean hasTransitioned) {
		if (!hasTransitioned) {
			ball.setOpacity(0);
		} else {
			ball.setOpacity(1);
			this.paddleX = paddleX;
			y += yDirection;
			x += xDirection;
				
			ball.setTranslateX(x);
			ball.setTranslateY(y);
			wallCollision();
			paddleCollision();	
		}
		
		}
	
	private void wallCollision() {
		if(x >= 480) {
			xDirection = xDirection * -1;
		} else if (x <= 0) {
			xDirection = xDirection * -1;
		}
		
		if(y <= 0) {
			yDirection = yDirection * -1;
		} else if (y >= 640) {
			//Insert Game over 
			Main.gameOver();
			return;
		}
	}
	
	private void paddleCollision() {
		if (y >= Main.HEIGHT/2 + 215 && y <= Main.HEIGHT/2 + 216 && x >= paddleX && x <= paddleX + 120) {
			if (x < paddleX + 60) {
				if(xDirection == 5) {
					xDirection = xDirection * -1;
				}
			} else if (x > paddleX + 60) {
				if (xDirection == -5) {
					xDirection = xDirection * -1;
				}
			}
			
			yDirection = yDirection * -1;
			
		} else if (y >= Main.HEIGHT/2 + 216 && y <= Main.HEIGHT/2 + 240 && x >= paddleX - 5 && x <= paddleX + 125) {
			xDirection = xDirection *  -1;
		}
	}
	
	private void blockCollision() {
		if (y < Main.HEIGHT/2) {
			for(Block item : blocks) {
				
				//If touching a block
				if(x >= item.x && x <= item.x + 40) {
					if(y >= item.y && y <= item.y + 40) {
						
						//On Side of Block
						if(x == item.x || x == item.x + 40) {
							xDirection = xDirection * -1;
						
						//On Top or bottom of Block	
						} else if(y == item.y || y == item.y + 40) {
							yDirection = yDirection * -1;
						}
						
						if(item.onHit() == "BROKEN") {
							broken.add(item);
						}
						
						
					}
					
				}
				
			}
			blocks.removeAll(broken);
			broken.clear();
		}
		
	}

}
