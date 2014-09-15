import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class DownGame extends BasicGame{
	public static final int GAME_WIDTH = 640;
    public static final int GAME_HEIGHT = 720;
    private Image BackGroundImage;
    private StickMan stickman;
    
	public DownGame(String title) {
		super(title);
	}
    
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    	BackGroundImage.draw();
    	stickman.render();
      }
   
    @Override
    public void init(GameContainer container) throws SlickException {
      BackGroundImage = new Image("res/BackGroundWallpaper.png");
      stickman = new StickMan();
      
    }
   
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    	
    }
    
	public static void main(String[] args) {
		try {
		      DownGame game = new DownGame("DOWN");
		      AppGameContainer appgc = new AppGameContainer(game);
		      
		      appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
		      appgc.setMinimumLogicUpdateInterval(1000 / 60);
		      appgc.start();
		    } catch (SlickException e) {
		      e.printStackTrace();
		    }

	}

}
