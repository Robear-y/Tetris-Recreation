//Robert Yang & Edward Qiao
import javax.swing.JFrame;

public class TetrisMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tetris");	
		frame.setSize(365,685);			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
		frame.setResizable(false);				
		frame.add(new GameFrame());			
 		frame.setVisible(true);				

	}

}
