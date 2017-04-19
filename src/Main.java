import java.util.LinkedList;
import java.util.List;

/**
 * Created by tristanmenager on 04/04/2017.
 */

public class Main {

    public final static int SIZE_PLAYER = 23;
    public final static int SIZE_BOMB = 23/2;

    public final static double WIN_HEIGHT = 640.0;
    public final static double WIN_WIDTH= 640.0;
    public final static int FPS = 1000;
    public final static double SIZE_BLOC = WIN_WIDTH/21;
    public static Labyrinthe laby = new Labyrinthe();
    public StatPlayer statPlayer1;
    public static List<Personnage> listPlayer = new LinkedList<>();
    public static LinkedList<Animation> listAnimationBomb = new LinkedList<>();



    public static void main(String[] args) {
        Window win = new Window();
        Personnage tristan = new Personnage("Tristan");
        Personnage cocos = new Personnage("cocos");
        StatPlayer statPlayer1 = new StatPlayer(tristan);
        StatPlayer statPlayer2 = new StatPlayer(cocos);
        listPlayer.add(cocos);
        listPlayer.add(tristan);


        win.setWindow();


        while (true) {


            StdDraw.clear();

            statPlayer1.displayLife(tristan,1);
            statPlayer2.displayLife(cocos,2);
            tristan.drawPerso(tristan.getPosX(),tristan.getPosY());

            cocos.drawPerso(cocos.getPosX(),cocos.getPosY());
            cocos.move(laby);
            cocos.dropBomb(laby,System.currentTimeMillis()/1000);

            tristan.move(laby);
            tristan.dropBomb(laby, System.currentTimeMillis()/1000);

            if (!listAnimationBomb.isEmpty()) {
                for (int animationBomb = 0; animationBomb < listAnimationBomb.size(); animationBomb++) {
                    if (listAnimationBomb.get(animationBomb)!= null) {
                        listAnimationBomb.get(animationBomb).startAnimationBomb();
                    }
                }
            }

            laby.dessineLaby();
            StdDraw.show(1000/FPS);
        }
    }

}
