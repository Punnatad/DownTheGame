import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;


public class Triangle { 
	
	private static float [] points = new float [] {0, DownGame.GAME_HEIGHT/6 , 
										0 , 
										DownGame.GAME_HEIGHT/6+100 , 
										60 , 
										(2*DownGame.GAME_HEIGHT+100)/2 };
	public static Shape triangle = new Polygon(points);
	
	public boolean contains(float x, float y)
	{
	    if (triangle.contains(x, y))
	    {
	    	System.out.println("collision1");
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}

	public static boolean isCollide(float x, float y) {
		if(triangle.contains(x,y)){
			System.out.println("collision1");
			return true;
		}
		return false;
	}
	
	}
