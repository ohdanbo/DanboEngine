import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player {
	
	private int playerWidth = 20, playerHeight = 20;
	
	private int playerX = (Globals.WIDTH / 2) - (playerWidth / 2), playerY = (Globals.HEIGHT /2) - (playerHeight / 2);
	
	private int speed = 1;
	Rectangle collideyRectangle;
	public Player() {
		collideyRectangle = new Rectangle(0,0,200,200);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(playerX, playerY, playerWidth, playerHeight);
	}
	
	public void update() {
		Rectangle tempRectangle = new Rectangle(playerX, playerY, 20, 20);
		
		
		if(Globals.up) {
			tempRectangle.y -= speed;
			if(tempRectangle.intersects(collideyRectangle) == true){
				return;
			}
			playerY -= speed;
		}
		if(Globals.down) {
			tempRectangle.y += speed;
			if(tempRectangle.intersects(collideyRectangle))return;
			playerY += speed;
		}
		if(Globals.left) {
			tempRectangle.x -= speed;
			if(tempRectangle.intersects(collideyRectangle))return;
			playerX -= speed;
		}
		if(Globals.right) {
			tempRectangle.x += speed;
			
			if(tempRectangle.intersects(collideyRectangle))return;
			playerX += speed;
		}
	}
	
	public void resetCoords() {
		playerX = (Globals.WIDTH / 2) - (playerWidth / 2);
		playerY = (Globals.HEIGHT /2) - (playerHeight / 2)-30;
	}
}
