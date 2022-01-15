//Robert Yang & Edward Qiao
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Tetromino extends Entity{
	ArrayList<Tile> tetromino = new ArrayList<Tile>();
	boolean isLocked=false;
	
	public Tetromino (int x, int y){
        super(x,y);    
    }
	
	public void moveDown() {
	}
	
	public ArrayList<Tile> sendTile() {
		return tetromino;
	}
	
	public void lock() {
	}
	
	public void keyPressed(KeyEvent e) {
	}
	
}
