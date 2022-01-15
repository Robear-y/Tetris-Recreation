//Robert Yang & Edward Qiao
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener{
	   Timer mainTimer;
	   Random rand = new Random(); 
	   Background background= new Background(0,0);
	   String nextTetro;
	   public int i=0,pieceNum=0, level=1, clearPosition=0,score=0,clearCounter=0,levelUpdater, r=0,nextR=(int)(Math.random()*6);
	   ArrayList<Tetromino> gamePieces = new ArrayList<Tetromino>();  //stores all the tetrominos (tetris blocks) created 
	   static ArrayList<Tile>tiles = new ArrayList<Tile>();
	   public int [] lineFill = new int [20]; //stores the amount of tiles occupied in each line
	
	   public GameFrame(){
	        setFocusable(true);
	        spawnTetro();
	        mainTimer = new Timer(2,this);     
	        mainTimer.start();               
	        for (int i=0; i<20; i++) {
	        	lineFill[i]=0;
	        }
	 }
	   
	 public void spawnTetro() {
		r=nextR;
		nextR=rand.nextInt(7);
		switch(nextR) {
			case 0: nextTetro="Square";break;
			case 1: nextTetro="Rev. L Piece";break;
			case 2: nextTetro="L Piece";break;
			case 3:nextTetro="Line Piece";break;
			case 4:nextTetro="Z Piece";break;
			case 5:nextTetro="Rev. Z Piece";break;
			case 6:nextTetro="T Piece";break;
		}
		Tetromino tetromino;
		switch(r) {
			case 0: tetromino = new Square (150,30);addKeyListener(new KeyAdapt(tetromino));break;
			case 1: tetromino =new ReverseLPiece(150,30);addKeyListener(new KeyAdapt(tetromino));break;
			case 2:tetromino =new LPiece(150,30);addKeyListener(new KeyAdapt(tetromino));break;
			case 3:tetromino =new LinePiece(150,30);addKeyListener(new KeyAdapt(tetromino));break;
			case 4:tetromino =new ZPiece(150,30);addKeyListener(new KeyAdapt(tetromino));break;
			case 5:tetromino =new ReverseZPiece(150,30);addKeyListener(new KeyAdapt(tetromino));break;
			case 6:tetromino =new TPiece(150,30);addKeyListener(new KeyAdapt(tetromino));break;
			default: tetromino = new Square (150,30);addKeyListener(new KeyAdapt(tetromino));break;
		}
	 	gamePieces.add(tetromino);
	 	ArrayList<Tile>tempTiles=tetromino.sendTile();
	 	for(int i=0;i<4;i++) {
			 tiles.add(tempTiles.get(i));
	 	}
		pieceNum++;
	 }
	 
	 public void actionPerformed(ActionEvent arg0){                          
		 i++;
		 Tetromino temp=gamePieces.get(pieceNum-1);
		 if(i==100-level*20) {
			 ArrayList<Tile>tempTiles=temp.sendTile();
			 temp.lock();
			 temp.moveDown();
			 if (temp.isLocked==true) {
				 for(int i=0;i<4;i++) { 
					 if(tempTiles.get(i).y==0) {
						 lineFill[(tempTiles.get(i).y/30)]++;
					 } else {
						 lineFill[(tempTiles.get(i).y/30)-1]++;
					 }
				 }
				 checkEnd();
				 checkLine();
				 score();
				 spawnTetro();
			 }
			 i=0;
		 }
		 repaint(); 
	 }
	 
	 public void score() {
		 switch(clearCounter) { //adds to score based on total lines cleared
		 	case 1: score+=40*(level);break;
		 	case 2: score+=100*(level);break;
		 	case 3: score+=300*(level);break;
		 	case 4: score+=1200*(level);;break;
		 	default: break;
		 }
		 clearCounter=0;
		 
		 if (levelUpdater>=6&&level<10) {
			 levelUpdater-=10;
			 level++;
		 }
	 }
	 
	 public void lineClear(int line) {
		 for (int i=tiles.size()-1; i>=0;i--){
			 if (tiles.get(i).y==(line+1)*30) {
				 tiles.remove(i);
			 }
		 }
		 
	 }
	 
	 public void lineFall(int line) {
		 for (int i=0; i<tiles.size();i++) {
			if (tiles.get(i).y<(line+1)*30) {
				tiles.get(i).moveDown();
				lineFill[((tiles.get(i).y)/30)-2]--;
				lineFill[((tiles.get(i).y)/30)-1]++;
			 }
		}
		 lineFill[line]-=10;
	 }
	 
	 public void checkLine() {
		 for(int i=1;i<20;i++) {
			 if(lineFill[i]==10) {
				 lineClear(i);
				 lineFall(i);
				 clearCounter++;
				 levelUpdater++;
			 }
		 }

	 }
	 
	 public void checkEnd() {
		 if(lineFill[0]>0) {
			 System.exit(0); 
		 }
	 }
	 
	 public void paint(Graphics g){	
	       super.paint(g);
	       Graphics2D g2d  = (Graphics2D) g;  
	       background.draw(g2d);
	       g.drawString("Score: "+score,10,10);
	       g.drawString("Next Piece: "+nextTetro, 100, 10);
	       g.drawString("Level: "+level,250,10);
	       for (int i=0; i<tiles.size(); i++) {
				Tile tempT=tiles.get(i);
				tempT.draw(g2d);		
	       }

	    }

}
