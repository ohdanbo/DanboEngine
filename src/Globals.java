import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;


public class Globals {
	public static final String TITLE = "Game Engine";
	public static final int WIDTH = 900;
	public static final int HEIGHT = WIDTH / 16*9;
	public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
	
	public static boolean up, down, left, right, uparrow, downarrow, enter, escape;
	
	public static int STATE = 0;
	
	public static int getStrWidth(Graphics g, String s) {
		AffineTransform af = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(af, true, true);
		
		return (int)g.getFont().getStringBounds(s, frc).getWidth();
	}
}
