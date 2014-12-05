import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener {
	
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(keycode == KeyEvent.VK_W) Globals.up = true;
		if(keycode == KeyEvent.VK_S) Globals.down = true;
		if(keycode == KeyEvent.VK_D) Globals.right = true;
		if(keycode == KeyEvent.VK_A) Globals.left = true;
		if(keycode == KeyEvent.VK_UP || keycode == KeyEvent.VK_W) Globals.uparrow = true;
		if(keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_S) Globals.downarrow = true;
		if(keycode == KeyEvent.VK_ENTER) Globals.enter = true;
		if(keycode == KeyEvent.VK_ESCAPE) Globals.escape = true;
	}
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(keycode == KeyEvent.VK_W) Globals.up = false;
		if(keycode == KeyEvent.VK_S) Globals.down = false;
		if(keycode == KeyEvent.VK_D) Globals.right = false;
		if(keycode == KeyEvent.VK_A) Globals.left = false;
		if(keycode == KeyEvent.VK_UP || keycode == KeyEvent.VK_W) Globals.uparrow = false;
		if(keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_S) Globals.downarrow = false;
		if(keycode == KeyEvent.VK_ENTER) Globals.enter = false;
		if(keycode == KeyEvent.VK_ESCAPE) Globals.escape = false;
	}
	public void keyTyped(KeyEvent e) {}
}
