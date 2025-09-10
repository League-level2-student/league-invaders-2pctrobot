import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	public Projectile(int xs, int ys, int w, int h) {
		super(xs, ys, w, h);
		speed = 10;
	}
	public void update() {
		y-=speed;
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}

}
