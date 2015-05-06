import java.awt.Color;
import java.awt.Graphics;


public class PlayState {
	
	private HUD hud;
	private Player player;
	
	public PlayState() {
		hud = new HUD();
	}
	
	public void render(Graphics g, Player player) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Globals.screenWidth, Globals.screenHeight);
		player.render(g);
		//hud.render(g);
		this.player = player;
	}
	
	public void update() {
		if(Globals.STATE == 1) {
			if(Globals.escape) {
				player.resetCoords();
				Globals.STATE = 0;
			}
			player.update();
		}
	}
}
