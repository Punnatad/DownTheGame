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
    private StickMan stickman1;
    private StickMan2 stickman2;
    private static SpikeonLeftScreen[] SpikeLeftSide;
    private static SpikeonRightScreen[] SpikeRightSide;
    public static boolean StickMan1isOnLeft = true;
    public static boolean StickMan1isOnRight = false;
    public static boolean StickMan2isOnLeft = true;
    public static boolean StickMan2isOnRight = false;
    public static int jumpl2r = 0;
    public static int jumpr2l = 0;
    public static int Rjumpl2r = 0;
    public static int Rjumpr2l = 0;
    public static Random random = new Random();
    public static int y;
    public static int Score;
    public static boolean isStarted = false;
    
	public DownGame(String title) {
		super(title);
	}
    
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    	BackGroundImage.draw();
    	g.drawString("SCORE : "+Score, 500, 80);
    	stickman1.render();
    	stickman2.render();
    	for (SpikeonLeftScreen Spike : SpikeLeftSide) {
		      Spike.render();   
		}
    	for (SpikeonRightScreen Spike : SpikeRightSide) {
		      Spike.render();   
		}
    	
    	
      }
   
    @Override
    public void init(GameContainer container) throws SlickException {
      BackGroundImage = new Image("res/BackGroundWallpaper.png");
      stickman1 = new StickMan();
      stickman2 = new StickMan2();
      
      initSpikes();
      initSpikes2();
      
    }
   
    private void initSpikes() throws SlickException{
    	SpikeLeftSide = new SpikeonLeftScreen[3];
	    for (int i = 0; i < 3; i++) {
	    		SpikeLeftSide[i] = new SpikeonLeftScreen();
	    		float randomY = GAME_HEIGHT+randomNum();
	    		if(i>0){
	    			if(SpikeLeftSide[i].getY()-SpikeLeftSide[i-1].getY() <= 100 ){
	    				SpikeLeftSide[i] = new SpikeonLeftScreen(0, randomY+i*500);	
	    			}
	    			else{
	    				SpikeLeftSide[i] = new SpikeonLeftScreen(0, randomY);
	    			}
	    		}
	    		SpikeLeftSide[i].randomSide();
	    		//System.out.println("Spike"+i+" y = "+randomY);
	    }
    }
	   
	    private void initSpikes2() throws SlickException{
	    	SpikeRightSide = new SpikeonRightScreen[3];
		    for (int i = 0; i < 3; i++) {
		    		SpikeRightSide[i] = new SpikeonRightScreen();
		    		float randomY = GAME_HEIGHT+randomNum();
		    		if(i>0){
		    			if(SpikeRightSide[i].getY()-SpikeRightSide[i-1].getY() <= 100 ){
		    				SpikeRightSide[i] = new SpikeonRightScreen(GAME_WIDTH, randomY+i*500);	
		    			}
		    			else{
		    				SpikeRightSide[i] = new SpikeonRightScreen(GAME_WIDTH, randomY);
		    			}
		    		}
		    		SpikeRightSide[i].randomSide();
		    		//System.out.println("Spike"+i+" y = "+randomY);
		    }
		
	}

	@Override
    public void update(GameContainer container, int delta) throws SlickException {
    	if(isStarted == true){
    		stickman1.update();
    		stickman2.update();
    		Score++;
    		for (SpikeonLeftScreen Spike : SpikeLeftSide) {  
    			Spike.update();
    			if(stickman1.isCollide(Spike) == true){
    				//System.out.println("Collision!!");
    				isStarted = false;
    			}
    		}
    		for (SpikeonRightScreen Spike : SpikeRightSide) {  
    			Spike.update();
    			if(stickman2.isCollide(Spike) == true){
    				//System.out.println("Collision!!");
    				isStarted = false;
    			}
    		}
    		
    	}
    	
     }
    
    @Override
	  public void keyPressed(int key, char c) {
    	if (key == Input.KEY_LSHIFT) {
	    	if(StickMan1isOnLeft == true){
	    		jumpl2r=1;
	    		jumpr2l=0;
	    	}
	    
	    	else if(StickMan1isOnRight == true){
	    		jumpl2r=0; 
	    		jumpr2l=1;
	    	}
	    }
    	
    	if (key == Input.KEY_RSHIFT) {
	    	if(StickMan2isOnLeft == true){
	    		Rjumpl2r=1;
	    		Rjumpr2l=0;
	    	}
	    
	    	else if(StickMan2isOnRight == true){
	    		Rjumpl2r=0; 
	    		Rjumpr2l=1;
	    	}
	    }
    	if(key == Input.KEY_ENTER){
    		isStarted = true;
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
	
	public static float getYspikeBefore() {
		return Math.max(SpikeLeftSide[2].y,(Math.max(SpikeLeftSide[0].y, SpikeLeftSide[1].y)));
	}
	public static float getYspikeBefore2() {
		return Math.max(SpikeRightSide[2].y,(Math.max(SpikeRightSide[0].y, SpikeRightSide[1].y)));
	}

	public static float randomNum(){
		return random.nextInt(100);
	}
	
	
	
}
