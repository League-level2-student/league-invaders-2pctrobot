import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font subFont = new Font("Arial", Font.PLAIN, 32);
	Timer frameDraw;
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
	public GamePanel(){
		frameDraw = new Timer(1000/60,this);
	}
	
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
		g.drawString("Press ENTER to start", 90, 400);
		g.drawString("Press SPACE for instructions", 35, 600);
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
		
	    if(currentState == MENU){
	        drawMenuState(g);
	    }else if(currentState == GAME){
	        drawGameState(g);
	    }else if(currentState == END){
	        drawEndState(g);
	    }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action");
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	}
}
