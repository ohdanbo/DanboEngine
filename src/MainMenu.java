import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainMenu {

	private Color hoverColor = Color.GREEN;

	private boolean playHover = true, aboutHover = false, exitHover = false;
	
	private final int width = Globals.WIDTH + 10;
	private final int height = Globals.HEIGHT + 10;
	
	private BufferedImage logo, play, about, exit;
	
	public MainMenu() {
		try {
			logo = ImageIO.read(getClass().getResource("logo.png"));
			play = ImageIO.read(getClass().getResource("play.png"));
			about = ImageIO.read(getClass().getResource("about.png"));
			exit = ImageIO.read(getClass().getResource("exit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(0x1a2328));
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.WHITE);

		g.drawImage(logo, (width/2)-(logo.getWidth()/2), 50, null);
		
//		g.drawImage(play, (width/2)-(play.getWidth()/2), 180, null);
//		g.drawImage(about, (width/2)-(about.getWidth()/2), 190, null);
//		g.drawImage(exit, (width/2)-(exit.getWidth()/2), 230, null);

		drawButtons(g);
	}

	public void drawButtons(Graphics g) {
		if (playHover) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			int strWidth = Globals.getStrWidth(g, "Play");
			g.drawString("Play", (width / 2) - (strWidth / 2), 180);

			g.setColor(Color.WHITE);
			strWidth = Globals.getStrWidth(g, "About");
			g.drawString("About", (width / 2) - (strWidth / 2), 215);

			strWidth = Globals.getStrWidth(g, "Exit");
			g.drawString("Exit", (width / 2) - (strWidth / 2), 245);
		} else if (aboutHover) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			int strWidth = Globals.getStrWidth(g, "Play");
			g.drawString("Play", (width / 2) - (strWidth / 2), 180);

			g.setColor(Color.GREEN);
			strWidth = Globals.getStrWidth(g, "About");
			g.drawString("About", (width / 2) - (strWidth / 2), 215);

			g.setColor(Color.WHITE);
			strWidth = Globals.getStrWidth(g, "Exit");
			g.drawString("Exit", (width / 2) - (strWidth / 2), 245);
		} else if(exitHover) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			int strWidth = Globals.getStrWidth(g, "Play");
			g.drawString("Play", (width / 2) - (strWidth / 2), 180);

			g.setColor(Color.WHITE);
			strWidth = Globals.getStrWidth(g, "About");
			g.drawString("About", (width / 2) - (strWidth / 2), 215);

			g.setColor(Color.GREEN);
			strWidth = Globals.getStrWidth(g, "Exit");
			g.drawString("Exit", (width / 2) - (strWidth / 2), 245);
		}
	}

	public void update() {
		if(playHover) {
			if(Globals.enter) {
				Globals.STATE = 1;
			}
			if(Globals.uparrow) {
				playHover = false;
				aboutHover = false;
				exitHover = true;
				Globals.uparrow = false;
			}
			if(Globals.downarrow) {
				playHover = false;
				aboutHover = true;
				exitHover = false;
				Globals.downarrow = false;
			}
		} else if(aboutHover) {
			if(Globals.enter) {
				Globals.STATE = 2;
			}
			if(Globals.uparrow) {
				playHover = true;
				aboutHover = false;
				exitHover = false;
				Globals.uparrow = false;
			}
			if(Globals.downarrow) {
				playHover = false;
				aboutHover = false;
				exitHover = true;
				Globals.downarrow = false;
			}
		} else if(exitHover) {
			if(Globals.enter) {
				System.exit(0);
			}
			if(Globals.uparrow) {
				playHover = false;
				aboutHover = true;
				exitHover = false;
				Globals.uparrow = false;
			}
			if(Globals.downarrow) {
				playHover = true;
				aboutHover = false;
				exitHover = false;
				Globals.downarrow = false;
			}
		}
	}
}
