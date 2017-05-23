import java.util.LinkedList;
import java.util.List;

/**
 * Created by tristanmenager on 04/04/2017.
 */

public class Main {

    public final static int SIZE_PLAYER = 25;
    public final static int SIZE_BOMB = 10;


    public final static double WIN_HEIGHT = 630;
    public final static double WIN_WIDTH = 720;
    public final static int FPS = 1000;
    public final static double SIZE_BLOC = 30;
    public static Labyrinthe laby = new Labyrinthe();
    public StatPlayer statPlayer1;
    public static List<Personnage> listPlayer = new LinkedList<>();
    public static LinkedList<Animation> listAnimationBomb = new LinkedList<>();

    public static boolean animation = true;


    public static void main(String[] args) {
        Window win = new Window();
        Personnage tristan = new Personnage("Tristan");
        Personnage cocos = new Personnage("cocos");
        StatPlayer statPlayer1 = new StatPlayer(tristan);
        StatPlayer statPlayer2 = new StatPlayer(cocos);
        Animation animation = new Animation();

        listPlayer.add(cocos);
        listPlayer.add(tristan);

        win.setWindow();


        while (true) {

            laby.dessineLaby();

            statPlayer1.displayLife(tristan, 1);
            statPlayer2.displayLife(cocos, 2);


            tristan.move(laby);
            cocos.move(laby);

            cocos.dropBomb(laby, System.currentTimeMillis() / 1000);
            tristan.dropBomb(laby, System.currentTimeMillis() / 1000);

            animation.drawSpritePerso(tristan, tristan.getDirectionSprite());
            animation.drawSpritePerso(cocos, cocos.getDirectionSprite());

            if (!listAnimationBomb.isEmpty()) {
                for (int animationBomb = 0; animationBomb < listAnimationBomb.size(); animationBomb++) {
                    if (listAnimationBomb.get(animationBomb) != null) {
                        listAnimationBomb.get(animationBomb).startAnimationBomb();
                    }
                }
            }

            StdDraw.show(1000 / FPS);


            win.exit();

            StdDraw.clear();

        }
    }


}
