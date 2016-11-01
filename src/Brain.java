import javax.swing.JFrame;

public class Brain{
	
	private static int x, y;

	public static void main(String[] args) {

		x = 1000;
		y = 1000;
		Display d = new Display(500, 500);
		JFrame f = new JFrame("Ulam Spiral");
		f.add(d);
		f.setSize(x + 100, y + 100);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
