import java.awt.Color;
import java.awt.Graphics;


public class Player {
	
	private int playerWidth = 20, playerHeight = 20;
	
	private int playerX = (Globals.WIDTH / 2) - (playerWidth / 2), playerY = (Globals.HEIGHT /2) - (playerHeight / 2);
	
	private int speed = 1;
	
	public Player() {
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(playerX, playerY, playerWidth, playerHeight);
	}
	
	public void update() {
		if(Globals.up) {
			playerY -= speed;
		}
		if(Globals.down) {
			playerY += speed;
		}
		if(Globals.left) {
			playerX -= speed;
		}
		if(Globals.right) {
			playerX += speed;
		}
	}
	
	public void resetCoords() {
		playerX = (Globals.WIDTH / 2) - (playerWidth / 2);
		playerY = (Globals.HEIGHT /2) - (playerHeight / 2)-30;
	}
}
