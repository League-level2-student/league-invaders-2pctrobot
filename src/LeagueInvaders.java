import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel panel;
	JFrame frame;
	final int WIDTH = 500;
	final int HEIGHT = 800;

	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
	}

	public static void main(String[] args) {

		LeagueInvaders bwoop = new LeagueInvaders();
		bwoop.setup();
	}

	private void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);

	}

}
