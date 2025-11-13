import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship argo;
	Random random;
	ArrayList<Projectile> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<>();
	int timer =0;
	public ObjectManager(Rocketship argo) {
		this.argo = argo;
		
	}

	void addProjectile(Projectile project) {
		projectiles.add(project);
	}

	void addAlien(Alien xeno) {
		random = new Random();
		aliens.add(new Alien(random.nextInt(500), 0, 50, 50));
		
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y >= 800) {
				aliens.get(i).isActive = false;
			}
		}
		remove();
		
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y >= 800) {
				projectiles.get(i).isActive = false;
			}
		}
		remove();
		
		checkCollision();
		remove();
	}
	
	void remove() {
		Iterator<Alien> ita = aliens.iterator();
		while (ita.hasNext()) {
			Alien eachAlien = ita.next();
			if(!eachAlien.isActive) {
				ita.remove();
				
			}
		}
		Iterator<Projectile> itp = projectiles.iterator();
		while (itp.hasNext()) {
			Projectile eachPro = itp.next();
			if(!eachPro.isActive) {
				itp.remove();
				
			}
		}
	}
	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if(argo.collisionBox.intersects(aliens.get(i).collisionBox)) {
				//aliens.get(i).isActive = false;
				argo.isActive = true;
				System.out.println("alright");
			}
			for (int j = 0; j < projectiles.size(); j++) {
				if(aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {
					aliens.get(i).isActive = false;
					projectiles.get(j).isActive = false;
				}
			}
		}
		if(!argo.isActive) {
					System.out.println("good");
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
		Alien morph = new Alien(10, 10, 10, 10);
		addAlien(morph);
		
	}
}
