import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int xspeed = 0;
	int yspeed = 0;
	int ru = 0;
	int rd = 0;
	int rl = 0;
	int rr = 0;
	public Rocketship(int xs, int ys, int w, int h) {
		super(xs, ys, w, h);
		speed = 10;
		if (needImage) {
			loadImage("rocket.png");
		}
	}
	public void update() {
		super.update();
		yspeed=ru+rd;
		xspeed=rr+rl;
		//if(y + yspeed) {
			y+=yspeed;
			x+=xspeed;
		//}
	}
	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

	}
	
	public Projectile getProjectile() {
		return new Projectile(x+width/2,y,10,10);
	}

	public void right() {
		x += speed;
	}

	public void left() {
		x -= speed;
	}

	public void down() {
		y += speed;
	}

	public void up() {
		y -= speed;
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

}
