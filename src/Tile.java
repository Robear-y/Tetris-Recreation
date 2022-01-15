import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tile extends Entity{
	int type;
	//boolean update,hasCollided=false;
	
    public Tile (int x, int y,int type){
        super(x,y);
        this.type=type;
    }
	
	public Image getTileImg(){
			ImageIcon ic;
			switch(type) {
				case(0):ic=new ImageIcon("C:\\Users\\rober\\Documents\\Coding\\Side Projects\\Tetris\\block.png");break;
				case(1):ic=new ImageIcon("C:\\Users\\rober\\Documents\\Coding\\Side Projects\\Tetris\\block3.png");break;
				case(2):ic=new ImageIcon("C:\\Users\\rober\\Documents\\Coding\\Side Projects\\Tetris\\block3.png");break;
				case(3):ic=new ImageIcon("C:\\Users\\rober\\Documents\\Coding\\Side Projects\\Tetris\\block2.png");break;
				case(4):ic=new ImageIcon("C:\\Users\\rober\\Documents\\Coding\\Side Projects\\Tetris\\block4.png");break;
				case(5):ic=new ImageIcon("C:\\Users\\rober\\Documents\\Coding\\Side Projects\\Tetris\\block4.png");break;
				case(6):ic=new ImageIcon("C:\\Users\\rober\\Documents\\Coding\\Side Projects\\Tetris\\block5.png");break;
				default: ic=new ImageIcon("C:\\Users\\rober\\Documents\\Coding\\Side Projects\\Tetris\\block.png");
			}
	        
	        return ic.getImage();
	}
	
	public void draw(Graphics2D g2d){
			g2d.drawImage(getTileImg(),x,y,null);
	}
	
	public void moveDown() {
			this.y+=30;
	}
	
	public void moveLeft() {
		this.x-=30;
	}
	
	public void moveRight() {
		this.x+=30;
	}

}
