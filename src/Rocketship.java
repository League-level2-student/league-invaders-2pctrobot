import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int xs, int ys, int w, int h) {
		super(xs, ys, w, h);
		speed = 5;
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	public void right() {
        x+=speed;
    }
	public void left() {
        x-=speed;
    }
	public void down() {
        y+=speed;
    }
	public void up() {
        y-=speed;
    }

}
