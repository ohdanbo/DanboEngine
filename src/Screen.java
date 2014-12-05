import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Screen extends Canvas implements Runnable {

	private boolean running = false;
	private Thread thread;
	private int fps = 0;
	
	private MainMenu menu;
	private PlayState play;
	private AboutState about;

	private Player player;

	public Screen() {
		setMinimumSize(Globals.SIZE);
		setMaximumSize(Globals.SIZE);
		setPreferredSize(Globals.SIZE);
		
		addKeyListener(new Keyboard());
		
		menu = new MainMenu();
		play = new PlayState();
		about = new AboutState();
		
		player = new Player();
	}

	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 250D;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = false;

			while (delta >= 1) {
				ticks++;
				update();
				delta -= 1;
				shouldRender = true;
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				fps = frames;
				frames = 0;
				ticks = 0;
			}
		}
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		requestFocus();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		System.out.println("Shutting down game...");
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		if(Globals.STATE == 0) {
			menu.render(g);
		} else if(Globals.STATE == 1) {
			play.render(g, player);
		} else if(Globals.STATE == 2){
			about.render(g);
		}
		
		
		g.dispose();
		bs.show();
	}

	public void update() {
		if(Globals.STATE == 0) {
			menu.update();
		} else if(Globals.STATE == 1) {
			play.update();
		} else {
			about.update();
		}
	}
}



