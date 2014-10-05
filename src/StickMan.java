//import org.newdawn.slick.GameContainer;
//import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class StickMan {
	private Image StickManImage_Left;
	private Image StickManImage_Right;
	private Image StickManImage_JumpfromLeft;
	private Image StickManImage_JumpfromRight;
	public static final int JUMP_SPEED = 16;
	public static final int WIDTH = 90;
	public static final int HEIGHT = 150;
	public float x;
	public float y = DownGame.GAME_HEIGHT/6;
	
	
	
	public StickMan() throws SlickException {
		 StickManImage_Left = new Image("res/StickMan_Left.png");
		 StickManImage_Right = new Image("res/StickMan_Right.png");
		 StickManImage_JumpfromLeft = new Image("res/StickMan_JumpToRight.png");
		 StickManImage_JumpfromRight = new Image("res/StickMan_JumpToLeft.png");
		 
		 
	  }
	 
	 
	  public void render(){
	    if(x == 0){
	    	StickManImage_Left.draw(x,y,WIDTH,HEIGHT);
	    }
	    else if(x > 0 && x <= DownGame.GAME_WIDTH/4){
	    	StickManImage_JumpfromLeft.draw(x,y,WIDTH,HEIGHT);
	    }
	    else if(x > DownGame.GAME_WIDTH/4 && x < DownGame.GAME_WIDTH/2){
	    	StickManImage_JumpfromRight.draw(x-WIDTH,y,WIDTH,HEIGHT);
	    }
	    
	    else if(x == DownGame.GAME_WIDTH/2){
	    	StickManImage_Right.draw(x-WIDTH,y,WIDTH,HEIGHT);
	    }
	  }
	  
	  public void update(){
		  if(x < DownGame.GAME_WIDTH/2 && DownGame.jumpl2r ==1){
			  jumpl2r();
		  }
		  else if(x > 0 && DownGame.jumpr2l == 1){
			  jumpr2l();
		  }
		  if(x > 0 && x < DownGame.GAME_WIDTH/2){
			  DownGame.StickMan1isOnLeft = false;
			  DownGame.StickMan1isOnRight = false;
		  }
		  if(x == DownGame.GAME_WIDTH/2){
			  DownGame.StickMan1isOnRight = true;
		  }
		  if(x == 0){
			  DownGame.StickMan1isOnLeft = true;
		  }
		  if(x == DownGame.GAME_WIDTH/2){
			  DownGame.StickMan1isOnRight = true;
		  }

		  /*if(CollisionDetector.isCollide(x,y,Spike_LeftSide.x,Spike_LeftSide.y) == true){
	    		System.out.println("Collision!!");
		  }*/
	  }
	  
	  public void jumpl2r() {
			  if(x <= DownGame.GAME_WIDTH/2)
				  x += JUMP_SPEED;   
		  }
	  
	  public void jumpr2l() {
			  if(x >0)
				  x -= JUMP_SPEED;
	  }
	  public float getX() { return x; }
	  public float getY() { return y; }
		
	  public boolean isCollide(SpikeonLeftScreen s) {
		  	boolean check = CollisionDetector.isCollide(x, y, s.getX(), s.getY()) || CollisionDetector.isCollideRight(x, y, s.getX(), s.getY());
		    //return CollisionDetector.isCollide(x, y, s.getX(), s.getY());	
		  	return check;
	  }
	  
	  /*public boolean isCollide() {
		    return Triangle.isCollide(x, y);	
	  }*/
	  
	  /*public boolean isCollide(){
		  return Triangle.contains(x,y);
	  }*/
}

