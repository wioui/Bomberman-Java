import edu.princeton.cs.introcs.StdDraw;

public class Contours {
	
	private float x;
	private float y;
	private float w;
	private float z;
	
	public Contours(float x, float y, float w, float z) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.z = z;
		
	}
	
	public boolean test(Contours obstacle){
		 if ((this.x  >= obstacle.getX() + obstacle.getW())
	                || (this.x + this.w <= obstacle.getX())
	                || (this.y + this.z <= obstacle.getY())
	                || (this.y >= obstacle.getY() + obstacle.getZ()))
	            return false;
	        else
	            return true;
	    }
	

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	

}
