/**
 * Created by tristanmenager on 06/04/2017.
 */
public class Window extends Main {



    public void setWindow() {
        StdDraw.setCanvasSize((int)WIN_WIDTH,(int)WIN_HEIGHT);
        StdDraw.setYscale(0,WIN_HEIGHT);
        StdDraw.setXscale(-90,WIN_WIDTH-90);
        
    }
    
    public void exit() {
    	if (StdDraw.isKeyPressed(84)) {
    		System.exit(0);
    	}
    		
    }


}
