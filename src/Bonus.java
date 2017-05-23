import java.util.Random;

/**
 * Created by tristanmenager on 13/04/2017.
 */
public class Bonus  {

    public Bonus(Personnage player) {
    }

    public boolean isBonus() {
        int max = 10;
        int min = 1;
        Random rand = new Random();
        int value = min + rand.nextInt(max - min);
        if (value <= 2) {
            return true;
        }
        return false;
    }
    public int wichBonus() {
        int max = 8;
        int min = 1;
        int bonus = 0;
        Random rand = new Random();
        int value = min + rand.nextInt(max - min);
        switch (value) {
            /*case 1: bonus = 21; // Flamme Bleue : Diminue de 1 la portée des bombes du joueur (minimum 1).
                break;*/
            case 1: bonus = 22; // Flamme Jaune : Augmente de 1 la portée des bombes du joueur (maximum 10).
                break;
            case 2: bonus = 23; // Flamme Rouge : Les bombes du joueur ont une portée de 10.
                break;
            case 3: bonus = 24; // Bombes rouge : Les objets destructibles n'arrêtent plus la portée de l'explosion et il est donc possible de tuer un adversaire derrière un mur.
                break;
            case 4: bonus = 25; // Vie : donne une vie supplémentaire au joueur qui passe dessus.
                break;
            case 5: bonus = 26; // Speed up : augmente la vitesse de déplacement du joueur
                break;
            /*case 7: bonus = 27; // Speed down : diminue la vitesse de déplacement du joueur.
                break;*/
            case 6: bonus = 28; // Bombe plus : Augmente de 2 le nombre maximal de bombes posées que le joueur peut avoir (maximum 7)
                break;
           /* case 9: bonus = 29; // Bombe moins : Diminue de 2 le nombre maximal de bombes posées que le joueur peut avoir (minimum 2)
                break;*/
            case 7: bonus = 29; // shoot : peut shooter la balle
                break;

        }
        return bonus;
    }

    public void showBonus(Labyrinthe laby, int blocX, int blocY) {
        if (isBonus()) {
            int bonus = wichBonus();
            laby.setMap(blocX,blocY, bonus);
        }
    }
    public void takeBonus(Personnage player, Labyrinthe laby, int blocX, int blocY) {
        /*if (laby.getMap()[blocX][blocY] == 21) { //range --
            laby.setMap(blocX,blocY,0);
            if (player.getBombeRange()>1) {
                player.setBombeRange(player.getBombeRange() - 1);
            }
        }*/

        if (laby.getMap()[blocX][blocY] == 29) { // range ++
            laby.setMap(blocX,blocY,0);

            player.setCanPushBomb(true);

        }
        if (laby.getMap()[blocX][blocY] == 22) { // range ++
            laby.setMap(blocX,blocY,0);
            if (player.getBombeRange() < 10) {
                player.setBombeRange(player.getBombeRange()+ 1);
            }
        }
        else if (laby.getMap()[blocX][blocY] == 23) { // range = 10;
            laby.setMap(blocX,blocY,0);
            player.setBombeRange(10);

        }
        else if (laby.getMap()[blocX][blocY] == 24) { // bombe qui traverse
            laby.setMap(blocX,blocY,0);
            player.setCrossWall(true);
        }
        else if (laby.getMap()[blocX][blocY] == 25) { // vie +
            laby.setMap(blocX,blocY,0);
            player.setNbrLife(player.getNbrLife()+1);
        }
        else if (laby.getMap()[blocX][blocY] == 26) { // vitesse
            laby.setMap(blocX,blocY,0);
            if (player.getVitesse() <= 1.5) {
                player.setVitesse(player.getVitesse() + 0.3);
            }
        }
        /*else if (laby.getMap()[blocX][blocY] == 27) { // vitesse -
            laby.setMap(blocX, blocY, 0);
            if (player.getVitesse() >= 0.8) {
                player.setVitesse(player.getVitesse() - 0.3);
            }
        }*/
        else if (laby.getMap()[blocX][blocY] == 28) { // porté +
            laby.setMap(blocX, blocY, 0);
            if (player.getNbrBomb() <= 5) {
                player.setNbrBomb(player.getNbrBomb()+ 2);
            }
        }
       /* else if (laby.getMap()[blocX][blocY] == 29) { // porté -
            laby.setMap(blocX, blocY, 0);
            if (player.getBombeRange() >= 4) {
                player.setBombeRange(player.getBombeRange()- 2);
            }
        }*/
    }


}
