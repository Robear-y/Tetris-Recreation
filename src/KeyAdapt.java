//Robert Yang & Edward Qiao
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {
	Tetromino t;   

	public KeyAdapt(Tetromino tetromino) {
		t=tetromino;   
	}


	public void keyPressed(KeyEvent e){
		t.keyPressed(e);    
	}

}
