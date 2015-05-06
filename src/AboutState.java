import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class AboutState {
	
	private String about = "This is where the description for the game will go!";
	
	public void render(Graphics g) {
		g.setColor(new Color(0x1a2328));
		g.fillRect(0, 0, Globals.screenWidth, Globals.screenHeight);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		int stringWidth = Globals.getStrWidth(g, "About");
		g.drawString("About", (Globals.screenWidth / 2) - (stringWidth / 2),85);
		
		stringWidth = Globals.getStrWidth(g, about);
		g.drawString(about, (Globals.screenWidth / 2) - (stringWidth / 2), 130);
	}
	
	public void update() {
		if(Globals.STATE == 2) {
			if(Globals.escape) {
				Globals.STATE = 0;
			}
		}
	}
}
