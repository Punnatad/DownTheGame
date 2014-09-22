import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;

public class CollisionDetector {
	
	public static Shape triangle = null;
	
	public void init() throws SlickException {
	    float[] points = new float[]{0,DownGame.GAME_HEIGHT/6 ,0,DownGame.GAME_HEIGHT/6+100, 60,(2*DownGame.GAME_HEIGHT+100)/2 };
		triangle = new Polygon(points);
	}
    
	/*public boolean contains(double x, double y)
	{
	    if (this.contains(x, y))
	    {
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}*/
	
	/*static boolean isCollide(float stickX, float stickY, float spikeX, float spikeY) {
		if(triangle.contains(stickX,stickY)){
			System.out.println("coliision1");
			return true;
		}
		return false;
	}*/
}
