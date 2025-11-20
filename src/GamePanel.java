import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;


	
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font subFont = new Font("Arial", Font.PLAIN, 32);
	Rocketship ship = new Rocketship(250, 700, 50, 50);
		ObjectManager obj = new ObjectManager(ship);
	Timer frameDraw;
	Timer alienSpawn;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;

	int currentState = MENU;

	public GamePanel() {
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();

		if (needImage) {
			loadImage("space.png");
		}
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		obj.update();
		ship.update();
		if(ship.alive==55) {
			System.out.println("wow");
			currentState = END;
			
		}
		//startGame();
		//alienSpawn = new Timer(1000/5 , obj);
	}

	public void updateEndState() {

	}
	
	public void startGame() {
		ship = new Rocketship(250, 700, 50, 50);
		obj = new ObjectManager(ship);
		alienSpawn = new Timer(500/5 , obj);
		ship.alive=0;
		ship.isActive=true;
		System.out.println("start");
	    alienSpawn.start();
	    obj.purge();
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 100);
		g.setFont(subFont);
		g.drawString("Press ENTER to start", 90, 400);
		g.drawString("Press SPACE for instructions", 35, 600);
	}

	public void drawGameState(Graphics g) { 
		if (gotImage) {
			g.drawImage(image, 0, 0, 500, 800, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 500, 800);
		}
		obj.draw(g);
	//	startGame();
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				
				currentState = MENU;
				
			} else {
				currentState++;
				
				if(currentState == GAME) {
					startGame();
				}
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.ru = ship.rd == 0 ? -10 : -20;
			System.out.println("1");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.rd = ship.ru == 0 ? 10 : 20;
			System.out.println("2");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.rl = ship.rr == 0 ? -10 : -20;
			//ship.left();
			System.out.println("3");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.rr = ship.rl == 0 ? 10 : 20;
			//ship.right();
			System.out.println("4");
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			obj.addProjectile(ship.getProjectile());
			System.out.println("5");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.ru=0;
			if(ship.rd > 10) {
				ship.rd = 10;
			}
			System.out.println("1");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.rd=0;
			if(ship.ru < -10) {
				ship.ru = -10;
			}
			System.out.println("2");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.rl=0;
			if(ship.rr > 10) {
				ship.rr = 10;
			}
			System.out.println("3");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.rr=0;
			if(ship.rl < -10) {
				ship.rl = -10;
			}
			System.out.println("4");
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			obj.addProjectile(ship.getProjectile());
			System.out.println("5");
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		//System.out.println("action");
		repaint();
	}

}
