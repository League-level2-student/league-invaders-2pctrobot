import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive = true;
	Rectangle collisionBox;

	public GameObject(int xs, int ys, int w, int h) {
		x = xs;
		y = ys;
		width = w;
		height = h;
		collisionBox = new Rectangle(x,y,width,height);
		
	}

	public void update() {
		collisionBox.setBounds(x, y, width, height);
		
	}
}
