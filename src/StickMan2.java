import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class StickMan2 {
	private Image StickManImage_Left;
	private Image StickManImage_Right;
	private Image StickManImage_JumpfromLeft;
	private Image StickManImage_JumpfromRight;
	public static final int JUMP_SPEED = 16;
	public static final int WIDTH = 90;
	public static final int HEIGHT = 150;
	public float x = DownGame.GAME_WIDTH/2;
	public float y = DownGame.GAME_HEIGHT/6;
	
	
	
	public StickMan2() throws SlickException {
		 StickManImage_Left = new Image("res/StickMan_Left.png");
		 StickManImage_Right = new Image("res/StickMan_Right.png");
		 StickManImage_JumpfromLeft = new Image("res/StickMan_JumpToRight.png");
		 StickManImage_JumpfromRight = new Image("res/StickMan_JumpToLeft.png");
		 //this.x = 0;
		 
	  }
	 
	 
	  public void render(){
	    if(x == DownGame.GAME_WIDTH/2){
	    	StickManImage_Left.draw(x,y,WIDTH,HEIGHT);
	    }
	    else if(x > DownGame.GAME_WIDTH/2 && x <= 3*DownGame.GAME_WIDTH/4){
	    	StickManImage_JumpfromLeft.draw(x,y,WIDTH,HEIGHT);
	    }
	    else if(x > 3*DownGame.GAME_WIDTH/4 && x < DownGame.GAME_WIDTH){
	    	StickManImage_JumpfromRight.draw(x-WIDTH,y,WIDTH,HEIGHT);
	    }
	    
	    else if(x == DownGame.GAME_WIDTH){
	    	StickManImage_Right.draw(x-WIDTH,y,WIDTH,HEIGHT);
	    }
	  }
	  
	  public void update(){
		  if(x < DownGame.GAME_WIDTH && DownGame.Rjumpl2r == 1){
			  Rjumpl2r();
		  }
		  else if(x > 0 && DownGame.Rjumpr2l == 1){
			  Rjumpr2l();
		  }
		  if(x > DownGame.GAME_WIDTH/2 && x < DownGame.GAME_WIDTH){
			  DownGame.StickMan2isOnLeft = false;
			  DownGame.StickMan2isOnRight = false;
		  }
		  if(x == DownGame.GAME_WIDTH){
			  DownGame.StickMan2isOnRight = true;
		  }
		  if(x == DownGame.GAME_WIDTH/2){
			  DownGame.StickMan2isOnLeft = true;
		  }
		  if(x == DownGame.GAME_WIDTH){
			  DownGame.StickMan2isOnRight = true;
		  }

		  /*if(CollisionDetector.isCollide(x,y,Spike_LeftSide.x,Spike_LeftSide.y) == true){
	    		System.out.println("Collision!!");
		  }*/
	  }
	  
	  public void Rjumpl2r() {
			  if(x <= DownGame.GAME_WIDTH)
				  x += JUMP_SPEED;   
		  }
	  
	  public void Rjumpr2l() {
			  if(x > DownGame.GAME_WIDTH/2)
				  x -= JUMP_SPEED;
	  }
	  public float getX() { return x; }
	  public float getY() { return y; }
		
	  public boolean isCollide(SpikeonRightScreen s) {
		  	boolean check = CollisionDetector.isCollide2(x, y, s.getX(), s.getY()) || CollisionDetector.isCollideRight2(x, y, s.getX(), s.getY());
		    //return CollisionDetector.isCollide(x, y, s.getX(), s.getY());	
		  	return check;
	  }
	  
}
