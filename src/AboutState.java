import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class AboutState {
	
	private String about = "This is where the description for the game will go!";
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Globals.WIDTH, Globals.HEIGHT);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		int stringWidth = Globals.getStrWidth(g, "About");
		g.drawString("About", (Globals.WIDTH / 2) - (stringWidth / 2),85);
		
		stringWidth = Globals.getStrWidth(g, about);
		g.drawString(about, (Globals.WIDTH / 2) - (stringWidth / 2), 130);
	}
	
	public void update() {
		if(Globals.STATE == 2) {
			if(Globals.escape) {
				Globals.STATE = 0;
			}
		}
	}
}
