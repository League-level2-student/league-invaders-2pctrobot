import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	public Alien(int xs, int ys, int w, int h) {
		super(xs, ys, w, h);
		speed = 1;
	}
	public void update() {
		y+=speed;
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
	}
}
