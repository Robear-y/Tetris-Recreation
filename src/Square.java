//Robert Yang & Edward Qiao
import java.awt.event.KeyEvent;

public class Square extends Tetromino{

	public Square(int x, int y) {
		super(x,y);
		for(int i=0;i<4;i++) {
			switch(i) {
				case(0):Tile one=new Tile(x,y,0);
						tetromino.add(one);
				case(1):Tile two=new Tile(x-30,y,0);
						tetromino.add(two);
				case(2):Tile three=new Tile(x,y+30,0);
						tetromino.add(three);
				case(3):Tile four=new Tile(x-30,30+y,0);
						tetromino.add(four);
			}
			
		}
	}
	
	public void moveDown() {
		if(lowestY()<=600&&isLocked==false) {
			for(int i=0;i<4;i++) {
				Tile temp=tetromino.get(i);
				temp.moveDown();
				//tetromino.get(i).draw(g2d);
			}
			y+=30;
		}
	}
	
	public int lowestY() {
		int lowestY=tetromino.get(0).y;
		for(int i=0;i<4;i++) {
			if(tetromino.get(i).y<lowestY) {
				lowestY=tetromino.get(i).y;
			}
		}

		return lowestY=1;
	}
	
	public boolean checkCollisionLeft() {
        boolean collided=false;
        int hit=0,hitX,hitY;
        if ((tetromino.get(1).x)<=59) {
            collided=true;
        } else {
            for(int i=0;i<4;i++) {
                for(int k=0;k<GameFrame.tiles.size();k++) {
                	if(tetromino.get(i).x-30==GameFrame.tiles.get(k).x&&tetromino.get(i).y==GameFrame.tiles.get(k).y) {
                        hit++;
                        hitX=tetromino.get(i).x-30;
                        hitY=tetromino.get(i).y;
                        for(int j=0;j<4;j++) {
                        	if(hitX==tetromino.get(j).x&&hitY==tetromino.get(j).y) {
                        		hit--;
                        	}
                        }
                    }
                }
            }
            if(hit>0) {
            	collided=true;
            }
        }
        return collided;
    }
	
	public boolean checkCollisionRight() {
        boolean collided=false;
        int hit=0,hitX,hitY;
        if((tetromino.get(1).x)>=279) {
            collided=true;
        } else{
            for(int i=0;i<4;i++) {
                for(int k=0;k<GameFrame.tiles.size();k++) {
                    if(tetromino.get(i).x+30==GameFrame.tiles.get(k).x&&tetromino.get(i).y==GameFrame.tiles.get(k).y) {
                        hit++;
                        hitX=tetromino.get(i).x+30;
                        hitY=tetromino.get(i).y;
                        for(int j=0;j<4;j++) {
                        	if(hitX==tetromino.get(j).x&&hitY==tetromino.get(j).y) {
                        		hit--;
                        	}
                        }
                    }
                }
            }
            if(hit>0) {
            	collided=true;
            }
        }
        return collided;
    }
	
	
	public void lock() {
        int hit=0;
        for(int i=0;i<4;i++) {
            Tile temp=tetromino.get(i);
            if(temp.y>=600) {
                isLocked=true;
            } else {
                for(int k=0;k<GameFrame.tiles.size();k++) {
                    if(temp.y+30==(GameFrame.tiles.get(k).y)&&temp.x==GameFrame.tiles.get(k).x) {
                        hit++;
                        if(hit==2) {
                            isLocked=false;
                        } else {
                            isLocked=true;
                        }
                    }
                }
            }
        }
    }
	
	public void keyPressed(KeyEvent e) {
		 int key = e.getKeyCode();
		 if (key == KeyEvent.VK_A&&isLocked==false){
			if ((checkCollisionLeft())==false) {
				 for(int i=0;i<4;i++) {
					Tile temp=tetromino.get(i);
					temp.moveLeft();
				}
				x-=30;
			} 
		 }
		
		 if (key == KeyEvent.VK_D&&isLocked==false){ 
			 if((checkCollisionRight())==false) {
			 	for(int i=0;i<4;i++) {
			 		Tile temp=tetromino.get(i);
			 		temp.moveRight();
			 	}
			 	x+=30;
			 }
		 }
		 
		 if (key == KeyEvent.VK_S&&isLocked==false){
			 lock();
				if (isLocked==false) {
					 for(int i=0;i<4;i++) {
						Tile temp=tetromino.get(i);
						temp.moveDown();
					}
					y+=30;
				} 
				
		}
		 
		 
	 }
	
	
}