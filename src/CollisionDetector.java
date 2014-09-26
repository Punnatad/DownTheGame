import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;

public class CollisionDetector {
	
	public static Shape triangle = null;
	
	public void init() throws SlickException {
	    float[] points = new float[]{0,DownGame.GAME_HEIGHT/6 ,0,DownGame.GAME_HEIGHT/6+100, 60,(2*DownGame.GAME_HEIGHT+100)/2 };
		triangle = new Polygon(points);
	}
	
	static boolean isCollide(float stickX,float stickY, float spikeX, float spikeY){
		float x1 = 0; int y1 = DownGame.GAME_HEIGHT/6; int x2 = 0;int y2 = DownGame.GAME_HEIGHT/6+100;int x3 = 60; int y3 = (2*DownGame.GAME_HEIGHT+100)/2;
		float x = stickX; float y = stickY; float p = spikeX; float q = spikeY;
		float denominator = ((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3));
		float a = ((y2 - y3)*(x - x3) + (x3 - x2)*(y - y3)) / denominator;
		float b= ((y3 - y1)*(x - x3) + (x1 - x3)*(y - y3)) / denominator;
		float c = 1 - a - b;
		boolean chk1 = 0 <= a && a <= 1 && 0 <= b && b <= 1 && 0 <= c && c <= 1;
		
		float r = ((y2 - y3)*(p - x3) + (x3 - x2)*(q - y3)) / denominator;
		float s= ((y3 - y1)*(p - x3) + (x1 - x3)*(q - y3)) / denominator;
		float t = 1 - r - s;
		boolean chk2 = 0 <= r && r <= 1 && 0 <= s && s <= 1 && 0 <= t && t <= 1;
		
		return chk1 && chk2;
	}
    
	static boolean isCollideRight(float stickX,float stickY, float spikeX, float spikeY){
		float x1 = 0; int y1 = DownGame.GAME_HEIGHT/6; int x2 = 0;int y2 = DownGame.GAME_HEIGHT/6+100;int x3 = 60; int y3 = (2*DownGame.GAME_HEIGHT+100)/2;
		float x = stickX; float y = stickY; float p = spikeX; float q = spikeY;
		float denominator = ((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3));
		float a = ((y2 - y3)*(x - x3) + (x3 - x2)*(y - y3)) / denominator;
		float b= ((y3 - y1)*(x - x3) + (x1 - x3)*(y - y3)) / denominator;
		float c = 1 - a - b;
		boolean chk1 = 0 <= a && a <= 1 && 0 <= b && b <= 1 && 0 <= c && c <= 1;
		
		float r = ((y2 - y3)*(p - x3) + (x3 - x2)*(q - y3)) / denominator;
		float s= ((y3 - y1)*(p - x3) + (x1 - x3)*(q - y3)) / denominator;
		float t = 1 - r - s;
		boolean chk2 = 0 <= r && r <= 1 && 0 <= s && s <= 1 && 0 <= t && t <= 1;
		
		return chk1 && chk2;
	}
	
}
