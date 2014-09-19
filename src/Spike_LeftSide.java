import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Spike_LeftSide {
	private Image SpikeOnLeft;
	private Image SpikeOnRight;
	public static final int Spike_Space = 80;
	public static final int Spike_Speed = 10;
	public static final int WIDTH = 60;
	public static final int HEIGHT = 100;
	private boolean OnLeft = true;
	Random random = new Random();
	public float x;
	public float y;
	public int ry;
	public int rs;
	
	public Spike_LeftSide() throws SlickException {
		 SpikeOnLeft = new Image("res/SpikeLeft.png");
		 SpikeOnRight = new Image("res/SpikeRight.png");
		 this.y = DownGame.GAME_HEIGHT;
		 
	  }
	
	public Spike_LeftSide(float x, float y) throws SlickException {
		 SpikeOnLeft = new Image("res/SpikeLeft.png");
		 SpikeOnRight = new Image("res/SpikeRight.png");
		 this.x = x;
		 this.y = y;
	  }
	
	public void render(){
		if(OnLeft == true){
			SpikeOnLeft.draw(x,y, WIDTH,HEIGHT);
		}
		else if(OnLeft == false){
			SpikeOnRight.draw(x,y, WIDTH,HEIGHT);
		}
	}
	
	public void update(){ 
		
		this.y -= Spike_Speed;
		if(y < 0 && DownGame.getYspikeBefore() < DownGame.GAME_HEIGHT - 800){
	    	this.y = DownGame.GAME_HEIGHT + DownGame.randomNum();
	    	randomSide();
	    }
		
		
	}
	public void randomSide(){
		int rand = random.nextInt(10);
		if(rand%2 == 0){
			OnLeft = true;
			this.x = 0;
			//System.out.println("left");
		}
		else if(rand%2 != 0){
			OnLeft = false;
			this.x = DownGame.GAME_WIDTH/2-WIDTH;
			//System.out.println("right");
		}
	}
	
	
	
	public float getX() { return x; }
	public float getY() { return y; }
	
}
