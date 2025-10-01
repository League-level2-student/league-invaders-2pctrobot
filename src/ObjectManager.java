import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship argo;
	Random random;
	ArrayList<Projectile> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<>();

	public ObjectManager(Rocketship argo) {
		this.argo = argo;
	}

	void addProjectile(Projectile project) {
		projectiles.add(project);
	}

	void addAlien(Alien xeno) {
		aliens.add(new Alien(random.nextInt(500), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).height > 800) {
				aliens.get(i).isActive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).height > 800) {
				projectiles.get(i).isActive = false;
			}
		}
	}

	void draw(Graphics g) {
		argo.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien(null);
	}
}
