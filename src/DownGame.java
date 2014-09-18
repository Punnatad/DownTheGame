import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class DownGame extends BasicGame{
	public static final int GAME_WIDTH = 640;
    public static final int GAME_HEIGHT = 720;
    public static final float JUMP_SPEED = 10;
    private Image BackGroundImage;
    private StickMan stickman;
   // private Spike_LeftSide SpikeLeftSide;
    private Spike_LeftSide[] SpikeLeftSide;
    public static boolean isOnLeft = true;
    public static boolean isOnRight = false;
    public static int jumpl2r = 0;
    public static int jumpr2l = 0;
    public static float delay;
    public static Random random = new Random();
    
	public DownGame(String title) {
		super(title);
	}
    
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    	BackGroundImage.draw();
    	stickman.render();
    	for (Spike_LeftSide Spike : SpikeLeftSide) {
		      Spike.render();
		}
      }
   
    @Override
    public void init(GameContainer container) throws SlickException {
      BackGroundImage = new Image("res/BackGroundWallpaper.png");
      stickman = new StickMan();
      initSpikes();
    }
   
    private void initSpikes() throws SlickException{
    	SpikeLeftSide = new Spike_LeftSide[4];
	    for (int i = 0; i < 4; i++) {
	    		SpikeLeftSide[i] = new Spike_LeftSide();
	    		float randomY = GAME_HEIGHT+randomNum();
	    		SpikeLeftSide[i].randomSide();
	    		SpikeLeftSide[i] = new Spike_LeftSide(0, randomY);	
	    		
	    		System.out.println("Spike"+i+" y = "+randomY);
	    }
	    
		
	}

	@Override
    public void update(GameContainer container, int delta) throws SlickException {
    	stickman.update();
    	for (Spike_LeftSide Spike : SpikeLeftSide) {  
    		Spike.update();
		}
    }
    
    @Override
	  public void keyPressed(int key, char c) {
    	if (key == Input.KEY_LSHIFT) {
	    	if(isOnLeft == true){
	    		jumpl2r=1;
	    		jumpr2l=0;
	    	}
	    
	    	else if(isOnRight == true){
	    		jumpl2r=0; 
	    		jumpr2l=1;
	    	}
	    }
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

	public static float randomNum(){
		return random.nextInt(500)+50;
	}
}
