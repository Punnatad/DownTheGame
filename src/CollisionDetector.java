import org.newdawn.slick.geom.Shape;


public class CollisionDetector {
	
	public Shape triangle = null; 
	
	
	
	
	static boolean isCollide(float stickX, float stickY, float spikeX, float spikeY) {
		//System.out.println("stickY+stickManHEIGHT"+stickY+StickMan.HEIGHT);
	    if(stickX <= spikeX+Spike_LeftSide.WIDTH  && stickX+ StickMan.WIDTH > spikeX){
	    	if(stickY <= spikeY+Spike_LeftSide.HEIGHT/2 + 10 && stickY > spikeY+Spike_LeftSide.HEIGHT/2 - 10){
	    		System.out.println("Collision1");
	    		return true;
	    	}
	    	
	    }
	    
	    //if(stickX + StickMan.WIDTH > spikeX+Spike_LeftSide.WIDTH-10 && stickX + StickMan.WIDTH <= spikeX+Spike_LeftSide.WIDTH ){
	    /*	if(stickY+StickMan.HEIGHT >= spikeY || stickY <= Spike_LeftSide.HEIGHT){
	    		System.out.println("Collision2");
	    		return true;
	    	}*/
	    //}
	   /*
	    if(stickX >= spikeX && stickX <= spikeX + 10 ){
	    	if(stickY+StickMan.HEIGHT >= spikeY || stickY <= Spike_LeftSide.HEIGHT){
	    		System.out.println("Collision3");
	    		return true;
	    	}
	    }*/
	  
	    if(stickX+ StickMan.WIDTH +0.15== DownGame.GAME_WIDTH/2 ){
	    	if(stickY+StickMan.HEIGHT < spikeY+Spike_LeftSide.HEIGHT && stickY+StickMan.HEIGHT >= spikeY || stickY >= spikeY && stickY <= spikeY+ Spike_LeftSide.HEIGHT){
	    		System.out.println("Collision2");
	    		
	    		return true;
	    	}
	    }
	    
	    if(stickX == spikeX  ){
	    	if((stickY+StickMan.HEIGHT < spikeY+Spike_LeftSide.HEIGHT && stickY+StickMan.HEIGHT > spikeY) || (stickY > spikeY && stickY < spikeY+ Spike_LeftSide.HEIGHT)){
	    		System.out.println("Collision3");
	    		return true;
	    	}
	    }
		return false;
	}
	
}
