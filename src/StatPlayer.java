import java.awt.Color;

/**
 * Created by tristanmenager on 07/04/2017.
 */
public class StatPlayer {
    Personnage player ;


    public StatPlayer(Personnage player) {
        this.player = player;
    }

    public void displayLife(Personnage player, int nbrStatPlayer) {
        if (nbrStatPlayer == 1) {
        	StdDraw.setPenColor(Color.BLACK);
            StdDraw.text(-20,620,player.name);
            StdDraw.text(-17,600,String.valueOf("LIFE : "+player.nbrLife));
            StdDraw.text(30,580,String.valueOf("Nombre bombes : "+player.getNbrBomb()));
            StdDraw.text(20,560,String.valueOf("Bombe ranges : "+player.getBombeRange()));
            StdDraw.text(0,540,String.valueOf("Vitesse : "+player.getVitesse()));

        }
        else if (nbrStatPlayer == 2) {
        	StdDraw.setPenColor(Color.BLACK);
            StdDraw.text(500,620,player.name);
            StdDraw.text(502,600,String.valueOf("LIFE : "+player.nbrLife));
            StdDraw.text(550,580,String.valueOf("Nombre bombes : "+player.getNbrBomb()));
            StdDraw.text(540,560,String.valueOf("Bombe ranges : "+player.getBombeRange()));
            StdDraw.text(520,540,String.valueOf("Vitesse : "+player.getVitesse()));
        }
    }


}
