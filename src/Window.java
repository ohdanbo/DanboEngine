import javax.swing.JFrame;

public class Window {
	public static void main(String[] args) {
		JFrame f = new JFrame(Globals.TITLE);
		Screen screen = new Screen();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(screen);
		f.pack();
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		screen.start();
	}
}