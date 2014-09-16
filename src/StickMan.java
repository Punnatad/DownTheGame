//import org.newdawn.slick.GameContainer;
//import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class StickMan {
	private Image StickManImage;
	public static final int WIDTH = 90;
	public static final int HEIGHT = 150;
	private float x;
	//private float vx = 10;
	
	
	public StickMan() throws SlickException {
		 StickManImage = new Image("res/StickMan_Left.png");
		 this.x = 0;
		 
	  }
	 
	 
	  public void render(){
	    StickManImage.draw(x,DownGame.GAME_HEIGHT/6,WIDTH,HEIGHT);
	  }
	 
	  
	  public void update(){
		  if(x < DownGame.GAME_WIDTH/2 && DownGame.jumpl2r ==1){
			 
			  jumpl2r();
		  }
		  else if(x > 0 && DownGame.jumpr2l ==1){
			 
			  jumpr2l();
		  }
		  if(x > 0 && x < DownGame.GAME_WIDTH/2){
			  DownGame.isOnLeft = false;
			  DownGame.isOnRight = false;
		  }
		  if(x == DownGame.GAME_WIDTH/2){
			  DownGame.isOnRight = true;
		  }
		  if(x == 0){
			  DownGame.isOnLeft = true;
		  }
	  }
	  
	  public void jumpl2r() {
		  //if(DownGame.isOnLeft == true){
			/*while(true){
				 x+=1;
				 if(x == DownGame.GAME_WIDTH/2){
					 break;
				 }
			 }*/
			  if(x <= DownGame.GAME_WIDTH/2)
				  x+=10;
			   
		  }
		 /* else if(DownGame.isOnLeft == false){
			  	x -= DownGame.GAME_WIDTH/2;
		  }*/
	  public void jumpr2l() {
		  //if(DownGame.isOnLeft == true){
			/*while(true){
				 x+=1;
				 if(x == DownGame.GAME_WIDTH/2){
					 break;
				 }
			 }*/
			  if(x >0)
				  x-=10;
			   
		  }
		 /* else if(DownGame.isOnLeft == false){
			  	x -= DownGame.GAME_WIDTH/2;
		  }*/
	  }

