import java.awt.Color;
import java.awt.Graphics;


public class HUD {

	private int hudWidth, hudHeight;
	
	public HUD() {
		hudWidth = Globals.WIDTH + 10;
		hudHeight = 60;
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(0x292929));
		g.fillRect(0, (Globals.HEIGHT+10) - hudHeight, hudWidth, hudHeight);
		
		g.setColor(Color.YELLOW);
		int stringWidth = Globals.getStrWidth(g, "THIS IS THE HUD!");
		g.drawString("THIS IS THE HUD!", (hudWidth / 2) - ((int) stringWidth / 2), (Globals.HEIGHT - hudHeight) + (hudHeight/2) + 14);
	}
	
	public void update() {
		
	}
}
