import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Display extends JPanel{

	/**
	 * Robbie Freeman
	 */
	private static final long serialVersionUID = 4158143881839337207L;
	private int x, y;
	private final int limx;
	private final int limy;
	private int increment = 1;
	private int tally = 0;
	private int direction = 0; //0 is right, 1 is up, 2 is left, 3 is down

	public Display(int x, int y)
	{
		this.x = x;
		this.y = y;
		limx = x;
		limy = y;
	}
	
	private void logicOps(Graphics g){
		increment = 1;
		tally = 0;
		direction = 0; //0 is right, 1 is up, 2 is left, 3 is down
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		for(int n = 1; n < 250000; n++){
			if(isPrime(n) && n > 1){
				g.drawLine(x, y, x, y);
			}
			tally++;
			if(tally == increment){
				changeDirection();
				changeIncrement();
				tally = 0;
			}
			switch(direction){
			case 0: x++;
			break;
			case 1: y--;
			break;
			case 2: x--;
			break;
			case 3: y++;
			break;
			default: System.out.println("direction exceeds 3 :(");
			break;
			}
		};
	}

	public void paintComponent(Graphics g)
	{
		logicOps(g);
	}

	private void changeIncrement(){
		if(direction % 2 == 0){
			increment++;
		}
	}

	private void changeDirection(){
		if(direction != 3){
			direction++;
		}
		else{
			direction = 0;
		}
	}

	private boolean isPrime(int n)
	{
		for(int z = (int) Math.sqrt(n); z > 1; z--){
			if(n % z == 0){
				return false;
			}
		}
		return true;
	}

}
