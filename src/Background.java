import java.awt.Graphics2D; 
import java.awt.Image;

import javax.swing.ImageIcon; 

public class Background extends Entity{
	
	public Background(int x, int y) {
		super(x,y);
	}
	
	public Image getImg(){
        ImageIcon ic=new ImageIcon("C:\\Users\\rober\\Documents\\Coding\\Side Projects\\Tetris\\background.png");
        return ic.getImage();
	}
	public void draw(Graphics2D g2d){
		g2d.drawImage(getImg(),x,y,null);
	

}
}
