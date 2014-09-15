import org.newdawn.slick.GameContainer;
//import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class StickMan {
	private Image StickManImage;
	public static final int WIDTH = 90;
	public static final int HEIGHT = 150;
	
	public StickMan() throws SlickException {
		 StickManImage = new Image("res/StickMan_Left.png");
	  }
	 
	 
	  public void render(){
	    StickManImage.draw(0,DownGame.GAME_HEIGHT/6,WIDTH,HEIGHT);
	  }
	 
	  
	  public void update(GameContainer container, int delta) throws SlickException {
	     
	  }
}
