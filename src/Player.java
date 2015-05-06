import java.awt.Color;
import java.awt.Graphics;


public class Player {
	
	private int playerWidth = 20, playerHeight = 20;
	
	private int playerX = (Globals.screenWidth / 2) - (playerWidth / 2), playerY = (Globals.screenHeight / 2) - (playerHeight / 2);
	
	private int speed = 1;
	
	public Player() {
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(playerX, playerY, playerWidth, playerHeight);
	}
	
	public void update() {
		if(Globals.up) {
			if(playerY >= 0) {
				playerY -= speed;
			}
		}
		if(Globals.down) {
			if(playerY+playerHeight <= Globals.screenHeight) {
				playerY += speed;
			}
		}
		if(Globals.left) {
			if(playerX >= 0) {
				playerX -= speed;
			}
		}
		if(Globals.right) {
			if(playerX+playerWidth <= Globals.screenWidth) {
				playerX += speed;
			}
		}
	}
	
	public void resetCoords() {
		playerX = (Globals.screenWidth / 2) - (playerWidth / 2);
		playerY = (Globals.screenHeight /2) - (playerHeight / 2)-30;
	}
}
