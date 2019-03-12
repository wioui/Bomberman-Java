import java.awt.*;
import java.util.LinkedList;

/**
 * Created by tristanmenager on 13/04/2017.
 */
public class Animation extends Main {
    private Bombe bombe;
    private int animationID;


    public Animation(Bombe bombe, int animationID) {
        this.bombe = bombe;
        this.animationID = animationID;
    }

    public void startAnimationBomb() {

        if (this.bombe.getAnimationTime() > System.currentTimeMillis()) {
            if (!this.bombe.getListCoordExplosion().isEmpty()) {
                for (int pos = 0; pos < this.bombe.getListCoordExplosion().size(); pos++) {
                    StdDraw.setPenColor(Color.red);
                    StdDraw.filledSquare(this.bombe.getListCoordExplosion().get(pos)[0] * SIZE_BLOC + (SIZE_BLOC / 2), (this.bombe.getListCoordExplosion().get(pos)[1]* SIZE_BLOC + (SIZE_BLOC / 2)), SIZE_BLOC / 2);
                }
            }
        }
        else {
            Main.listAnimationBomb.set(animationID,null);
        }
    }

}

