import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font subFont = new Font("Arial", Font.PLAIN, 32);
	public void updateMenuState() {  
		
	}
	public void updateGameState() {  
		
	}
	public void updateEndState() {  
		
	}
	public void drawMenuState(Graphics g) {  
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 100);
		g.setFont(subFont);
		g.drawString("Press ENTER to start", 100, 400);
	}
	public void drawGameState(Graphics g) {  
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
	}
	public void drawEndState(Graphics g) {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
	}
	
	
	public void paintComponent(Graphics g){
		g.fillRect(10, 10, 100, 100);
		final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	    if(currentState == MENU){
	        drawMenuState(g);
	    }else if(currentState == GAME){
	        drawGameState(g);
	    }else if(currentState == END){
	        drawEndState(g);
	    }
	}
}
