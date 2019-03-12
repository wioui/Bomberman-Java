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
            StdDraw.text(50,620,player.name);
            StdDraw.text(52,600,String.valueOf("LIFE : "+player.nbrLife));
            StdDraw.text(100,580,String.valueOf("Nombre bombes : "+player.getNbrBomb()));
            StdDraw.text(90,560,String.valueOf("Bombe ranges : "+player.getBombeRange()));
            StdDraw.text(70,540,String.valueOf("Vitesse : "+player.getVitesse()));

        }
        else if (nbrStatPlayer == 2) {
            StdDraw.text(500,620,player.name);
            StdDraw.text(502,600,String.valueOf("LIFE : "+player.nbrLife));
            StdDraw.text(550,580,String.valueOf("Nombre bombes : "+player.getNbrBomb()));
            StdDraw.text(540,560,String.valueOf("Bombe ranges : "+player.getBombeRange()));
            StdDraw.text(520,540,String.valueOf("Vitesse : "+player.getVitesse()));
        }
    }


}
