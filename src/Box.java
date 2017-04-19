/**
 * Created by tristanmenager on 05/04/2017.
 */
public class Box extends Main {
    private double x;
    private double y;
    private double h;
    private double w;


    public Box(double x, double y, double h,double w) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }

    public boolean collision(Box box2) {
        if ((this.x  >= box2.getX() + box2.getW())
                || (this.x + this.w <= box2.getX())
                || (this.y + this.h <= box2.getY())
                || (this.y >= box2.getY() + box2.getH()))
            return false;
        else
            return true;
    }

    public double getX() {
        return x;
    }
    public double getH() {
        return h;
    }
    public double getW() {
        return w;
    }
    public double getY() {
        return y;
    }
}
